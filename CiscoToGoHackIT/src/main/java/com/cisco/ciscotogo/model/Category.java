package com.cisco.ciscotogo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="category")
public class Category {
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="category_id")
	private int id;
	
	@Column(name="category_name", nullable=false)
	private String name;
	
	@Column(name="category_availaility", nullable=false)
	private String availability; // in ('ALWAYS','MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY')
	
	@ManyToOne
	@JoinColumn(name="location_id", nullable=false, unique=true)
	private Location location;
	
	private String lol;
	
	
	@OneToMany(mappedBy="category")
	private List<Item> items;
	
	
	public Category() {} 
	
	public Category(int id, String name) {
		setId(id);
		setName(name);
	}
	public Category(int id, String name, String availability) {
		this(id, name);
		setAvailability(availability);
	}
	public Category(int id, String name, String availability, List<Item> items) {
		this(id, name, availability);
		setItems(items);
	}
	
	public Category(int id, String name, String availability, List<Item> items, Location location) {
		this(id, name, availability, items);
		setLocation(location);
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

	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	
	
	

}
