package com.start.hibernate.cascade.detach;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Country04 {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.DETACH)
	private List<State01> states;
}
