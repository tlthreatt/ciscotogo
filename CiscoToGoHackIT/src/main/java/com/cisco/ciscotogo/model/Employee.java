package com.cisco.ciscotogo.model;

public class Employee {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Location location;
	
	public Employee (int id, String email) {
		setId(id);
		setEmail(email);
	}
	public Employee(int id, String email, String password) {
		this(id, email);
		setPassword(password);
	}
	
	public Employee(int id, String email, String firstName, String lastName, String password, Location location) {
		this(id, email);
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setLocation(location);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
