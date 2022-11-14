package com.start.hibernate.unidirectional.many2many.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class PersonM2MUni {
	/*
	 * The @ManyToMany annotation is used.
	 * 
	 * The @JoinTable annotation is used to set the relationship table between the
	 * entities; “name” sets the table name; “joinColumn” defines the column name in
	 * the table of the relationship owner; “inverseJoinColumns” defines the column
	 * name in the table of the non-relationship owner.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	private String personName;

	@ManyToMany
	@JoinTable(name = "PersonM2MUni_DogM2MUni_Map", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "dog_id"))
	private List<DogM2MUni> dogM2MUniList;
}
