package com.cisco.ciscotogo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Customer {
	
	@Id @Column(name="customer_cec")
	private String cec;
	
	@Column(name="customer_phone", nullable=true)
	private String phone;
	
	@Column(name="customer_email", nullable=false, unique=true)
	private String email;
	
	@Column(name="customer_first_name", nullable=false)
	private String firstName;
	
	@Column(name="customer_last_name", nullable=false)
	private String lastName;
	
	@Column(name="customer_is_text_enabled", nullable=false)
	private boolean isTextEnabled;
	
	@ManyToOne @JoinColumn(name="location_id", nullable=true)
	@JsonBackReference
	private Location location;
	
	@OneToMany(mappedBy="customer")
	@JsonManagedReference
	private List<Order> orders;
	
	@OneToMany(mappedBy="customer")
	@JsonManagedReference
	private List<Rating> ratings;
	
	@Transient
	private double balance;
	
	public Customer(String cec) {
		setCec(cec);
	}
	public Customer(String cec, String email, String phone, boolean isTextEnabled, String firstName, String lastName) {

		setCec(cec);
		setEmail(email);
		setPhone(phone);
		setTextEnabled(isTextEnabled);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Customer(String cec, String email, String phone, boolean isTextEnabled, String firstName, String lastName, Location location) {
		this(cec, email, phone, isTextEnabled, firstName, lastName);
		setLocation(location);
	}
	
	public Customer(String cec, String email, String phone, boolean isTextEnabled, String firstName, String lastName, Location location
			,double balance) {
		this(cec, email, phone, isTextEnabled, firstName, lastName, location);
		setBalance(balance);
	}
	

	
	public Customer(){}

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
