package com.start.hibernate.cascade.remove;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateAndInsert03 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate06 CreateAndInsert03!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Country03 country = new Country03();
		country.setName("Country 3");
		
		State state = new State();
		state.setName("Karnataka");
		
		State state1 = new State();
		state1.setName("UP");
		
		State state11 = new State();
		state11.setName("MP");
		
		List<State> states = Arrays.asList(state, state1, state11);
		country.setStates(states);
		state.setCountry(country);
		state1.setCountry(country);
		state11.setCountry(country);
		
		session.save(country);
		session.save(state);
		session.save(state1);
		session.save(state11);
		
		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();

	}

}
