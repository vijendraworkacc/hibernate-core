package com.start.hibernate.cascade.persist;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class PrimeMinister02 {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Country02 country;
}
