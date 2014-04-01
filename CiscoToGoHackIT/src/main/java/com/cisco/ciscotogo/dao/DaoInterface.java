package com.cisco.ciscotogo.dao;

import java.util.List;

public interface DaoInterface<T> {
	public T get(int id);
	public void save(T t);
}
