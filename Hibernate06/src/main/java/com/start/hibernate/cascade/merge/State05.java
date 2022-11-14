package com.start.hibernate.cascade.merge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class State05 {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	@ManyToOne
	private Country05 country;
}
