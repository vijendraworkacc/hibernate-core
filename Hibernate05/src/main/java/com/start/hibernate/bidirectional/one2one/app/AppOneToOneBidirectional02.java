package com.start.hibernate.bidirectional.one2one.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.bidirectional.one2one.dto.CellularBi;
import com.start.hibernate.bidirectional.one2one.dto.PersonBi;

public class AppOneToOneBidirectional02 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate04 AppOneToOneBidirectional02!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		PersonBi personBi = new PersonBi();
		personBi.setPersonName("PersonBi 2");

		CellularBi cellularBi = new CellularBi();
		cellularBi.setCellularNumber(9999999900L);
		
		/*
		 * For a Bidirectional relationship to work correctly it is necessary to do like
		 * below: person.setCellular(cellular); cellular.setPerson(person);
		 */
		personBi.setCellularBi(cellularBi);
		cellularBi.setPersonBi(personBi);

		session.save(cellularBi);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();

	}

}
