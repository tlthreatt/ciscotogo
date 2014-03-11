package com.cisco.order.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cisco.order.dao.HibernateOrderDao;
import com.cisco.order.dao.OrderDao;
import com.cisco.order.model.hibernate.Order;
import com.cisco.order.model.hibernate.OrderLineItem;
import com.cisco.order.services.representation.OrderLineItemRepresentation;
import com.cisco.order.services.representation.OrderListRepresantation;
import com.cisco.order.services.representation.OrderRepresentation;

public class OrderBuinessObjImpl implements OrderBusinessObj{
	OrderDao orderDAO = new HibernateOrderDao();
	
	public OrderBuinessObjImpl() {
		// TODO Auto-generated constructor stub
		
	}
	
	public OrderListRepresantation searchOrder(Map<String, Object> criteria){
		
		List<Order> orders = orderDAO.searchOrder(criteria);
		OrderListRepresantation orderListRep = mapOrderListToOrderListRepresenation(orders);
		return orderListRep;
	}
	public OrderRepresentation deleteOrder(OrderRepresentation orderRepresentation){
		Order orderModel = mapOrderRepresenationToOrder(orderRepresentation);
		orderDAO.delete(orderRepresentation.getOrderId());
		OrderRepresentation OrderRep = mapOrderToOrderRepesenation(orderModel); 
		return OrderRep;	
	}
	public OrderRepresentation saveOrder(OrderRepresentation order){
		Order orderModel = mapOrderRepresenationToOrder(order);
	    orderDAO.save(orderModel);
		OrderRepresentation OrderRep = mapOrderToOrderRepesenation(orderModel); 
		return OrderRep;		
	}
	
	public OrderRepresentation getById(Long id){
		Order orderModel = orderDAO.getById(id);
		OrderRepresentation OrderRep =  mapOrderToOrderRepesenation(orderModel); 
		return OrderRep;
	}
	
	public OrderListRepresantation getAll(){
		List<Order> orders = orderDAO.getAll();
		OrderListRepresantation orderListRep = mapOrderListToOrderListRepresenation(orders);
		return orderListRep;
	}
	
	public OrderRepresentation deleteOrder(Long id){
		Order orderModel = orderDAO.delete(id);
		OrderRepresentation OrderRep = mapOrderToOrderRepesenation(orderModel); 
		return OrderRep;	
	}
	
	
	
	
	
	
	
	private OrderListRepresantation mapOrderListToOrderListRepresenation(List<Order> orders){
		List<OrderRepresentation> orderRepsenationList = mapOrderListToOrderListRepresneation(orders);
		OrderListRepresantation orderListRepresantation = new OrderListRepresantation(orders.size(), orderRepsenationList);
		return orderListRepresantation;
	}
	private List<OrderRepresentation> mapOrderListToOrderListRepresneation(List<Order> orders){
		List<OrderRepresentation> orderRepresenationList = new ArrayList<OrderRepresentation>();
		for(Order order: orders){
			OrderRepresentation orderRepresenation = mapOrderToOrderRepesenation(order);
			orderRepresenationList.add(orderRepresenation);
		}
		return orderRepresenationList;
	}
	private Order mapOrderRepresenationToOrder(OrderRepresentation orderRep){
		Order order = new Order();
		order.setId(orderRep.getOrderId());
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
		List<OrderLineItemRepresentation> orderLinesRepresentation =  mapOrderLineListToOrderLineListRepresentation(order.getOrderLines());
		OrderRepresentation orderRepresentation = new OrderRepresentation(order.getId(), order.getStatus(), order.getOrderDate(), order.getBuildingID(), order.getUserCEC(), order.getEmployeeId(), orderLinesRepresentation);
		return orderRepresentation;
	}
	
	private List<OrderLineItemRepresentation> mapOrderLineListToOrderLineListRepresentation(List<OrderLineItem> orderLines){
		List<OrderLineItemRepresentation> orderLineItemRepresentationList = new ArrayList<OrderLineItemRepresentation>();
		for(OrderLineItem orderLine: orderLines){
			OrderLineItemRepresentation orderLineItemRepresenation = mapOrderLineItemToOrderLineItemRepresenation(orderLine);
			orderLineItemRepresentationList.add(orderLineItemRepresenation);
		}
		return orderLineItemRepresentationList;
	}
	
	private OrderLineItemRepresentation mapOrderLineItemToOrderLineItemRepresenation(OrderLineItem orderLineItem){
		OrderLineItemRepresentation orderLineItemRepresentation = new OrderLineItemRepresentation(orderLineItem.getOrder().getId(), orderLineItem.getItem_id(), orderLineItem.getItem_cost());
		return orderLineItemRepresentation;
	}

}
