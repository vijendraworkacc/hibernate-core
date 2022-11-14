package com.start.hibernate.app.o2mm2o;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.o2mm2o.Answers2;
import com.start.hibernate.dto.o2mm2o.Questions2;

public class App4 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("It is closed? " + factory.isClosed());
		System.out.println("---------------------------------------------------------------");

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		transaction.commit();

		// Lazy loading!
		Questions2 questions22 = session.get(Questions2.class, 1);
		Answers2 answers22 = session.get(Answers2.class, 1);
		System.out.println("---------------------------------------------------------------");
		System.out.println(questions22.getQuestion());
		System.out.println(questions22.getAnswers2());
		System.out.println(answers22.getAnswer());
		System.out.println("---------------------------------------------------------------");
		for (Answers2 answers2 : questions22.getAnswers2()) {
			System.out.println(answers2.getAnswer());
		}
		System.out.println("---------------------------------------------------------------");
		session.close();
		factory.close();
	}

}
