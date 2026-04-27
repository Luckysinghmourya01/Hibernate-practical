package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.subclass.Payment;
// bina update method call kiya update kr skte h

public class TestDirtyCheck {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();
		
	Transaction tx = 	session.beginTransaction();

	Payment payment = (Payment)	session.get(Payment.class, 1);
		
		payment.setAmountType("online");
		
		tx.commit();
		
		session.close();
	}
}
