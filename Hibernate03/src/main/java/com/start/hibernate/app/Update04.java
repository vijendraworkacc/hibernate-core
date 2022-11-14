package com.start.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Actor;
import com.start.hibernate.dto.Director;

public class Update04 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate03 Update04!");

		// Creating a SessionFactory object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Creating a Session object
		Session session = factory.openSession();

		// Trying to update actor name using Director object
		Director director = session.load(Director.class, 1);

		// Displaying existing actor name
		System.out.println("----------------------------------------------------");
//		System.out.println("Existing actor name: " + director.getMovieLst().get(1).getActorLst().get(1).getActorName());
		System.out.println("----------------------------------------------------");

//		// Updating actor name
//		Actor actor = director.getMovieLst().get(1).getActorLst().get(1);
//		actor.setActorName("SRK");

		// Creating a Transaction object and persist the object in the database
		Transaction transaction = session.beginTransaction();
//		session.save(actor);
		transaction.commit();
		
		// Displaying the updated actor name
		System.out.println("----------------------------------------------------");
		Director director1 = session.load(Director.class, 1);
//		System.out.println("Updated actor name: " + director1.getMovieLst().get(1).getActorLst().get(1).getActorName());
		System.out.println("----------------------------------------------------");

		// Closing the session and factory
		session.close();
		factory.close();
	}

}
