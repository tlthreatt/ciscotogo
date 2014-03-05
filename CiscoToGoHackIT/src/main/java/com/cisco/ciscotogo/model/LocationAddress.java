package com.cisco.ciscotogo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="location_address")
public class LocationAddress implements Serializable{
	
	@OneToOne @Id @JoinColumn(name = "location_id")
	private Location location;

	
	@Column(name="location_address_street", nullable=false)
	private String street;
	@Column(name="location_address_city", nullable=false)
	private String city;
	@Column(name="location_address_state", nullable=false)
	private String state;
	@Column(name="location_address_zip", nullable=true)
	private String zip;
	@Column(name="location_address_country", nullable=false)
	private String country;
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LocationAddress)) {
			return false;
		}
		LocationAddress locationAddress = (LocationAddress)obj;
		
		if (locationAddress.getLocation().getId() != this.getLocation().getId()) {
			return false;
		}
		return true;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
