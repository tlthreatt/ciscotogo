package com.cisco.ciscotogo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name="`order`")
public class Order {
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="order_id")
	private int id;
	
	@Column(name="order_status", nullable=false)
	private String status;
	
	@Column(name="order_date", nullable=false)
	private Date date;
	
	@Column(name="order_notes", nullable=true)
	private String notes;
	
	@Column(name="order_desired_completion_time", nullable=true)
	private Date desiredCompletionTime;
	
	@ManyToOne @JoinColumn(name="location_id", nullable=false)
	private Location location;
	
	@ManyToOne @JoinColumn(name="customer_cec", nullable=false)
	private Customer customer;
	
	@ManyToOne @JoinColumn(name="employee_id", nullable=true)
	private Employee employee;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItems;
	

	
	@Transient
	private double amount; // Not in DB, calculated from items (quantity * price)
	
	
	public Order(int id, String status, Date date, Location location, Customer customer) {
		setId(id);
		setStatus(status);
		setDate(date);
		setLocation(location);
		setCustomer(customer);
	}
	public Order(int id, String status, Date date, Location location, Customer customer,
			List<OrderItem> orderItems) {
		this(id, status, date, location, customer);
		setOrderItems(orderItems);
	}
	public Order(int id, String status, Date date, Location location, Customer customer,
			List<OrderItem> orderItems, double amount) {
		this(id, status, date, location, customer, orderItems);
		setAmount(amount);
	}
	/*
	public Order(String status, Customer customer, ArrayList<Item> items,
			String building, double amount, int orderID) {
		super();
		this.status = status;
		this.customer = customer;
		this.menuItems = items;
		this.building = building;
		this.amount = amount;
		this.orderID = orderID;
	}*/
	
	public Order(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getDesiredCompletionTime() {
		return desiredCompletionTime;
	}
	public void setDesiredCompletionTime(Date desiredCompletionTime) {
		this.desiredCompletionTime = desiredCompletionTime;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	
	

}
