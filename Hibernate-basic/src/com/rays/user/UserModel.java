package com.rays.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.exception.DublicateRecordException;

public class UserModel {

	public int add(UserDTO dto) throws DublicateRecordException {

		UserDTO existDto = findByLogin(dto.getLoginId());

		if (existDto != null) {

			throw new DublicateRecordException("LoginId already exist");
		}

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();
		session.close();

		return dto.getId();

	}

	public UserDTO findByLogin(String login) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.eq("loginId", login));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);
		}

		return dto;
	}

	public UserDTO authenticate(String login, String password) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.eq("loginId", login));
		criteria.add(Restrictions.eq("password", password));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {

			dto = new UserDTO();
			dto = list.get(0);
		}
		return dto;
	}
	
	public UserDTO authenticate1(String login, String password) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		 Query q = session.createQuery("from UserDTO where loginId=? and Password=?");
		 
		 q.setString(0, login);
		 q.setString(1, password);

		List<UserDTO> list = q.list();

		if (list.size() == 1) {

			dto = new UserDTO();
			dto = list.get(0);
		}
		return dto;
	}
}
