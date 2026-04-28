package com.rays.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;
import com.rays.auction.bid;

public class TestTrnasitivePersistance {

	public static void main(String[] args) {

		bid b = new bid();

		b.setId(4);
		b.setAmount(550);
		b.setTimeStamp("current");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 2);

		Set s = item.getBids();

		s.add(b);

		tx.commit();

		session.close();
	}
}
