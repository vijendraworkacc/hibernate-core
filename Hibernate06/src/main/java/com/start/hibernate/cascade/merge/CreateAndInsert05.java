package com.start.hibernate.cascade.merge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateAndInsert05 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate06 CreateAndInsert03!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();

	}

}
