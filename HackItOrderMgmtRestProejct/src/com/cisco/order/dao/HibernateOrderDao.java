package com.cisco.order.dao;

import java.util.List;

import javax.xml.bind.DataBindingException;

import org.hibernate.exception.ConstraintViolationException;

import com.cisco.order.domain.DataAccessException;
import com.cisco.order.domain.DuplicateEntityException;
import com.cisco.order.model.Order;
import com.cisco.order.providers.DuplicateEntityExceptionMapper;

public class HibernateOrderDao extends AbstractHibernateDao implements OrderDao {

	@Override
	public Order getById(Long id) {
		
			return (Order) super.getById(Order.class, id);		
	}

	@Override
	public Order getByEmail(String email) throws DataAccessException {
		return (Order) super.findOne("from User where email =?", email);
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getByCafeId(String cafeId){
		return (List<Order>) super.findAll("from Order where buildingID =?", cafeId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAll() throws DataAccessException {
		return (List<Order>) super.findAll("from Order order by id");
	}

	@Override
	public void save(Order order) {
		try{
			super.save(order);
		} catch (ConstraintViolationException e){
			throw new DuplicateEntityException();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DuplicateEntityException();
		}

	}

	@Override
	public void delete(Order order) throws DataAccessException {
		super.delete(order);

	}
}
