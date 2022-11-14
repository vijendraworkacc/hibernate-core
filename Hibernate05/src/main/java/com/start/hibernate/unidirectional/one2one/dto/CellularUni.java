package com.start.hibernate.unidirectional.one2one.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CellularUni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cellularId;
	private Long cellularNumber;

}
