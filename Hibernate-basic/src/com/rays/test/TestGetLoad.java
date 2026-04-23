package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestGetLoad {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();
		
		UserDTO dto = (UserDTO) session.load(UserDTO.class, 12);
		
	//UserDTO dto = (UserDTO)	session.get(UserDTO.class, 13);
	

	
	System.out.println("dto = " + dto);
	}
}
