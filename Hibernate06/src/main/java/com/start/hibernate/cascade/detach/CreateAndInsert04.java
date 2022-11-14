package com.start.hibernate.cascade.detach;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateAndInsert04 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate06 CreateAndInsert04!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Country04 country04 = new Country04();
		country04.setName("Country 6");
		
		State01 state01 = new State01();
		state01.setName("A");
		state01.setCountry(country04);
		
		State01 state011 = new State01();
		state011.setName("B");
		state011.setCountry(country04);
		
		List<State01> state01s = Arrays.asList(state01, state011);
		country04.setStates(state01s);
		
		session.save(country04);
		session.save(state01);
		session.save(state011);
		
		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();

	}

}
