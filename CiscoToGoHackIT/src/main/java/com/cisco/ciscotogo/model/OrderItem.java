package com.cisco.ciscotogo.model;

public class OrderItem {
	private Order order;
	private Item item;
	private double cost;
	
	public OrderItem(Order order, Item item) {
		setOrder(order);
		setItem(item);
	}
	public OrderItem(Order order, Item item, double cost) {
		this(order, item);
		setCost(cost);
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	


	
	
	
}
