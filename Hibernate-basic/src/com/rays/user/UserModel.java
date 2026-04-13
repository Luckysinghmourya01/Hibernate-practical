package com.rays.user;

import java.util.ArrayList;
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

	public void update(UserDTO dto) throws DublicateRecordException {

		UserDTO existDto = findByLogin(dto.getLoginId());

		if (existDto != null && !(existDto.getId() == dto.getId())) {

			throw new DublicateRecordException("Login id already exist");
		}

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();

		session.close();

	}

	public void delete(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();

		session.close();

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

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		List<UserDTO> list = new ArrayList<UserDTO>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		/* select * from st user where 1=1 */
		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if(dto.getLastName() != null && dto.getLastName().length() >0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if(dto.getPassword() != null && dto.getPassword().length() >0) {
				criteria.add(Restrictions.eq("password", dto.getPassword() ));
			}
			if(dto.getLoginId() != null && dto.getLoginId().length() >0) {
				criteria.add(Restrictions.like("loginId", dto.getLoginId()  ));
			}
		}
		
		if(pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
			
		list = 	criteria.list();
		
		
		}
		
		return list;

	}
}
