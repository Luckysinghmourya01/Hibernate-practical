package com.rays.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestHqlCount {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("select count(*) from UserDTO");
		
	List<UserDTO> list = 	q.list();
	
     Iterator it = 	list.iterator();
     
     while(it.hasNext()) {
    	 
    	Object dto =  it.next(); 
    	
    	System.out.println(dto);
     }
     
     tx.commit();
     session.close();

	}
}
