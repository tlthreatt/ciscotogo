package com.cisco.ciscotogo.model;

import java.util.List;

public class Location {

	private int id;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	private List<Category> categories;
	
	
	public Location(int id, String name) {
		setId(id);
		setName(name);
	}
	public Location(int id, String name, List<Category> categories) {
		this(id, name);
		setCategories(categories);
	}
	
	public Location(int id, String name, String street,  String city, String state, String zip, String country) {
		this(id, name);
		setName(name);
		setStreet(street);
		setCity(city);
		setState(state);
		setZip(zip);
		setCountry(country);
	}
	
	public Location(int id, String name, String street, String city, String state, String zip, String country,
			List<Category> categories) {
		this(id, name, street, city, state, zip, country);
		setCategories(categories);
	}
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
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	

	
}
