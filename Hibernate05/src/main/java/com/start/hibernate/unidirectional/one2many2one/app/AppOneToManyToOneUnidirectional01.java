package com.start.hibernate.unidirectional.one2many2one.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.unidirectional.one2many2one.dto.CallM2OUni;
import com.start.hibernate.unidirectional.one2many2one.dto.CellularO2MUni;

public class AppOneToManyToOneUnidirectional01 {
	/*
	 * When we are trying to save the Call objects the Cellular objects are
	 * automatically saved, because in the CallM2OUni class we have
	 * used @ManyToOne(cascade = CascadeType.ALL).
	 * 
	 * In unidirectional OneToMany and ManyToOne mapping, one of the entity do not
	 * have any of the two annotations (@OneToMany, @ManyToOne).
	 * 
	 * The @ManyToOne side will always be the owner of the relationship. There is no
	 * way of using the mappedBy attribute inside the @ManyToOne annotation.
	 * 
	 * mappedBy attribute should only be used with @OneToMany while implementing
	 * OneToMany and ManyToOne mapping.
	 */
	public static void main(String[] args) {
		System.out.println("Hello Hibernate05 AppOneToManyToOneUnidirectional01!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		CellularO2MUni cellularO2MUni = new CellularO2MUni();
		cellularO2MUni.setCellularNumber(97645748344L);

		CallM2OUni callM2OUni = new CallM2OUni();
		callM2OUni.setCallDuration(63823L);

		CallM2OUni callM2OUni1 = new CallM2OUni();
		callM2OUni1.setCallDuration(63823L);

		CallM2OUni callM2OUni11 = new CallM2OUni();
		callM2OUni11.setCallDuration(63823L);

		callM2OUni.setCellularO2MUni(cellularO2MUni);
		callM2OUni1.setCellularO2MUni(cellularO2MUni);
		callM2OUni11.setCellularO2MUni(cellularO2MUni);

		// Saving the Call objects and Cellular object are automatically saved
		session.save(callM2OUni);
		session.save(callM2OUni1);
		session.save(callM2OUni11);

		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();
	}

}
