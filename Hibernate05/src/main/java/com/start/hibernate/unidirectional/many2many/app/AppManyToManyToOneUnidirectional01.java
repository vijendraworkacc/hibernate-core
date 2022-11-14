package com.start.hibernate.unidirectional.many2many.app;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.unidirectional.many2many.dto.DogM2MUni;
import com.start.hibernate.unidirectional.many2many.dto.PersonM2MUni;

public class AppManyToManyToOneUnidirectional01 {
	/*
	 * In a ManyToMany example a person may have several dogs and a dog may have
	 * several persons (imagine a dog that lives in a house with 15 persons). In a
	 * ManyToMany approach it is necessary to use an extra database table to store
	 * the id's that relate the database tables of every entity of the relationship.
	 * Thus for the specific example we will have a person table, a dog table and a
	 * relationship table named person_dog. The person_dog table would only maintain
	 * the person_id and dog_id values that represent which dog belongs to which
	 * person.
	 */
	public static void main(String[] args) {
		System.out.println("Hello Hibernate05 AppManyToManyToOneUnidirectional01!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		PersonM2MUni personM2MUni = new PersonM2MUni();
		personM2MUni.setPersonName("A");

		PersonM2MUni personM2MUni1 = new PersonM2MUni();
		personM2MUni1.setPersonName("B");

		PersonM2MUni personM2MUni11 = new PersonM2MUni();
		personM2MUni11.setPersonName("C");

		DogM2MUni dogM2MUni = new DogM2MUni();
		dogM2MUni.setAge(3);

		DogM2MUni dogM2MUni1 = new DogM2MUni();
		dogM2MUni1.setAge(1);

		DogM2MUni dogM2MUni11 = new DogM2MUni();
		dogM2MUni11.setAge(5);

		personM2MUni.setDogM2MUniList(Arrays.asList(dogM2MUni, dogM2MUni1, dogM2MUni11));
		personM2MUni1.setDogM2MUniList(Arrays.asList(dogM2MUni, dogM2MUni1, dogM2MUni11));
		personM2MUni11.setDogM2MUniList(Arrays.asList(dogM2MUni, dogM2MUni1, dogM2MUni11));

		/*
		 * We are not setting person list to dog object because the Dog object does not
		 * have an attribute of type list of Person, neither we are using any annotation
		 * like ManyToMany in Dog class.
		 */
		// dogM2MBi.setPersonM2MBisList(Arrays.asList(personM2MBi, personM2MBi1,
		// personM2MBi11));
		// dogM2MBi1.setPersonM2MBisList(Arrays.asList(personM2MBi, personM2MBi1,
		// personM2MBi11));
		// dogM2MBi11.setPersonM2MBisList(Arrays.asList(personM2MBi, personM2MBi1,
		// personM2MBi11));

		session.save(dogM2MUni);
		session.save(dogM2MUni1);
		session.save(dogM2MUni11);

		session.save(personM2MUni);
		session.save(personM2MUni1);
		session.save(personM2MUni11);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();
	}

}
