package com.cisco.ciscotogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity(name="order_item")
public class OrderItem {
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="order_item_id")
	private int id;
	
	@ManyToOne @JoinColumn(name="order_id", nullable=false)
	@JsonBackReference
	private Order order;
	
	@ManyToOne @JoinColumn(name="item_id", nullable=false)
	@JsonManagedReference
	private Item item;
	
	@Column(name="order_item_quantity", nullable=false)
	private int quantity;
	
	// Cost == item.getListPrice() * quantity
	@Column(name="order_item_cost", nullable=false)
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	


	
	
	
}
