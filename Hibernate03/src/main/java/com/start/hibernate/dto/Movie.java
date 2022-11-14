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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Vijendra Singh
 *
 */
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int movieId;

	@Column(name = "movie_name")
	private String movieName;

	@Column(name = "movie_dor")
	@Temporal(TemporalType.DATE)
	private Date movieDateOfRelease;

	

	

	public Movie() {
		super();
	}

	public Movie(String movieName, Date movieDateOfRelease, Director director, List<Actor> actorLst) {
		super();
		this.movieName = movieName;
		this.movieDateOfRelease = movieDateOfRelease;
		
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getMovieDateOfRelease() {
		return movieDateOfRelease;
	}

	public void setMovieDateOfRelease(Date movieDateOfRelease) {
		this.movieDateOfRelease = movieDateOfRelease;
	}

	

	

	public int getMovieId() {
		return movieId;
	}

	
}
