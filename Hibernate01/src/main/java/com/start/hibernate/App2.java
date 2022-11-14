package com.start.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Address;
import com.start.hibernate.dto.Student;

public class App2 {

	public static void main(String[] args) {
		System.out.println("Hello world! 2");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());

		Session session = factory.openSession();
		Student student = session.get(Student.class, 0);
		Address address = session.load(Address.class, 1);
		System.out.println("Student: " + student);
		System.out.println("Address: " + address);
		System.out.println("Hello world! 2");
		session.close();
	}
}
