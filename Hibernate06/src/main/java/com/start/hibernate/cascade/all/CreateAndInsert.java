package com.start.hibernate.cascade.all;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateAndInsert {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate06 CreateAndInsert!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Country country = new Country();
		country.setName("India");
		
		PrimeMinister primeMinister = new PrimeMinister();
		primeMinister.setName("Narendra Modi");
		
		country.setPrimeMinister(primeMinister);
		
		session.save(country);
		
		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();

	}

}
