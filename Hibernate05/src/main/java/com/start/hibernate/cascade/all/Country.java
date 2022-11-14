package com.start.hibernate.cascade.all;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Country {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PrimeMinister primeMinister;
}
