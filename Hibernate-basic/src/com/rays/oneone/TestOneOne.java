package com.rays.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneOne {

	public static void main(String[] args) {

		Address eAddress = new Address();

		eAddress.setId(1);
		eAddress.setStreet("street");
		eAddress.setCity("indore");

		Employe e = new Employe();

		e.setId(1);
		e.setName("aman");
		e.setEmpAddress(eAddress);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(e);

		tx.commit();

		session.close();
	}
}
