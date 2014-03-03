package com.cisco.order.dao;
import java.util.List;

import com.cisco.order.domain.DataAccessException;
import com.cisco.order.model.Order;

public interface OrderDao{
	public Order getById(Long id) throws DataAccessException;

    public Order getByEmail(String email) throws DataAccessException;

    public List<Order> getAll() throws DataAccessException;

    public void save(Order order) throws DataAccessException;

    public void delete(Order order) throws DataAccessException;
}