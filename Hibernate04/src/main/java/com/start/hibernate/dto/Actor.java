package com.start.hibernate.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer actorId;
	private String actorName;
	private LocalDate actorDateOfBirth;
	
	@ManyToMany
	private List<Movie> moviesActed;
}
