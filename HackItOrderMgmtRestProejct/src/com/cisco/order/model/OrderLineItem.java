package com.cisco.order.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "order_item")
public class OrderLineItem implements Serializable{

	private static final long serialVersionUID = -7537352734406281473L;
	
	@JsonBackReference
	private Order order;
	
	private Long item_id;
	
	private Double item_cost;
	public OrderLineItem() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderLineItem(Order order, Long item_id, Double item_cost) {
		super();
		this.order = order;
		this.item_id = item_id;
		this.item_cost = item_cost;
	}
	
	@Id
	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	
	@Column(name="order_item_cost")
	public Double getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(Double item_cost) {
		this.item_cost = item_cost;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=Order.class)
	@JoinColumn(name = "order_id", nullable = false)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
