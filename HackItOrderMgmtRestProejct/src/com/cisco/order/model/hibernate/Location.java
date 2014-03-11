package com.cisco.order.model.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cisco.order.domain.IdentifiableEntity;

@Entity(name="location")
public class Location extends IdentifiableEntity{
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="location_id")
	private int id;
	@Column(name="location_name", nullable=false)
	private String name;
	/*
	@OneToOne(mappedBy="location")
	private LocationAddress locationAddress;
	*/
	@OneToOne(mappedBy="location")
	private LocationAddress locationAddress;
	
	@OneToMany(mappedBy="location")
	private List<Category> categories;
	
	@OneToMany(mappedBy="location")
	private List<Employee> employees;
	@OneToMany(mappedBy="location")
	private List<Order> orders;
	
	@OneToMany(mappedBy="location")
	private List<Customer> customers;
	
	public Location() {};
	
	public Location(Long id, String name) {
		super.setId(id);
		setName(name);
	}
	public Location(Long id, String name, List<Category> categories) {
		this(id, name);
		setCategories(categories);
	}
	/*
	public Location(int id, String name, LocationAddress locationAddress) {
		this(id, name);
		setLocationAddress(locationAddress);
	}
	
	public Location(int id, String name, LocationAddress locationAddress,
			List<Category> categories) {
		this(id, name, locationAddress);
		setCategories(categories);
	}
	*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	/*
	public LocationAddress getLocationAddress() {
		return locationAddress;
	}
	public void setLocationAddress(LocationAddress locationAddress) {
		this.locationAddress = locationAddress;
	}
	*/

	

	
}
