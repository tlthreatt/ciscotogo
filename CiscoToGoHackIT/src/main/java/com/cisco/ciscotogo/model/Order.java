package com.cisco.ciscotogo.model;

import java.util.ArrayList;

public class Order {
	private String status;
	private User user;
	private ArrayList<MenuItem> menuItems;
	private String building;
	private double amount;
	private int orderID;
	
	public Order(String status, User user, ArrayList<MenuItem> menuItems,
			String building, double amount, int orderID) {
		super();
		this.status = status;
		this.user = user;
		this.menuItems = menuItems;
		this.building = building;
		this.amount = amount;
		this.orderID = orderID;
	}
	
	public Order(){}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
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
