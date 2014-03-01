package com.cisco.ciscotogo.model;

public class User {
	private String firstName;
	private String lastName;
	private String cec;
	private int employeeID;
	private String location;
	private double balance;
	private String favLocation;
	private String favFood;
	
	public User(String firstName, String lastName, String cec, int employeeID,
			String location, double balance, String favLocation, String favFood) {
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

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getFavLocation() {
		return favLocation;
	}

	public void setFavLocation(String favLocation) {
		this.favLocation = favLocation;
	}

	public String getFavFood() {
		return favFood;
	}

	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}
	
	
	
	

}
