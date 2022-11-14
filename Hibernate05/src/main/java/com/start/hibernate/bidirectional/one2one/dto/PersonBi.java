package com.start.hibernate.bidirectional.one2one.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class PersonBi {

	/*
	 * If not using @OneToOne(cascade = CascadeType.ALL), then we will get
	 * Exception: (org.hibernate.TransientObjectException: object references an
	 * unsaved transient instance - save the transient instance before flushing:
	 * com.start.hibernate.bidirectional.one2one.dto.CellularBi)
	 * 
	 * Above exception is also occurred if we are not trying to save the CellularBi
	 * object, instead we are only trying to save the PersonBi object expecting that
	 * the CellularBi object will be saved automatically. For CellularBi object to
	 * get saved automatically, some cascading operation must happen.
	 * 
	 * The CellularBi class is using the @OneToOne annotation with "mappedBy"
	 * attribute, which indicated that the PersonBi is the owner of the
	 * relationship. To change the name of that column we can make use of
	 * annotation @JoinColumn with name property.
	 * 
	 * In this case we are using @JoinColumn(name = "cellular_fk"), so the name of
	 * the column will be "cellular_fk".
	 * 
	 * JPA uses the Java concept of class reference, a class must maintain a
	 * reference to another one if there will be a join between them.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	private String personName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cellular_fk")
	private CellularBi cellularBi;
}
