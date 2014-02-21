package com.cisco.ciscotogo.model;

public class User {
	private String firstName;
	private String lastName;
	private String cec;
	private Long employeeID;
	private String location;
	private Float balance;
	private String favLocation;
	private MenuItem favFood;
	
	public User(String firstName, String lastName, String cec, Long employeeID,
			String location, Float balance, String favLocation, MenuItem favFood) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cec = cec;
		this.employeeID = employeeID;
		this.location = location;
		this.balance = balance;
		this.favLocation = favLocation;
		this.favFood = favFood;
	}
	
	public User(){}

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

	public String getCec() {
		return cec;
	}

	public void setCec(String cec) {
		this.cec = cec;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getFavLocation() {
		return favLocation;
	}

	public void setFavLocation(String favLocation) {
		this.favLocation = favLocation;
	}

	public MenuItem getFavFood() {
		return favFood;
	}

	public void setFavFood(MenuItem favFood) {
		this.favFood = favFood;
	}
	
	
	
	

}
