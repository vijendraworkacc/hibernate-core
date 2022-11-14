package com.start.hibernate.bidirectional.one2one.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.bidirectional.one2one.dto.CellularBi;
import com.start.hibernate.bidirectional.one2one.dto.PersonBi;

public class AppOneToOneBidirectional01 {

	/*
	 * A developer must have in mind that for JPA to work in an optimal way it is a
	 * good practice to leave one side of the relationship as the owner. If the
	 * annotation @OneToOne found in the Cellular entity was without the “mappedBy”
	 * parameter, JPA would handle the Cellular entity as the owner of the
	 * relationship too. It is not a good idea to leave either sides of a
	 * relationship without defining "mappedBy", or both with "mappedBy" set.
	 */
	public static void main(String[] args) {
		System.out.println("Hello Hibernate04 AppOneToOneBidirectional01!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		PersonBi personBi = new PersonBi();
		personBi.setPersonName("PersonBi 1");

		CellularBi cellularBi = new CellularBi();
		cellularBi.setCellularNumber(9999999900L);

		/*
		 * For a Bidirectional relationship to work correctly it is necessary to do like
		 * below: person.setCellular(cellular); cellular.setPerson(person);
		 */
		personBi.setCellularBi(cellularBi);
		cellularBi.setPersonBi(personBi);

		session.save(personBi);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();
	}

}
