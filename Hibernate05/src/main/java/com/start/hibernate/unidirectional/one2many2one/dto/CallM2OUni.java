package com.start.hibernate.unidirectional.one2many2one.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class CallM2OUni {
	/*
	 * The annotation @ManyToOne is used.
	 * 
	 * Notice that annotation @JoinColumn is used to define who the owner of the
	 * relationship is.
	 * 
	 * The @ManyToOne side will always be the owner of the relationship. There is no
	 * way of using the mappedBy attribute inside the @ManyToOne annotation.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer callId;
	private Long callDuration;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cellularO2MUni_fk")
	private CellularO2MUni cellularO2MUni;
}
