package com.start.hibernate.dto.o2o;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private int questionId;
	private String question;

	// @JoinColumn(name = "answer_fk")
	@OneToOne
	@JoinColumn(name = "answer_fk")
	private Answers answers;

	public Questions() {
		super();
	}

	public Questions(int questionId, String question, Answers answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answers getAnswers() {
		return answers;
	}

	public void setAnswers(Answers answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
	}
}