package com.rays.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.MarksheetDTO;

public class TestMarksheetUpdate {

	public static void main(String[] args) {
		
		MarksheetDTO dto = new MarksheetDTO();
		
		dto.setId(2);
		dto.setName("ashok");
		dto.setRollNo("2324Css");
		dto.setPhysics("29");
		dto.setChemistry("89");
		dto.setMaths("77");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		  Session session = sf.openSession();
		  
		Transaction tx =   session.beginTransaction();
		
		session.update(dto);
		
		tx.commit();
		session.close();
				
	}
}
