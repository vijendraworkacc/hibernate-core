package com.start.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Certificate;
import com.start.hibernate.dto.Student;

public class App3 {

	public static void main(String[] args) {
		System.out.println("Hello World! 3");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());

		Student student = new Student();
		student.setCity("Bangalore");
		student.setName("Vijendra Singh");
		student.setCertificate(new Certificate("Java", 6));

		Student student1 = new Student();
		student1.setCity("Bangalore");
		student1.setName("Shristi Singh");
		student1.setCertificate(new Certificate("C++", 3));

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		session.save(student1);
		transaction.commit();
	}

}
