package com.cisco.order.service;

import java.util.Map;

import com.cisco.order.proxy.OrderHibernateDAOProxy;
import com.cisco.order.services.representation.OrderRepresentation;

public class OrderMgmtBizImpl implements OrderMgmtBiz{

	public OrderMgmtBizImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object createOrder(Object obj) {
		// TODO Auto-generated method stub
		OrderHibernateDAOProxy proxy = new OrderHibernateDAOProxy();
		obj = proxy.saveOrder((OrderRepresentation) obj);
		return obj;
	}

	@Override
	public Object updateOrder(Object obj) {
		// TODO Auto-generated method stub
		return createOrder(obj);
	}

	@Override
	public Object deleteOrder(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getOrder(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object searchOrder(Map<String, Object> criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
