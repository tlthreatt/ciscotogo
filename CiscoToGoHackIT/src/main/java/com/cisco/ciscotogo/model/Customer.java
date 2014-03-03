package com.cisco.ciscotogo.model;

public class Customer {
	private int id;
	private String cec;
	private String phone;
	private String email;
	private String firstName;
	private String lastName;
	private boolean isTextEnabled;
	private Location location;
	private double balance;
	private String favLocation;
	private String favFood;
	
	public Customer(int id, String cec, String email, String phone, boolean isTextEnabled, String firstName, String lastName) {
		setId(id);
		setCec(cec);
		setEmail(email);
		setPhone(phone);
		setTextEnabled(isTextEnabled);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Customer(int id, String cec, String email, String phone, boolean isTextEnabled, String firstName, String lastName, Location location) {
		this(id, cec, email, phone, isTextEnabled, firstName, lastName);
		setLocation(location);
	}
	
	public Customer(int id, String cec, String email, String phone, boolean isTextEnabled, String firstName, String lastName, Location location
			,double balance) {
		this(id, cec, email, phone, isTextEnabled, firstName, lastName, location);
		setBalance(balance);
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isTextEnabled() {
		return isTextEnabled;
	}

	public void setTextEnabled(boolean isTextEnabled) {
		this.isTextEnabled = isTextEnabled;
	}


	
	
	

}
