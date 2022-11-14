package com.start.hibernate.bidirectional.one2one.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CellularBi {
	/*
	 * The same annotation @OneToOne to the PersonBi attribute is used in the
	 * CellularBi entity.
	 * 
	 * The parameter “mappedBy” was used in the @OneToOne annotation in the
	 * CellularBi class. This parameter indicates that the entity PersonBi is the
	 * owner of the relationship and the foreign key must exist inside the person
	 * table, and not the CellularBi table.
	 * 
	 * Without @OneToOne(mappedBy = "cellularBi"), also program will work, tables
	 * will be created, but column to store the foreign keys will be created in the
	 * both the tables created by the PersonBi and CelluralBi. But
	 * with @OneToOne(mappedBy = "cellularBi"), column to store the foreign key will
	 * only be present in the PersonBi table.
	 * 
	 * As PersonBi is the relationship owner, and if we are trying to save the
	 * object of CellularBi only and not PersonBi, we do not get any exception, but
	 * we do not be able to save the PersonBi object. Cascading mechanism is only
	 * applicable when we try to save PersonBi object but not CellularBi object,
	 * because we have provided annotation @OneToOne(cascade = CascadeType.ALL) with
	 * cascade attribute.
	 * 
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cellularId;
	private Long cellularNumber;

	@OneToOne(mappedBy = "cellularBi", cascade = CascadeType.ALL)
	private PersonBi personBi;
}
