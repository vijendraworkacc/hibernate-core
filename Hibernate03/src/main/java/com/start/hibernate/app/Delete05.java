package com.start.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Director;

public class Delete05 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate03 Delete05!");

		// Creating a SessionFactory object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Creating a Session object
		Session session = factory.openSession();

		// Trying to update actor name using Director object
		Director director = session.load(Director.class, 1);

		// Deleting SRK actor from the table
		// session.remove(director.getMovieLst().get(1).getActorLst().get(1));

		// Creating a Transaction object and persist the object in the database
		Transaction transaction = session.beginTransaction();
		session.save(director);
		transaction.commit();

		// Closing the session and factory
		session.close();
		factory.close();
	}

}
