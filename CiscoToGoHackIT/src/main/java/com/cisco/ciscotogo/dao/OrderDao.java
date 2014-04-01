package com.cisco.ciscotogo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Order;
import com.cisco.ciscotogo.model.OrderItem;

public class OrderDao extends Dao implements DaoInterface<Order> {

	
	@Override
	public Order get(int id) {
		Session session = getSession();
		Order order = (Order) session.get(Order.class, id);
		return order;
	}
	
	@Override
	public void save(Order order) {
		Session session = getSession();
		session.beginTransaction();
		
		// Not sure if this should be here or in business layer
		// or should this just be the default in the database instead of 0?
		for (OrderItem orderItem : order.getOrderItems()) {
			if (orderItem.getQuantity() == 0) {
				orderItem.setQuantity(1);
			}
		}
		session.save(order);
		
		session.getTransaction().commit();
		//session.close();
	}
	

	
	public List<Order> getAllOrders(Customer customer) {
		Session session = getSession();
		//session.beginTransaction();
		
		//session.get(Location.class, "pk of class");
		
		Query query = session.createQuery("from Order where customer.cec = " + customer.getCec());
		
		List<Order> orders = (List<Order>)query.list();
		
		//session.getTransaction().commit();
		session.close();
		
		return orders;
	}
	
	public List<Order> getAllOrders(Location location) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.get(Location.class, "pk of class");
		
		Query query = session.createQuery("from Order where location.id = " + location.getId());
		
		List<Order> orders = (List<Order>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return orders;
	}


	
	
}
