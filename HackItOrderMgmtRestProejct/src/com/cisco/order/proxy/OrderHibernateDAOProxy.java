package com.cisco.order.proxy;

import com.cisco.order.dao.HibernateOrderDao;
import com.cisco.order.dao.OrderDao;
import com.cisco.order.model.Order;
import com.cisco.order.model.OrderLineItem;
import com.cisco.order.services.representation.OrderLineItemRepresentation;
import com.cisco.order.services.representation.OrderLineRepresentation;
import com.cisco.order.services.representation.OrderRepresentation;

public class OrderHibernateDAOProxy implements OrderProxy{

	public OrderHibernateDAOProxy() {
		// TODO Auto-generated constructor stub
		
	}
	
	public OrderRepresentation saveOrder(OrderRepresentation order){
		Order orderModel = mapOrderRepresenationToOrder(order);
		OrderDao orderDAO = new HibernateOrderDao();
	    orderDAO.save(orderModel);
		OrderRepresentation OrderRep = mapOrderToOrderRepesenation(orderModel); 
		return OrderRep;		
	}
	
	private Order mapOrderRepresenationToOrder(OrderRepresentation orderRep){
		Order order = new Order();
		order.setBuildingID(orderRep.getLocationId());
		order.setEmployeeId(orderRep.getEmployeeId());
		order.setOrderDate(orderRep.getOrderDate());
		order.setStatus(orderRep.getStatus());
		order.setUserCEC(orderRep.getUserCEC());
		for(OrderLineItemRepresentation i : orderRep.getOrderLines()){
			OrderLineItem orderLine= new OrderLineItem(order,i.getItemId(),i.getItemPrice()); 
			order.getOrderLines().add(orderLine);
		}
		return order;
	}
	
	private OrderRepresentation mapOrderToOrderRepesenation(Order order){
		OrderRepresentation orderRepresentation = new OrderRepresentation(order);		
		return orderRepresentation;
	}

}
