package com.cisco.ciscotogo.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Order;
import com.cisco.ciscotogo.model.OrderItem;

public class OrderDao extends Dao  {

	
	
	public static Order get(int id) {
		session = getSession();
		Order order = (Order) session.get(Order.class, id);
		return order;
	}
	
	
	public static void save(Order order) {
		session = getSession();
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
		session.close();
	}
	

	
	public static List<Order> getAll(Customer customer) {
		session = getSession();

		Query query = session.createQuery("from com.cisco.ciscotogo.model.Order where customer.cec = '" + customer.getCec() + "'");
		
		List<Order> orders = (List<Order>)query.list();
		
		
		return orders;
	}
	
	public static List<Order> getAllRecent(Customer customer, int maxResults) {
		session = getSession();
		Query query = session.createQuery("from com.cisco.ciscotogo.model.Order where customer.cec = '" + customer.getCec() + "'").setMaxResults(maxResults);
		List<Order> orders = (List<Order>)query.list();
		return orders;
	}
	
	public static Set<Order> getAllRecent(Location location) {
		session = sessionFactory.openSession();
		Calendar nowDate = new GregorianCalendar();
		Calendar floorDate = (Calendar)nowDate.clone();
		floorDate.set(Calendar.HOUR_OF_DAY, 0);
		floorDate.set(Calendar.MINUTE, 0);
		floorDate.set(Calendar.SECOND, 0);
		floorDate.set(Calendar.MILLISECOND, 0);
		
		String hql = "from com.cisco.ciscotogo.model.Order where location.id = :id";// and date >= :floorDate and date <= :nowDate";
		Query query = session.createQuery(hql).setInteger("id", location.getId());//.setDate("floorDate", floorDate.getTime()).setDate("nowDate", nowDate.getTime());
		
		Set<Order> orders = new LinkedHashSet((List<Order>)query.list());
		
		return orders;
	}

	
	public static void delete(Order order) {
		session = getSession();
		session.beginTransaction();
		session.delete(order);
		session.getTransaction().commit();
		session.close();
	}


	public static void setOrderToReady(Order o) {
		Order order = (Order)get(o.getId());
		order.setStatus("Ready");
		save(order);
	}
	public static void setOrderToComplete(Order o) {
		Order order = (Order)get(o.getId());
		order.setStatus("Complete");
		save(order);
	}


	
	
}
