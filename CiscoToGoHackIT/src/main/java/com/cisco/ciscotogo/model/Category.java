package com.cisco.ciscotogo.model;

import java.util.List;

public class Category {
	private int id;
	private String name;
	private String availability; // in ('ALWAYS','MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY')
	private List<Item> items;
	private Location location;
	
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
