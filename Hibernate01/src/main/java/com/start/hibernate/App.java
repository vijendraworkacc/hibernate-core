package com.start.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.Address;
import com.start.hibernate.dto.Student;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());

		Student student = new Student();
		student.setName("Vijendra");
		student.setCity("Bangalore");
		System.out.println(student);

		Address address = new Address();
		address.setCity("Bangalore");
		address.setStreet("Banashankari 3rd stage");
		address.setParmanent(false);
		address.setDeliveryAllowed(true);
		address.setJoinedDate(new Date());
		FileInputStream fileInputStream = new FileInputStream("src/main/java/pic.jpg");
		byte[] bs = new byte[fileInputStream.available()];
		fileInputStream.read(bs);
		address.setImage(bs);
		System.out.println(address);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		session.save(address);
		transaction.commit();
		session.close();
	}
}
