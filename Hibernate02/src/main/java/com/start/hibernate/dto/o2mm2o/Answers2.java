package com.start.hibernate.dto.o2mm2o;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answers2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "questions_fk")
	private Questions2 questions2;

	public Answers2() {
		super();
	}

	public Answers2(int answerId, String answer, Questions2 questions2) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.questions2 = questions2;
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

	public Questions2 getQuestions2() {
		return questions2;
	}

	public void setQuestions2(Questions2 questions2) {
		this.questions2 = questions2;
	}

}
