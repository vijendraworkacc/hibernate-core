package com.start.hibernate.unidirectional.one2one.dto;

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
public class PersonUni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	private String personName;

	/*
	 * In the Person entity it is possible to use the annotation @OneToOne. This
	 * annotation indicates to JPA that there is a relationship between the
	 * entities.
	 * 
	 * If not using @OneToOne(cascade = CascadeType.ALL), then we will get
	 * Exception: (org.hibernate.TransientObjectException: object references an
	 * unsaved transient instance - save the transient instance before flushing:
	 * com.start.hibernate.unidirectional.one2one.dto.CellularUni).
	 * 
	 * Above exception is also occurred if we are not trying to save the CellularUni
	 * object, instead we are only trying to save the PersonUni object expecting
	 * that the CellularUni object will be saved automatically. For CellularUni
	 * object to get saved automatically, some cascading operation must happen.
	 * 
	 * CascadeType.ALL: In this case we used @OneToOne(cascade = CascadeType.ALL),
	 * which makes sure that all the operation that take place on the PersonUni
	 * object, will also propagate to the depending/child entity objects.
	 * 
	 * In unidirectional OneToOne mapping only one entity class will use @OneToOne
	 * annotation on the depending entity reference variable and that entity will be
	 * called the "relationship owner". Here PersonUni class is the relationship
	 * owner and the table generated with respect to this entity will have a
	 * separate column for storing the primary keys of CellularUni table in the form
	 * of foreign keys.
	 * 
	 * To change the name of that column that is holding the foreign key we make use
	 * of @JoinColumn(name = "cellular_fk"), so the column name will be
	 * "cellular_fk". @JoinColumn also indicates that the foreign key will be
	 * located in the PersonUni database table, making the Person entity owner of
	 * the relationship.
	 *
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cellular_fk")
	private CellularUni cellularUni;
}
