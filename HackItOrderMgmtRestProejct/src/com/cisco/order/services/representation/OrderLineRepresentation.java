package com.cisco.order.services.representation;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import com.cisco.order.model.OrderLineItem;
import com.sun.jersey.server.linking.Ref;

@XmlRootElement
public class OrderLineRepresentation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7006163674886006646L;

	@XmlElement
	private URI self;
	
	public Long orderId;
	public Long itemId;
	public Double itemPrice;
	
	public OrderLineRepresentation() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderLineRepresentation(Long orderId, Long itemId, Double itemPrice) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemPrice = itemPrice;
	}

	public OrderLineRepresentation(OrderLineItem lineItem){
		this.orderId = lineItem.getOrderLineItemPk().getOrder().getId();
		this.itemId = lineItem.getOrderLineItemPk().getItem_id();
		this.itemPrice = lineItem.getItem_cost();
	}
	
	@JsonCreator
	public OrderLineRepresentation(
			@JsonProperty("self") URI uri,
			@JsonProperty("order_id") Long orderId, 
			@JsonProperty("item_id") Long itemId,
			@JsonProperty("item_price") Double itemPrice) {
		this.self = uri;
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemPrice = itemPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public Double getItemPrice() {
		return itemPrice;
	}
	
	public URI getSelf() {
		return self;
	}

}
