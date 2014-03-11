package com.cisco.order.services.representation;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import com.sun.jersey.server.linking.Link;
import com.sun.jersey.server.linking.Links;
import com.sun.jersey.server.linking.Ref;

@Links({
	@Link(value = @Ref("order/{orderId}"), rel = "self"),
	@Link(value = @Ref("order"), rel = "up")
})
@XmlRootElement(name = "order")
@JsonTypeName( value = "order")
public class OrderRepresentation {
	
	@Ref("order/{orderId}")
	@XmlElement
	private URI self;	
	@XmlElement
	private Long orderId;
	@XmlElement
	private String status;
	@XmlElement
	private Date orderDate;
	@XmlElement
	private Long locationId;
	@XmlElement
	private Long employeeId;
	@XmlElement
	private String userCEC;
	@XmlElement
	private List<OrderLineItemRepresentation> orderLines;
	
	public OrderRepresentation(){
		
	}
	public OrderRepresentation(Long orderId,
			String status, Date orderDate, Long locationId, String userCEC,
			Long employeeId, List<OrderLineItemRepresentation> children) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.orderDate = orderDate;
		this.locationId = locationId;
		this.userCEC = userCEC;
		this.employeeId = employeeId;
		this.orderLines = children;
	}
	
	@JsonCreator
	private OrderRepresentation(
			@JsonProperty("self") URI self,
			@JsonProperty("orderId") Long orderId, 
			@JsonProperty("status") String status,
			@JsonProperty("orderDate") Date orderDate,
			@JsonProperty("locationId") Long locationId,
			@JsonProperty("userCEC") String userCEC,
			@JsonProperty("employeeId") Long employeeId,
			@JsonProperty("orderLine") ArrayList<OrderLineItemRepresentation> orderlines) {
		this.self = self;
		this.orderId = orderId;
		this.status = status;
		this.orderDate = orderDate;
		this.locationId = locationId;
		this.userCEC = userCEC;
		this.employeeId = employeeId;
		this.orderLines = orderlines;
	}

	public URI getSelf() {
		return self;
	}
	public Long getOrderId() {
		return orderId;
	}
	public String getStatus() {
		return status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public Long getLocationId() {
		return locationId;
	}
	public String getUserCEC() {
		return userCEC;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public List<OrderLineItemRepresentation> getOrderLines() {
		return orderLines;
	}
}
