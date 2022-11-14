package com.start.hibernate.unidirectional.one2many2one.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CellularO2MUni {
	/*
	 * The one to many relationship is used when an entity has a relationship with a
	 * list of other entities, e.g. a Cellular may have several Calls but a Call can
	 * have only one Cellular. The OneToMany relationship is represented with a list
	 * of values, there is more than one entity associate with it.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cellularId;
	private Long cellularNumber;
}
