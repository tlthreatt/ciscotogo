package com.cisco.ciscotogo.model;

import java.util.Date;
import java.util.List;

public class Item {
	private int id;
	private String name;
	private String description;
	private double listPrice; // this is the list price of the item
	private Date dateAdded;
	private boolean isInStock;
	private Category category;
	private List<OrderItem> orderItems;

	
	public Item(int id, String name, String description, double listPrice) {
		setId(id);
		setName(name);
		setDescription(description);
		setListPrice(listPrice);
	}	
	public Item(int id, String name, String description, double listPrice, Date dateAdded, boolean isInStock) {
		this(id, name, description, listPrice);
		setDateAdded(dateAdded);
		setInStock(isInStock);
	}
	
	public Item(int id, String name, String description, double listPrice, Date dateAdded, boolean isInStock,
			Category category) {
		this(id, name, description, listPrice, dateAdded, isInStock);
		setMenuCategory(category);
	}
	public Item(int id, String name, String description, double listPrice, List<OrderItem> orderItems) {
		this(id, name, description, listPrice);
		setOrderItems(orderItems);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public boolean isInStock() {
		return isInStock;
	}
	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}
	public Category getMenuCategory() {
		return category;
	}
	public void setMenuCategory(Category category) {
		this.category = category;
	}
	public double getListPrice() {
		return listPrice;
	}
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
