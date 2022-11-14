package com.start.hibernate.bidirectional.one2many2one.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class CellularO2MBi {
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

	@OneToMany(mappedBy = "cellularO2MBi", cascade = CascadeType.ALL)
	private List<CallM2OBi> callM2OBiList;
}
