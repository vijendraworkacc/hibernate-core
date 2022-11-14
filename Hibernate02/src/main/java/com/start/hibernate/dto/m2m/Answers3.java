package com.start.hibernate.dto.m2m;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Answers3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int answerId;
	private String answer;
	@ManyToMany
	private List<Questions3> questionsLst;

	public Answers3() {
		super();
	}

	public Answers3(int answerId, String answer, List<Questions3> questionsLst) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.questionsLst = questionsLst;
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

	public List<Questions3> getQuestionsLst() {
		return questionsLst;
	}

	public void setQuestionsLst(List<Questions3> questionsLst) {
		this.questionsLst = questionsLst;
	}
}
