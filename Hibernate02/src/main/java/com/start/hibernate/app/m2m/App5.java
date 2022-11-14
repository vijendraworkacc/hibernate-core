package com.start.hibernate.app.m2m;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.start.hibernate.dto.m2m.Answers3;
import com.start.hibernate.dto.m2m.Questions3;

public class App5 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// ---------------------------------------------------------------------------------

		Questions3 questions3 = new Questions3();
		questions3.setQuestion("What is static keyword?");

		Questions3 questions31 = new Questions3();
		questions31.setQuestion("Explain static keyword?");

		// ----

		Questions3 questions311 = new Questions3();
		questions311.setQuestion("What is a thread?");

		Questions3 questions3111 = new Questions3();
		questions3111.setQuestion("Explain threads?");

		// ---------------------------------------------------------------------------------

		Answers3 answers3 = new Answers3();
		answers3.setAnswer(
				"Static is keyword in java that can be used with variable, methods and intializaion blocks.");

		Answers3 answers31 = new Answers3();
		answers31.setAnswer("Static intializers at the time of class loading process.");

		// ----

		Answers3 answers311 = new Answers3();
		answers311.setAnswer("Thread is a sub-process in a process.");

		Answers3 answers3111 = new Answers3();
		answers3111.setAnswer("All process have a thread called main thread.");

		Answers3 answers31111 = new Answers3();
		answers31111.setAnswer("Life of all threads start and ends at the main thread.");

		// ---------------------------------------------------------------------------------

		List<Questions3> staticQuestions = new ArrayList<Questions3>();
		staticQuestions.add(questions3);
		staticQuestions.add(questions31);

		List<Questions3> threadQuestions = new ArrayList<Questions3>();
		threadQuestions.add(questions311);
		threadQuestions.add(questions3111);

		// ----

		List<Answers3> staticAnswers = new ArrayList<Answers3>();
		staticAnswers.add(answers3);
		staticAnswers.add(answers31);

		List<Answers3> threadAnswers = new ArrayList<Answers3>();
		threadAnswers.add(answers311);
		threadAnswers.add(answers3111);
		threadAnswers.add(answers31111);

		// ---------------------------------------------------------------------------------

		questions3.setAnswersLst(staticAnswers);
		questions31.setAnswersLst(staticAnswers);
		answers3.setQuestionsLst(staticQuestions);
		answers31.setQuestionsLst(staticQuestions);

		// ----

		questions311.setAnswersLst(threadAnswers);
		questions3111.setAnswersLst(threadAnswers);
		answers311.setQuestionsLst(threadQuestions);
		answers3111.setQuestionsLst(threadQuestions);
		answers31111.setQuestionsLst(threadQuestions);

		// ---------------------------------------------------------------------------------

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// ---------------------------------------------------------------------------------

		session.save(questions3);
		session.save(questions31);
		session.save(answers3);
		session.save(answers31);

		// ----

		session.save(questions311);
		session.save(questions3111);
		session.save(answers311);
		session.save(answers3111);
		session.save(answers31111);

		// ---------------------------------------------------------------------------------

		transaction.commit();
		factory.close();
		session.close();
	}

}
