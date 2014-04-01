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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Employee {
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="employee_id")
	private int id;
	
	@Column(name="employee_email", nullable=false)
	private String email;
	
	@Column(name="employee_first_name", nullable=true)
	private String firstName;
	
	@Column(name="employee_last_name", nullable=true)
	private String lastName;
	
	@Column(name="employee_password", nullable=true)
	private String password;
	
	@ManyToOne @JoinColumn(name="location_id", nullable=false)
	@JsonBackReference
	private Location location;
	
	//*Is this necessary?
	@OneToMany(mappedBy="employee") @Cascade(CascadeType.SAVE_UPDATE)
	@JsonManagedReference
	private List<Order> orders;
	
	public Employee() {}
	
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
