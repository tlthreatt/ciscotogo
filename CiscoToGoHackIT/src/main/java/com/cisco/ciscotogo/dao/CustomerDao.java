package com.cisco.ciscotogo.dao;

import org.hibernate.Session;

import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Location;

public class CustomerDao extends Dao {
	public static void main(String[] args) {
		Customer customer = get("tathreat");
	}
	public static Customer get(String cec) {
		session = getSession();
		Customer customer = (Customer) session.get(Customer.class, cec);
		//System.out.println("customerdao: customer == " + customer + " password == " + customer.getPassword() + " firstname == " + customer.getFirstName());
		
		return customer;
	}

	
	public static void save(Customer customer) {
		session = getSession();
		session.beginTransaction();
		
		session.save(customer);
		
		session.getTransaction().commit();
		session.close();
	}

	
	public static void delete(Customer customer) {
		session = getSession();
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
		
	}
	

}
