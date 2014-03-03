package com.cisco.ciscotogo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private String status;
	private Date date;
	private Location location;
	private Customer customer;
	private List<Item> items;
	private double amount; // Not in DB, calculated from items
	private int orderID; // Is this a human-readable number different than the PK? What is its point?
	
	public Order(int id, String status, Date date, Location location, Customer customer) {
		setId(id);
		setStatus(status);
		setDate(date);
		setLocation(location);
		setCustomer(customer);
	}
	public Order(int id, String status, Date date, Location location, Customer customer,
			List<Item> items) {
		this(id, status, date, location, customer);
		setMenuItems(items);
	}
	public Order(int id, String status, Date date, Location location, Customer customer,
			List<Item> items, double amount) {
		this(id, status, date, location, customer, items);
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
	public List<Item> getMenuItems() {
		return items;
	}
	public void setMenuItems(List<Item> items) {
		this.items = items;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	
	

}
