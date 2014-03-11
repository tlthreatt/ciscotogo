package com.cisco.order.service;

import java.util.Map;

import com.cisco.order.dao.OrderDao;

public interface OrderMgmtBiz {
	
	public Object createOrder(Object obj);
	
	public Object updateOrder(Object obj);
	
	public Object deleteOrder(Long id);
	
	public Object getOrder(Object obj);
	
	public Object searchOrder(Map<String, Object> criteria);	
	
}
