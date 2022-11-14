package com.start.hibernate.app.o2o;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.o2o.Answers;
import com.start.hibernate.dto.o2o.Questions;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello Hibernate02!");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("Is session closed? " + factory.isClosed());
		System.out.println("-----------------------------------------------");

		// Creating Question 0!
		Questions questions = new Questions();
		// questions.setQuestionId(100);
		questions.setQuestion("What is Java?");
		Answers answer = new Answers();
		// answer.setAnswerId(100);
		answer.setAnswer("Java is a programming language.");
		answer.setQuestions(questions);
		questions.setAnswers(answer);

		// Creating Question 1!
		Questions questions1 = new Questions();
		// questions1.setQuestionId(101);
		questions1.setQuestion("What is a Thread?");
		Answers answer1 = new Answers();
		// answer1.setAnswerId(101);
		answer1.setAnswer("Sub-process in a process.");
		answer1.setQuestions(questions1);
		questions1.setAnswers(answer1);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(questions);
		session.save(questions1);
		session.save(answer);
		session.save(answer1);
		transaction.commit();

		session.close();
		factory.close();
	}
}
