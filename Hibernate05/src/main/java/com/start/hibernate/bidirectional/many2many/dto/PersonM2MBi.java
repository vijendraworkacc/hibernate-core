package com.start.hibernate.bidirectional.many2many.dto;

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
public class PersonM2MBi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	private String personName;

	@ManyToMany
	@JoinTable(name = "PersonM2MBi_DogM2MBi_Map", 
	joinColumns = @JoinColumn(name = "person_id"), 
	inverseJoinColumns = @JoinColumn(name = "dog_id"))
	private List<DogM2MBi> dogM2MBiList;
}
