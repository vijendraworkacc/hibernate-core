package com.start.hibernate.app.o2mm2o;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.o2mm2o.Answers2;
import com.start.hibernate.dto.o2mm2o.Questions2;

public class App3 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("It is closed? " + factory.isClosed());
		System.out.println("---------------------------------------------------------------");

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Questions2 questions2 = new Questions2();
		questions2.setQuestion("What is Java?");
		Answers2 answer1 = new Answers2();
		answer1.setAnswer("Java is a programming language.");
		answer1.setQuestions2(questions2);
		Answers2 answer11 = new Answers2();
		answer11.setAnswer("Java is a language for SD.");
		answer11.setQuestions2(questions2);
		List<Answers2> answers2s = new ArrayList<Answers2>();
		answers2s.add(answer1);
		answers2s.add(answer11);
		questions2.setAnswers2(answers2s);

		session.save(questions2);
		session.save(answer11);
		session.save(answer1);

		transaction.commit();
		session.close();
		factory.close();
	}
	
	
	

}
