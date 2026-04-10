package com.rays.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.MarksheetDTO;

public class TestMarksheetSave {

	public static void main(String[] args) {
		
		
		MarksheetDTO dto = new MarksheetDTO();
		
		dto.setName("lucky");
		dto.setRollNo("233CAA046");
		dto.setPhysics("70");
		dto.setChemistry("80");
		dto.setMaths("75");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
	Session session = 	sf.openSession();
	  Transaction tx =  session.beginTransaction();
	  
	  session.save(dto);
	  tx.commit();
	  session.close();
	}
}
