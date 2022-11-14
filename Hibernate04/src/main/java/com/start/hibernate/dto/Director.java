package com.start.hibernate.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer directorId;
	private String directorName;
	private LocalDate directorDateOfBirth;

	/*
	 * We should use mappedBy attribute of OneToMany when we want to make the table
	 * as relationship owner and foreign key column has to be created in the
	 * relationship owner table only!
	 */
	@OneToMany(mappedBy = "director")
	private List<Movie> moviesDirected;
}
