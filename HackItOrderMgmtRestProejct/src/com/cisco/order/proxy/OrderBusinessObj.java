package com.cisco.order.proxy;

import java.util.Map;

import com.cisco.order.services.representation.OrderListRepresantation;
import com.cisco.order.services.representation.OrderRepresentation;

public interface OrderBusinessObj {
	public OrderRepresentation deleteOrder(OrderRepresentation orderRepresentation);
	public OrderRepresentation saveOrder(OrderRepresentation order);
	public OrderRepresentation getById(Long id);
	public OrderListRepresantation getAll();
	public OrderRepresentation deleteOrder(Long id);
	public OrderListRepresantation searchOrder(Map<String, Object> criteria);
}
