package com.start.hibernate.unidirectional.one2one.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.unidirectional.one2one.dto.CellularUni;
import com.start.hibernate.unidirectional.one2one.dto.PersonUni;

public class AppOneToOneUnidirectional01 {
	/*
	 * In a unidirectional relationship just one side of the relationship knows
	 * (“sees”) the other. Notice that Person knows Cellular but Cellular does not
	 * know Person. It is possible to do person.getCellular() but it is not possible
	 * to do cellular.getPerson()
	 */
	public static void main(String[] args) {
		System.out.println("Hello Hibernate04 AppOneToOneUnidirectional01!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// Creating PersonUni object
		PersonUni personUni1 = new PersonUni();
		personUni1.setPersonName("PersonUni 1");

		// Creating CellularUni object
		CellularUni cellularUni1 = new CellularUni();
		cellularUni1.setCellularNumber(90909090900L);

		// Mapping Person object with Cellular object
		personUni1.setCellularUni(cellularUni1);

		// Saving objects in DB
		session.save(personUni1);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();
	}

}
