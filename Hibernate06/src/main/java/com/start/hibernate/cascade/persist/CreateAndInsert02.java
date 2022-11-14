package com.start.hibernate.cascade.persist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateAndInsert02 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate06 CreateAndInsert02!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Country02 country = new Country02();
		country.setName("Country 2");
		PrimeMinister02 primeMinister = new PrimeMinister02();
		primeMinister.setName("Prime minister 2");
		country.setPrimeMinister(primeMinister);
		primeMinister.setCountry(country);
		session.save(country);
		session.save(primeMinister);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();

	}

}
