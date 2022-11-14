package com.start.hibernate.dto.o2mm2o;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Questions2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private int questionId;
	private String question;

	/* By default fetch = FetchType.LAZY, for lazy loading! */
	@OneToMany(fetch = FetchType.EAGER) // Eager loading!
	@JoinTable(name = "Q2sA2s", joinColumns = { @JoinColumn(name = "qid") }, inverseJoinColumns = {
			@JoinColumn(name = "aid") })
	private List<Answers2> answers2;

	public Questions2() {
		super();
	}

	public Questions2(int questionId, String question, List<Answers2> answers2) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers2 = answers2;
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

	public List<Answers2> getAnswers2() {
		return answers2;
	}

	public void setAnswers2(List<Answers2> answers2) {
		this.answers2 = answers2;
	}
}
