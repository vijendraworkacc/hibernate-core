package com.start.hibernate.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Vijendra Singh
 *
 */
@Entity
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "director_id")
	private int directorId;

	@Column(name = "director_name")
	private String directorName;

	@Column(name = "director_dob")
	@Temporal(TemporalType.DATE)
	private Date directorDob;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "director_id")
	private List<Movie> movieLst;

	public Director() {
		super();
	}

	public Director(String directorName, Date directorDob, List<Movie> movieLst) {
		super();
		this.directorName = directorName;
		this.directorDob = directorDob;
		this.movieLst = movieLst;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Date getDirectorDob() {
		return directorDob;
	}

	public void setDirectorDob(Date directorDob) {
		this.directorDob = directorDob;
	}

	public List<Movie> getMovieLst() {
		return movieLst;
	}

	public void setMovieLst(List<Movie> movieLst) {
		this.movieLst = movieLst;
	}

	public int getDirectorId() {
		return directorId;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", directorDob=" + directorDob
				+ ", movieLst=" + movieLst + "]";
	}

}
