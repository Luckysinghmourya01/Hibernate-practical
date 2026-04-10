package com.rays.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.user.MarksheetDTO;

public class TestMarksheetSearch {

	public static void main(String[] args) {
		
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		 Session session = sf.openSession();
		 
		MarksheetDTO dto = (MarksheetDTO) session.get(MarksheetDTO.class, 1);
		
		System.out.print("\t"+dto.getName());
		System.out.print("\t"+dto.getRollNo());
		System.out.print("\t"+dto.getPhysics());
		System.out.print("\t"+dto.getChemistry());
		System.out.print("\t"+dto.getMaths());
		
		
	}
}
