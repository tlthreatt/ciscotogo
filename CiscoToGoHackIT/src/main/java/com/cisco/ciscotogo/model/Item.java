package com.cisco.ciscotogo.model;

import java.util.Date;

public class Item {
	private int id;
	private String name;
	private String description;
	private double listPrice; // this is the list price of the item
	
	// since Order has a List<Item>, and the DB's order_item table includes the line price for historical lookup
	// there needs to be another price field signifying what was paid in the line item invoice
	private Date dateAdded;
	private boolean isInStock;
	private Category category;
	private Order order;
	
	private double currentPrice; // this is the line-item price in order_item table, used for historical lookup
	
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
	public Item(int id, String name, String description, double listPrice, Order order) {
		this(id, name, description, listPrice);
		setOrder(order);
	}
	public Item(int id, double currentPrice) {
		setId(id);
		setCurrentPrice(currentPrice);
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
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
