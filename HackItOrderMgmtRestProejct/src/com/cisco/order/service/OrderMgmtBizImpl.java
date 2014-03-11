package com.cisco.order.service;

import java.util.Map;
import com.cisco.order.services.representation.OrderRepresentation;

public class OrderMgmtBizImpl extends AbstractOrderMgmtBiz{

	public OrderMgmtBizImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object createOrder(Object obj) {
		obj = proxy.saveOrder((OrderRepresentation) obj);
		return obj;
	}

	@Override
	public Object updateOrder(Object obj) {
		// TODO Auto-generated method stub
		return createOrder(obj);
	}

	@Override
	public Object deleteOrder(Long id) {
		Object rspObj = proxy.deleteOrder(id);
		return rspObj;
	}
	
	@Override
	public Object getOrder(Object obj) {
		Object rspobj = proxy.getById((Long) obj);
		return rspobj;
	}

	@Override
	public Object searchOrder(Map<String, Object> criteria) {
		Object rspObj = null;
		if(criteria == null){
			rspObj = proxy.getAll();
		} else {
			rspObj = proxy.searchOrder(criteria);
		}
		return rspObj;
	}

}
