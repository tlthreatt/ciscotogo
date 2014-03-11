package com.cisco.order.model.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.AttributeOverride;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.cisco.order.domain.IdentifiableEntity;

@Entity
@Table(name = "`order`")
@XmlRootElement
@JsonIgnoreProperties
@AttributeOverrides({
    @AttributeOverride(name="id", column=@Column(name="order_id")),
})
public class Order extends IdentifiableEntity{
	private static final long serialVersionUID = 8896567139368730035L;
	
	public String userCEC;
	public Long buildingID;
	public String status;
	public Date orderDate;
	public Long employeeId;
	public List<OrderLineItem> orderLines = new ArrayList<OrderLineItem>();
	
	public Order(){}
	
	public Order(Long orderId, String userCEC, Long buildingID, String status, Date orderDate, Long employeeId, List<OrderLineItem> items) {
		setId(orderId); 
		this.userCEC = userCEC;
		this.buildingID = buildingID;
		this.status = status;
		this.orderDate = orderDate;
		this.employeeId = employeeId;
		this.orderLines = items;
	}
	
	@Column(name = "customer_cec") 
	public String getUserCEC() {
		return userCEC;
	}
	
	
	@Column(name = "location_id") 
	public Long getBuildingID() {
		return buildingID;
	}

	@Column(name = "order_status", length=30) 
	public String getStatus() {
		return status;
	}
	
	@Column(name = "employee_id") 
	public Long getEmployeeId() {
		return employeeId;
	}
	
	@Column(name = "order_date") 
	public Date getOrderDate() {
		return orderDate;
	}
	
	@OneToMany(mappedBy = "order",fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @OrderBy("item_id")  
	public List<OrderLineItem> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLineItem> orderLines) {
		this.orderLines = orderLines;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public void setUserCEC(String userCEC) {
		this.userCEC = userCEC;
	}

	public void setBuildingID(Long buildingID) {
		this.buildingID = buildingID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}
