package com.rays.subclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestTableSubClass {
	public static void main(String[] args) {

		
		Cash c = new Cash();
		
		c.setAmount(1000);
		c.setAmountType("cash");
		
		Checque ccq = new Checque();
		
		ccq.setAmount(200);
		ccq.setBankName("bob");
        ccq.setChequeNo("Piyush");
         
         
		CreditCardPayment ccd = new CreditCardPayment();
		
		ccd.setAmount(100);
		ccd.setAmountType("online");
		ccd.setCcType("imb");
		
		

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		
		session.save(c);
		
		session.save(ccq);
		
		session.save(ccd);

		tx.commit();

		session.close();
	}
}
