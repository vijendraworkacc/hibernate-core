package com.start.hibernate.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Director;
import com.start.hibernate.dto.Movie;

public class CreateAndInsert01 {
	
	public static void main(String[] args) {
		System.out.println("Hello Hibernate03 CreateAndInsert01!");

		// Creating a SessionFactory object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Creating the 1st Movie object and initializing it
		Movie movie1 = new Movie();
		movie1.setMovieName("Movie 1");
		movie1.setMovieDateOfRelease(new Date());

		// Creating the 2nd Movie object and initializing it
		Movie movie2 = new Movie();
		movie2.setMovieName("Movie 2");
		movie2.setMovieDateOfRelease(new Date());

		// Creating a list of Movie objects
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(movie1);
		movies.add(movie2);

		/*
		 * Creating a Director object and assigning the Director object as the director
		 * of movie1 and movie2
		 */
		Director director1 = new Director();
		director1.setDirectorName("Director 1");
		director1.setDirectorDob(new Date()); // Not able to put Date date = new Date(1964, 02, 22);
		director1.setMovieLst(movies);

		// Creating a Session object
		Session session = factory.openSession();

		// Creating a Transaction object and saving the objects in the database
		Transaction transaction = session.beginTransaction();
		session.save(director1);
		transaction.commit();

		// Closing the session and factory
		session.close();
		factory.close();

	}
}
