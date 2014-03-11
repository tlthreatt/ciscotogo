package com.cisco.order.service;

import com.cisco.order.dao.HibernateOrderDao;
import com.cisco.order.dao.OrderDao;
import com.cisco.order.proxy.OrderBuinessObjImpl;
import com.cisco.order.proxy.OrderBusinessObj;

public abstract class AbstractOrderMgmtBiz implements OrderMgmtBiz{
	public OrderBusinessObj proxy = new OrderBuinessObjImpl();
}
