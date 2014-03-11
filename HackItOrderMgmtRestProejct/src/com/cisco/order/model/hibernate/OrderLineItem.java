package com.cisco.order.model.hibernate;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.cisco.order.domain.IdentifiableEntity;

@Entity
@Table(name = "order_item")
@AttributeOverrides({
    @AttributeOverride(name="id", column=@Column(name="order_item_id")),
})
public class OrderLineItem extends IdentifiableEntity{

	private static final long serialVersionUID = -7537352734406281473L;
	
	//private OrderLineItemPK orderLineItemPk;
	@JsonBackReference
	private Order order;
	
	@ManyToOne
	private Long item_id;
	
	private Double item_cost;
	public OrderLineItem() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderLineItem(Long item_id,Double item_cost){
		super();
		//this.setOrderLineItemPk(new OrderLineItemPK(null, item_id));
		this.item_id = item_id;
		this.item_cost = item_cost;
	}
	public OrderLineItem(Order order, Long item_id, Double item_cost) {
		//this.setOrderLineItemPk(new OrderLineItemPK(order, item_id));
		this.order = order;
		this.item_id = item_id;
		this.item_cost = item_cost;
	}
	/**
	@EmbeddedId
	public OrderLineItemPK getOrderLineItemPk() {
		return orderLineItemPk;
	}

	public void setOrderLineItemPk(OrderLineItemPK orderLineItemPk) {
		this.orderLineItemPk = orderLineItemPk;
	}**/

	
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
	
	/**
	@Embeddable
	public static class OrderLineItemPK implements Serializable{

		private static final long serialVersionUID = -8574835149143024233L;
		
		@JsonBackReference
		private Order order;
		
		@ManyToOne
		private Long item_id;
		
		public OrderLineItemPK(){
			
		}
		public OrderLineItemPK(Order order, Long item_id){
			this.setOrder(order);
			this.setItem_id(item_id);
		}
		
		@ManyToOne(fetch = FetchType.EAGER, targetEntity=Order.class)
		@JoinColumn(name = "order_id", nullable = false)
		public Order getOrder() {
			return order;
		}
		
		public void setOrder(Order order) {
			this.order = order;
		}
		
		@Column(name="item_id")
		public Long getItem_id() {
			return item_id;
		}

		public void setItem_id(Long item_id) {
			this.item_id = item_id;
		}
		
		
	}**/
}
