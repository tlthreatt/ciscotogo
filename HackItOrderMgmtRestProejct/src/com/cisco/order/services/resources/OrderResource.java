package com.cisco.order.services.resources;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang.StringUtils;

import com.cisco.order.service.OrderMgmtBiz;
import com.cisco.order.service.OrderMgmtBizImpl;
import com.cisco.order.services.representation.OrderListRepresantation;
import com.cisco.order.services.representation.OrderRepresentation;

@Path("/order")
public class OrderResource {
	
	OrderMgmtBiz orderMgmtBiz = new OrderMgmtBizImpl();
	
	public OrderResource() {
		// TODO Auto-generated constructor stub
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON})
	public Response createOrder(OrderRepresentation order){
		OrderMgmtBiz orderMgmtBiz = new OrderMgmtBizImpl();
		order = (OrderRepresentation) orderMgmtBiz.createOrder(order);		
		URI uri = UriBuilder.fromPath("").build();
		return Response.created(uri).status(Status.OK).entity(order).build();
	}
	
	@GET
	@Path("/{orderId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public Response getOrder(@PathParam("orderId") Long id) {		
		OrderRepresentation orderRep = (OrderRepresentation) orderMgmtBiz.getOrder(id);
		return Response.ok(orderRep).build();		
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public Response getOrders() {
		OrderListRepresantation orderRep =  (OrderListRepresantation) orderMgmtBiz.searchOrder(null);
		return Response.ok(orderRep).build();		
	}
	
	@DELETE
	@Path("/{orderId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public Response deleteOrder(@PathParam("orderId") Long id) {
		OrderRepresentation orderRep = (OrderRepresentation) orderMgmtBiz.deleteOrder(id);
		return Response.ok(orderRep).build();		
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public Response deleteOrderByEntity(OrderRepresentation orderRepresenation) {
		OrderRepresentation orderRep = (OrderRepresentation) orderMgmtBiz.deleteOrder(orderRepresenation.getOrderId());		
		return Response.ok(orderRep).build();		
	}
	
	@GET
	@Path("/location/{locationId}")
	public Response getOrdersByLocation(@PathParam(value="locationId") Long locationId){
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("LOCATION_ID", locationId);
		OrderListRepresantation orderListRep = (OrderListRepresantation) orderMgmtBiz.searchOrder(criteria);
		return Response.ok(orderListRep).build();
	}
	
	@GET
	@Path("/CEC/{CEC}")
	public Response getOrdersByCEC(@PathParam(value="CEC") String cecId){
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("LOCATION_ID", cecId);
		OrderListRepresantation orderListRep = (OrderListRepresantation) orderMgmtBiz.searchOrder(criteria);
		return Response.ok(orderListRep).build();
	}
	
	@GET
	@Path("/EMPLOYEE/{employeeId}")
	public Response getOrdersByEmployeeId(@PathParam(value="employeeId") Long employeeId){
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("LOCATION_ID", employeeId);
		OrderListRepresantation orderListRep = (OrderListRepresantation) orderMgmtBiz.searchOrder(criteria);
		return Response.ok(orderListRep).build();
	}
	
	@GET
	@Path("/STATUS/{locationId}")
	public Response getOrdersByStatus(@PathParam(value="locationId") String status){
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("LOCATION_ID", status);
		OrderListRepresantation orderListRep = (OrderListRepresantation) orderMgmtBiz.searchOrder(criteria);
		return Response.ok(orderListRep).build();
	}
	
	@GET
	@Path("query")
	public Response searchOrderByCriterias(
			@QueryParam(value = "CUSTOMER_CEC") String cec,
			@QueryParam(value = "EMPLOYEE_ID") Long employeeId,
			@QueryParam(value = "LOCATION_ID") Long locationId,
			@QueryParam(value = "ORDER_STATUS") String orderStatus,
			@QueryParam(value = "DATE_FROM") Long dateFrom,
			@QueryParam(value = "DATE_TO") Long dateTo){
		Map<String, Object> criteria = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(cec)) criteria.put("CUSTOMER_CEC", cec.toUpperCase());
		if (employeeId != null) criteria.put("EMPLOYEE_ID", employeeId);
		if (locationId != null) criteria.put("LOCATION_ID", locationId);
		if (!StringUtils.isEmpty(orderStatus)) criteria.put("ORDER_STATUS", orderStatus.toUpperCase());
		if (dateFrom != null) criteria.put("DATE_FROM", new Date(dateFrom));
		if (dateTo != null) criteria.put("DATE_TO", new Date(dateTo));
		OrderListRepresantation orderListRep = (OrderListRepresantation) orderMgmtBiz.searchOrder(criteria);
		return Response.ok(orderListRep).build();
	}
	
	public void Test(){
		
	}
}
