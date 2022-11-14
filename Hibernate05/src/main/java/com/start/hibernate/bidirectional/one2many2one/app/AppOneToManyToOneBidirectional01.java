package com.start.hibernate.bidirectional.one2many2one.app;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.bidirectional.one2many2one.dto.CallM2OBi;
import com.start.hibernate.bidirectional.one2many2one.dto.CellularO2MBi;
import com.start.hibernate.unidirectional.one2many2one.dto.CallM2OUni;
import com.start.hibernate.unidirectional.one2many2one.dto.CellularO2MUni;

public class AppOneToManyToOneBidirectional01 {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate05 AppOneToManyToOneBidirectional01!");

		// Creating SessionFactory, Session and Transaction objects
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		CallM2OBi callM2OBi = new CallM2OBi();
		callM2OBi.setCallDuration(85675L);
		
		CallM2OBi callM2OBi1 = new CallM2OBi();
		callM2OBi1.setCallDuration(921675L);
		
		CallM2OBi callM2OBi11 = new CallM2OBi();
		callM2OBi11.setCallDuration(55675L);
		
		CellularO2MBi cellularO2MBi = new CellularO2MBi();
		cellularO2MBi.setCellularNumber(6740578390L);
		cellularO2MBi.setCallM2OBiList(Arrays.asList(callM2OBi, callM2OBi1, callM2OBi11));
		
		callM2OBi.setCellularO2MBi(cellularO2MBi);
		callM2OBi1.setCellularO2MBi(cellularO2MBi);
		callM2OBi11.setCellularO2MBi(cellularO2MBi);
		
		session.save(cellularO2MBi);
		
		// Closing the costly resources
		transaction.commit();
		session.close();
		factory.close();
	}

}
