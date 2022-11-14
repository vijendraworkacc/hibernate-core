package com.start.hibernate.dto;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "street_name", length = 100)
	private String street;

	@Column(name = "city_name", length = 20)
	private String city;

	@Column(name = "is_parmanent")
	private boolean isParmanent;

	@Transient
	private boolean deliveryAllowed;

	@Column(name = "joined_date")
	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	@Lob
	private byte[] image;

	public Address() {
		super();
	}

	public Address(String street, String city, boolean isParmanent, Boolean deliveryAllowed, Date joinedDate,
			byte[] image) {
		super();
		this.street = street;
		this.city = city;
		this.isParmanent = isParmanent;
		this.deliveryAllowed = deliveryAllowed;
		this.joinedDate = joinedDate;
		this.image = image;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isParmanent() {
		return isParmanent;
	}

	public void setParmanent(boolean isParmanent) {
		this.isParmanent = isParmanent;
	}

	public Boolean getDeliveryAllowed() {
		return deliveryAllowed;
	}

	public void setDeliveryAllowed(Boolean deliveryAllowed) {
		this.deliveryAllowed = deliveryAllowed;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getAddressId() {
		return addressId;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isParmanent="
				+ isParmanent + ", deliveryAllowed=" + deliveryAllowed + ", joinedDate=" + joinedDate + ", image="
				+ Arrays.toString(image) + "]";
	}
}
