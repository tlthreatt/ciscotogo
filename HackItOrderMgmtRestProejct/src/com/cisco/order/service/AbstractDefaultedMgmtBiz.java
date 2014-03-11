package com.cisco.order.service;

import com.cisco.order.proxy.BusinessProxyObj;

public abstract class AbstractDefaultedMgmtBiz<E,J> implements DefaultedMgmtBiz<E>{
	BusinessProxyObj<E> businessProxyObj;
	
	@SuppressWarnings("unchecked")
	@Override
	public J deleteEntity(E entity) {
		J obj = (J) businessProxyObj.saveEntity(entity);
		return obj;
	}
	@SuppressWarnings("unchecked")
	@Override
	public J getEntityById(Long id) {
		J obj = (J) businessProxyObj.getEntityById(id);
		return obj;
	}
	@SuppressWarnings("unchecked")
	@Override
	public J saveEntity(E entity) {
		J obj = (J) businessProxyObj.saveEntity(entity);
		return obj;
	}
	public BusinessProxyObj<E> getBusinessProxyObj() {
		return businessProxyObj;
	}
	public void setBusinessProxyObj(BusinessProxyObj<E> businessProxyObj) {
		this.businessProxyObj = businessProxyObj;
	}
}
