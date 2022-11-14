package com.start.hibernate.bidirectional.many2many.app;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.bidirectional.many2many.dto.DogM2MBi;
import com.start.hibernate.bidirectional.many2many.dto.PersonM2MBi;
import com.start.hibernate.unidirectional.many2many.dto.DogM2MUni;

public class AppManyToManyToOneBidirectional01 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate05 AppManyToManyToOneBidirectional01!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		PersonM2MBi personM2MBi = new PersonM2MBi();
		personM2MBi.setPersonName("A");

		PersonM2MBi personM2MBi1 = new PersonM2MBi();
		personM2MBi1.setPersonName("B");

		PersonM2MBi personM2MBi11 = new PersonM2MBi();
		personM2MBi11.setPersonName("C");

		DogM2MBi dogM2MBi = new DogM2MBi();
		dogM2MBi.setAge(3);

		DogM2MBi dogM2MBi1 = new DogM2MBi();
		dogM2MBi1.setAge(6);

		DogM2MBi dogM2MBi11 = new DogM2MBi();
		dogM2MBi11.setAge(1);

		personM2MBi.setDogM2MBiList(Arrays.asList(dogM2MBi, dogM2MBi1, dogM2MBi11));
		personM2MBi1.setDogM2MBiList(Arrays.asList(dogM2MBi, dogM2MBi1, dogM2MBi11));
		personM2MBi11.setDogM2MBiList(Arrays.asList(dogM2MBi, dogM2MBi1, dogM2MBi11));

		dogM2MBi.setPersonM2MBisList(Arrays.asList(personM2MBi, personM2MBi1, personM2MBi11));
		dogM2MBi1.setPersonM2MBisList(Arrays.asList(personM2MBi, personM2MBi1, personM2MBi11));
		dogM2MBi11.setPersonM2MBisList(Arrays.asList(personM2MBi, personM2MBi1, personM2MBi11));

		session.save(dogM2MBi);
		session.save(dogM2MBi1);
		session.save(dogM2MBi11);

		session.save(personM2MBi);
		session.save(personM2MBi1);
		session.save(personM2MBi11);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();
	}

}
