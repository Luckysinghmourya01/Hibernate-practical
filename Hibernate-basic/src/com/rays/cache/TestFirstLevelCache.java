package com.rays.cache;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestFirstLevelCache {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		UserDTO dto = (UserDTO) session.get(UserDTO.class, 1);

		System.out.print("\t" + dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLoginId());
		System.out.print("\t" + dto.getPassword());
		System.out.print("\t" + dto.getDob());
		System.out.println("\t" + dto.getAddress());

		//session.evict(dto); //evict method clear the object from firstLevel cache mean data ko clear krti h

		
		

		UserDTO dto1 = (UserDTO) session.get(UserDTO.class, 1);

		System.out.print("\t" + dto1.getId());
		System.out.print("\t" + dto1.getFirstName());
		System.out.print("\t" + dto1.getLastName());
		System.out.print("\t" + dto1.getLoginId());
		System.out.print("\t" + dto1.getPassword());
		System.out.print("\t" + dto1.getDob());
		System.out.print("\t" + dto1.getAddress());
		
		tx.commit();
		
		session.close();

	}
}
