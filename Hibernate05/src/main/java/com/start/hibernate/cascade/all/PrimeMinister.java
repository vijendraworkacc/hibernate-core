package com.start.hibernate.cascade.all;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PrimeMinister {
	@Id
	@GeneratedValue
	private int id;
	private String name;
}
