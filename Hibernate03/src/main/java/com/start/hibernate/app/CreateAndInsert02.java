package com.start.hibernate.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Actor;
import com.start.hibernate.dto.Movie;

public class CreateAndInsert02 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate03 CreateAndInsert02!");

		// Creating a SessionFactory object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Creating the 1st Actor object and initializing it
		Actor actor1 = new Actor();
		actor1.setActorName("Actor 1");
		actor1.setActorDob(new Date());

		// Creating the 2nd Actor object and initializing it
		Actor actor2 = new Actor();
		actor2.setActorName("Actor 2");
		actor2.setActorDob(new Date());

		// Creating a Session object
		Session session = factory.openSession();

		/*
		 * (Fetching Data) Eager loading the Movie objects from database and displaying
		 * the content
		 */
		Movie movie1 = session.load(Movie.class, 1);
		Movie movie2 = session.load(Movie.class, 2);
		System.out.println("---> " + movie1.getMovieName());
		System.out.println("---> " + movie2.getMovieName());

		// Create a list of actor objects
		List<Actor> actors = new ArrayList<Actor>();
		actors.add(actor1);
		actors.add(actor2);

		// Create a list of movie objects
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(movie1);
		movies.add(movie2);

		// Setting movies list of actors and actor list for movies
		actor1.setMovieLst(movies);
		actor2.setMovieLst(movies);

		// Creating a Transaction object and saving the objects in the database
		Transaction transaction = session.beginTransaction();
		session.save(actor1);
		session.save(actor2);
		session.save(movie1);
		session.save(movie2);
		transaction.commit();

		// Closing the session and factory
		session.close();
		factory.close();
	}

}
