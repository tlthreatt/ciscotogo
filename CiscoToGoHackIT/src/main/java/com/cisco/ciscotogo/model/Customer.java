package com.cisco.ciscotogo.model;

public class Customer {
	private int id;
	private String cec;
	private String email;
	private String firstName;
	private String lastName;
	private int employeeID;
	private Location location;
	private double balance;
	private String favLocation;
	private String favFood;
	
	public Customer(int id, String cec, String email, String firstName, String lastName) {
		setId(id);
		setCec(cec);
		setEmail(email);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Customer(int id, String cec, String email, String firstName, String lastName, Location location) {
		this(id, cec, email, firstName, lastName);
		setLocation(location);
	}
	
	public Customer(int id, String cec, String email, String firstName, String lastName, Location location
			,double balance) {
		this(id, cec, email, firstName, lastName, location);
		setBalance(balance);
	}
	
	public Customer(int id, String firstName, String lastName, String cec, int employeeID,
			Location location, double balance, String favLocation, String favFood) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cec = cec;
		this.employeeID = employeeID;
		this.location = location;
		this.balance = balance;
		this.favLocation = favLocation;
		this.favFood = favFood;
	}
	
	public Customer(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCec() {
		return cec;
	}

	public void setCec(String cec) {
		this.cec = cec;
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

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
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
