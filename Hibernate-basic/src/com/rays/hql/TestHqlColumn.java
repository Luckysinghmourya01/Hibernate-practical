package com.rays.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestHqlColumn {

	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
	Query q = 	session.createQuery("select id,firstName,address from UserDTO");
	
	List list = q.list();

	Iterator it = list.iterator();

	while (it.hasNext()) {
		
		Object[] dto =(Object[])it.next();
		
		System.out.print(dto[0]);
		//System.out.print("\t");
		System.out.print("\t"+dto[1]);
		System.out.println("\t"+dto[2]);
	}
	}
}
