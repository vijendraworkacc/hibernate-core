package com.start.hibernate.cascade.remove;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class State {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	@ManyToOne
	private Country03 country;
}
