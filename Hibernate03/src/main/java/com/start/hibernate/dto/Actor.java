package com.start.hibernate.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Vijendra Singh
 *
 */
@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private int actorId;

	@Column(name = "actor_name")
	private String actorName;

	@Column(name = "actor_dob")
	@Temporal(TemporalType.DATE)
	private Date actorDob;

	@ManyToMany
	private List<Movie> movieLst;

	public Actor() {
		super();
	}

	public Actor(String actorName, Date actorDob, List<Movie> movieLst) {
		super();
		this.actorName = actorName;
		this.actorDob = actorDob;
		this.movieLst = movieLst;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Date getActorDob() {
		return actorDob;
	}

	public void setActorDob(Date actorDob) {
		this.actorDob = actorDob;
	}

	public List<Movie> getMovieLst() {
		return movieLst;
	}

	public void setMovieLst(List<Movie> movieLst) {
		this.movieLst = movieLst;
	}

	public int getActorId() {
		return actorId;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorDob=" + actorDob + ", movieLst="
				+ movieLst + "]";
	}
}
