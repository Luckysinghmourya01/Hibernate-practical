package com.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAuction {

	public static void main(String[] args) {

		bid bid1 = new bid();

		bid1.setId(1); 
		bid1.setAmount(1000);
		bid1.setTimeStamp("10:30");

		bid bid2 = new bid();
		bid2.setId(2);
		bid2.setAmount(2000);
		bid2.setTimeStamp("11:00");

		bid bid3 = new bid();
		bid3.setId(3);
		bid3.setAmount(3000);
		bid3.setTimeStamp("11:30");

		Set bids = new HashSet();

		bids.add(bid1);
		bids.add(bid2);
		bids.add(bid3);

		AuctionItem item = new AuctionItem();

		item.setId(2 );
		item.setDescription("auction 2");
		item.setBids(bids);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(item);

		tx.commit();

		session.close();
	}
}
