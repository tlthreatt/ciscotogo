package com.cisco.ciscotogo.model;

import java.util.List;
import java.util.Set;


//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	@OneToOne(mappedBy="location") @Cascade(CascadeType.ALL)
	@JsonManagedReference
	private LocationAddress locationAddress;
	
	@OneToOne(mappedBy="location") @Cascade(CascadeType.ALL)
	@JsonManagedReference
	private LocationHours locationHours;
	
	@OneToMany(mappedBy="location")//, fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private Set<Category> categories;
	
	@OneToMany(mappedBy="location", fetch=FetchType.LAZY) //@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Employee> employees;
	
	@OneToMany(mappedBy="location") @Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Order> orders;
	
	@OneToMany(mappedBy="location", fetch=FetchType.LAZY) @Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Customer> customers;
	
	@OneToMany(mappedBy="location", fetch=FetchType.LAZY) //@Cascade(CascadeType.ALL)
	@JsonManagedReference
	//@JsonBackReference
	private List<Rating> ratings;
	
	public Location() {};
	
	public Location(int id, String name) {
		setId(id);
		setName(name);
	}
	public Location(int id, String name, Set<Category> categories) {
		this(id, name);
		setCategories(categories);
	}
	public Location(int id) {
		setId(id);
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
	
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public LocationAddress getLocationAddress() {
		return locationAddress;
	}
	public void setLocationAddress(LocationAddress locationAddress) {
		this.locationAddress = locationAddress;
	}

	public LocationHours getLocationHours() {
		return locationHours;
	}

	public void setLocationHours(LocationHours locationHours) {
		this.locationHours = locationHours;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	

	

	
}
