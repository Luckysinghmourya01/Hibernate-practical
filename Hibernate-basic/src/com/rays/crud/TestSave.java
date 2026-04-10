package com.rays.crud;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.rays.user.UserDTO;

public class TestSave {

	public static void main(String[] args) {
		
		UserDTO dto = new UserDTO();
		
		dto.setFirstName("vimal");
		dto.setLastName("verma");
		dto.setLoginId("kamal11@gmail.com");
		dto.setPassword("Aman@121");
		dto.setDob(new Date());
		dto.setAddress("bhopal");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		 Session session = sf.openSession();
		 
		 Transaction tx = session.beginTransaction();
		 
		 session.save(dto);
		 
		 tx.commit();
		 
		 session.close();
		 
		 
	
	
	
	}
}
