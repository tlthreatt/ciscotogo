package com.cisco.order.services.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response;










import com.cisco.order.dao.HibernateOrderDao;
import com.cisco.order.domain.DataAccessException;
import com.cisco.order.model.Order;
import com.cisco.order.model.OrderLineItem;
import com.cisco.order.services.representation.OrderListRepresantation;
import com.cisco.order.services.representation.OrderRepresentation;

@Path("/order")
public class OrderResource {

	public OrderResource() {
		// TODO Auto-generated constructor stub
	}
	/**
	@POST
	@Path("/JCreate2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON})
	public Response createOrder(Order order){
		OrderSubmitDAO d = new OrderSubmitDAO();
		d.saveOrder(order);
		return Response.ok(new OrderRepresentation(order.getOrderId(), order.getUserCEC(), order.getItemID(),order.getBuildingID(), order.getAmmount())).build();
	}**/
	
	@POST
	@Path("/JCreate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON})
	public Response createOrder2(Order order){
		HibernateOrderDao d = new HibernateOrderDao();
		for(OrderLineItem i : order.getOrderLines()){
			i.setOrder(order);
		}
		d.save(order);
		URI uri = UriBuilder.fromPath("").build();
		System.out.println(order.getOrderDate());
		return Response.created(uri).status(Status.OK).entity(new OrderRepresentation(order)).build();
				//ok(new OrderRepresentation(order)).build();
	}
	
	/**
	 * private final String orderId;
	private final String userCEC;
	private final String itemID;
	private final String buildingID;
	private final int ammount;
	private final String status;
	 * @return
	 */
	/**
	@POST
	@Path("/create")
	@Produces({MediaType.APPLICATION_JSON})
	public Response createOrderForm(
			@FormParam("userCEC") String userCEC,
			@FormParam("itemID") String itemID,
			@FormParam("buildingID") String buildingID,
			@FormParam("ammount") Integer ammount){
		System.out.println("WTF" + userCEC + " " + itemID + " " + buildingID + " " + ammount);
		return Response.ok(new OrderRepresentation(1, userCEC, itemID, buildingID, ammount)).build();
	}**/
	/**
	@GET
	@Path("{orderId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getOrder(@PathParam("orderId") int id) {
		OrderSubmitDAO d = new OrderSubmitDAO();
		return Response.ok(new OrderRepresentation(d.getOrder(id))).build();
	}
	**/
	@GET
	@Path("/{orderId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public Response getOrder(@PathParam("orderId") Long id) {		
		HibernateOrderDao d = new HibernateOrderDao();
		return Response.ok(new OrderRepresentation(d.getById(id))).build();		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public Response getOrders() {
		HibernateOrderDao d = new HibernateOrderDao();
		return Response.ok(new OrderListRepresantation(d.getAll())).build();
	}
	
	@GET
	@Path("/cafe/{cafeId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getOrdersByCafeId(@PathParam("cafeId") String id) {
		HibernateOrderDao d = new HibernateOrderDao();
		return Response.ok(new OrderListRepresantation(d.getByCafeId(id))).build();
	}
	/**
	@POST
	@Path("/{A}/{B}/{C}/{D}/{E}/{F}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response placeOrderAgain(
			@PathParam("A") Long a,
			@PathParam("B") String b,
			@PathParam("C") String c,
			@PathParam("D") String d,
			@PathParam("E") Date e,
			@PathParam("F") Long f,
			@PathParam("G") List<OrderLineItem> g) {
		HibernateOrderDao d1 = new HibernateOrderDao();
		Order order = new Order(a, b, c, d, e, f , g) ;
		d1.save(order);
		return Response.ok(new OrderRepresentation(order)).build();
	}**/
}
