package com.cisco.order.proxy;

public interface BusinessProxyObj<E> {
	public Object saveEntity(E e);
	public Object deleteEntity(E e);
	public Object getEntityById(Long id);
}
