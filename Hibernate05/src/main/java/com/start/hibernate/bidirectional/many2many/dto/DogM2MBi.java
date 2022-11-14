package com.start.hibernate.bidirectional.many2many.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class DogM2MBi {
	/*
	 * As you can see the @ManyToMany annotation is configured with the "mappedBy"
	 * option, which establishes the Person entity as the relationship owner. Every
	 * relationship needs that one of the entities be the “relationship owner”. For
	 * the ManyToMany association the relationship owner entity is the one that is
	 * dictated by the "mappedBy" option usually configured with the @ManyToMany
	 * annotation at the non-owner entity of the relation. If the "mappedBy" option
	 * is not found in any of the related entities JPA will define both entities as
	 * the relationship owners. The "mappedBy" option must point to the associated
	 * entity's attribute name and not the associated entity's name
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dogId;
	private Integer age;

	@ManyToMany(mappedBy = "dogM2MBiList")
	private List<PersonM2MBi> personM2MBisList;
}
