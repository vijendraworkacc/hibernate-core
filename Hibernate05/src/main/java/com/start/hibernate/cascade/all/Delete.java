package com.start.hibernate.cascade.all;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate06 Delete!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Country country = session.find(Country.class, 1);
		System.out.println(country.getName());
		System.out.println(country.getPrimeMinister().getName());
		session.remove(country);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();

	}

}
