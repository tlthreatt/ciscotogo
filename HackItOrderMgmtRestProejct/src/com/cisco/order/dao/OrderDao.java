package com.cisco.order.dao;
import java.util.List;
import java.util.Map;

import com.cisco.order.domain.DataAccessException;
import com.cisco.order.model.hibernate.Order;

public interface OrderDao extends IdentifiableEntityDao<Order> {

    public List<Order> getAll() throws DataAccessException;
    
    public Order delete(Long id) throws DataAccessException;
    
    public List<Order> searchOrder(Map<String, Object> criteria) throws DataAccessException;
}