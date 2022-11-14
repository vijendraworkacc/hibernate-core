package com.start.hibernate.cascade.remove;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Country03 {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<State> states;
}
