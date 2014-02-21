package com.cisco.ciscotogo.model;

import java.util.ArrayList;

public class OrderList {
	private ArrayList<Order> orders;

	public OrderList(ArrayList<Order> orders) {
		super();
		this.orders = orders;
	}

	public OrderList() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrdrers(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
