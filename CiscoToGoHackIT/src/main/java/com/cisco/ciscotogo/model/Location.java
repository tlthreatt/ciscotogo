package com.cisco.ciscotogo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.CascadeType;

@Entity(name="location")
public class Location {
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
	
	@OneToMany(mappedBy="location", cascade = CascadeType.ALL)
	private List<Category> categories;
	
	@OneToMany(mappedBy="location")
	private List<Employee> employees;
	@OneToMany(mappedBy="location")
	private List<Order> orders;
	
	@OneToMany(mappedBy="location")
	private List<Customer> customers;
	
	@OneToMany(mappedBy="location")
	private List<Rating> ratings;
	
	public Location() {};
	
	public Location(int id, String name) {
		setId(id);
		setName(name);
	}
	public Location(int id, String name, List<Category> categories) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
