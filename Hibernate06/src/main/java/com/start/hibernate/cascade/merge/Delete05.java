package com.start.hibernate.cascade.merge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.cascade.persist.Country02;

public class Delete05 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate06 Delete!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Country05 country = session.find(Country05.class, 10);
		System.out.println(country.getName());
		session.remove(country);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();

	}

}
