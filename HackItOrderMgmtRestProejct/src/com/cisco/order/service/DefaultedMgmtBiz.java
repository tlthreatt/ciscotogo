package com.cisco.order.service;

public interface DefaultedMgmtBiz<E> {
	public Object saveEntity(E entity);
	
	public Object deleteEntity(E entity);
	
	public Object getEntityById(Long id);
}
