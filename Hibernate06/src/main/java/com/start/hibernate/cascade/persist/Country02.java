package com.start.hibernate.cascade.persist;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Country02 {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private PrimeMinister02 primeMinister;
}
