package com.start.hibernate.dto.m2m;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Questions3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String question;

	@ManyToMany
	@JoinTable(name = "QsAs", joinColumns = { @JoinColumn(name = "qid") }, inverseJoinColumns = {
			@JoinColumn(name = "aid") })
	private List<Answers3> answersLst;

	public Questions3() {
		super();
	}

	public Questions3(int questionId, String question, List<Answers3> answersLst) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answersLst = answersLst;
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

	public List<Answers3> getAnswersLst() {
		return answersLst;
	}

	public void setAnswersLst(List<Answers3> answersLst) {
		this.answersLst = answersLst;
	}
}
