package com.rays.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestPerClass {

	public static void main(String[] args) {

		CreditCardPayment ccd = new CreditCardPayment();
		ccd.setAmount(2000);
		ccd.setPaymentType("cash");
		ccd.setCcType("active");

		Cash c = new Cash();

		c.setAmount(3000);
		c.setPaymentType("Cash");

		Cheque ch = new Cheque();

		ch.setPaymentType("cheque");
		ch.setBankName("Sbi");
		ch.setCheName("lucky");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// session.save(ccd);

		// session.save(c);

		session.save(ch);

		tx.commit();

		session.close();
	}
}
