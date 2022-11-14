package com.start.hibernate.dto.o2o;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Answers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private int answerId;
	private String answer;

	// @JoinColumn(name = "question_fk")
	@OneToOne(mappedBy = "answers")
	private Questions questions;

	public Answers() {
		super();
	}

	public Answers(int answerId, String answer, Questions questions) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.questions = questions;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Answers [answerId=" + answerId + ", answer=" + answer + ", questions=" + questions + "]";
	}
}
