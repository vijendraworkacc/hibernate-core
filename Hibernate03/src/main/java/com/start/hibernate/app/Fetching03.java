package com.start.hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Director;
import com.start.hibernate.dto.Movie;

public class Fetching03 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate03 Fetching03!");

		// Creating a SessionFactory object
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Creating a Session object
		Session session = factory.openSession();

		// Fetching director from the table
		Director director = session.load(Director.class, 1);
		System.out.println("----------------------------------------------------");
		System.out.println("--> Director name: " + director.getDirectorName());
		List<Movie> listMovies=director.getMovieLst();
		for (Movie movie : listMovies) {
			System.out.println(movie);
		}
//		System.out.println("----------------------------------------------------");
//		System.out.println("----------------------------------------------------");
//		System.out.println("--> Movie directed by director '" + director.getDirectorName() + "' at index 1 is "
//				+ director.getMovieLst().get(1).getMovieName());
//		System.out.println("----------------------------------------------------");
//		System.out.println("----------------------------------------------------");
////		System.out.println("--> One of the actors worked in '" + director.getMovieLst().get(1).getMovieName()
////				+ "' movie is " + director.getMovieLst().get(1).getActorLst().get(1).getActorName());
//		System.out.println("----------------------------------------------------");

		// Closing the session and factory
		session.close();
		factory.close();
	}

}
