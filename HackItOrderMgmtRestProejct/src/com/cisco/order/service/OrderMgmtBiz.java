package com.cisco.order.service;

import java.util.Map;

public interface OrderMgmtBiz {
	
	public Object createOrder(Object obj);
	
	public Object updateOrder(Object obj);
	
	public Object deleteOrder(Object obj);
	
	public Object getOrder(Object obj);
	
	public Object searchOrder(Map<String, Object> criteria);
}
