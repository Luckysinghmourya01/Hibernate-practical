package com.rays.sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestSqlAll {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		SQLQuery q = session.createSQLQuery("select * from st_user");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object[] b = (Object[]) it.next();

		System.out.print("\t"+ b[0]);
		System.out.print("\t"+ b[1]);
		System.out.print("\t"+ b[2]);
		System.out.print("\t"+ b[3]);
		System.out.print("\t"+ b[4]);
		System.out.print("\t"+ b[5]);
		System.out.println("\t"+ b[6]);
		}
		
		tx.commit();
		session.close();

	}
}
