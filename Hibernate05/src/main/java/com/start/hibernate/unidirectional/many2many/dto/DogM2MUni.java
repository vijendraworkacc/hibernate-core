package com.start.hibernate.unidirectional.many2many.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DogM2MUni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dogId;
	private Integer age;
}
