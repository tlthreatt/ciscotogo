package com.cisco.order.services.representation;

import java.io.Serializable;
import java.net.URI;
import java.util.Collection;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import com.cisco.order.model.hibernate.Order;
import com.sun.jersey.server.linking.Link;
import com.sun.jersey.server.linking.Ref;

@Link(value = @Ref("order"), rel = "self")
@XmlRootElement
public class OrderListRepresantation implements Serializable{

	private static final long serialVersionUID = 7833435468446442021L;

	@Ref("order")
	@XmlElement
	private URI self;
	
	@XmlElement
	private int orderCount;
	
	@XmlElements(value = { @XmlElement(name="order") } )
	@JsonProperty("orders")
	private Collection<OrderRepresentation> orders;
	
	public OrderListRepresantation() {
		
	}

	public OrderListRepresantation(int orderCount,
			Collection<OrderRepresentation> orders) {
		super();
		this.orderCount = orderCount;
		this.orders = orders;
	}

	@JsonCreator
	public OrderListRepresantation(
			@JsonProperty("count") int count,
			@JsonProperty("self") URI self,
			@JsonProperty("orders") Collection<OrderRepresentation> orders
			){
		this.self = self;
		this.orderCount = count;
		this.orders = orders;
		
	}
	
	public URI getSelf() {
		return self;
	}

	public Collection<OrderRepresentation> getOrders() {
		return orders;
	}
	public int getOrderCount() {
		return orderCount;
	}
}
