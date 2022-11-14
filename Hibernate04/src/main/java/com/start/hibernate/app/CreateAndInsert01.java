package com.start.hibernate.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Director;
import com.start.hibernate.dto.Movie;

public class CreateAndInsert01 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate04 CreateAndInsert01!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// Creating and initializing a Director object
		Director director1 = new Director();
		director1.setDirectorName("Director 1");
		director1.setDirectorDateOfBirth(LocalDate.of(1988, 01, 01));
		
		// Creating and initializing a Movie objects
		Movie movie1 = new Movie();
		movie1.setMovieName("Movie 1");
		movie1.setMovieDateOfRelease(LocalDate.of(2020, 01, 01));
		Movie movie2 = new Movie();
		movie2.setMovieName("Movie 2");
		movie2.setMovieDateOfRelease(LocalDate.of(2010, 01, 01));
		
		// Creating a list of movies 
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(movie1);
		movies.add(movie2);
		
		// Setting director to movie and movie to director
		movie1.setDirector(director1);
		movie2.setDirector(director1);
		director1.setMoviesDirected(movies);
		
		// Saving the data in the database
		session.save(director1);
		session.save(movie1);
		session.save(movie2);	
		
		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();
	}

}
