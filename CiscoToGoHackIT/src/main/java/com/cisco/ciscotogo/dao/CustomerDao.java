package com.cisco.ciscotogo.dao;

import org.hibernate.Session;

import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Location;

public class CustomerDao extends Dao implements DaoInterface<Customer>{

	@Override
	public Customer get(int id) {
		Session session = getSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void save(Customer customer) {
		Session session = getSession();
		session.beginTransaction();
		
		session.save(customer);
		
		session.getTransaction().commit();
	}

}
