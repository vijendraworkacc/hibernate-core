package com.start.hibernate.app.o2o;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.o2o.Answers;
import com.start.hibernate.dto.o2o.Questions;

public class App2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("It is closed? " + factory.isClosed());
		System.out.println("---------------------------------------------------------------");

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Questions question = session.get(Questions.class, 2);
		// System.out.println(question); //// Will give StackOverflow exception!
		System.out.println(question.getQuestion());

		Answers answer = session.get(Answers.class, 2);
		System.out.println(answer.getAnswer());
		transaction.commit();
		session.close();
		factory.close();
	}

}
