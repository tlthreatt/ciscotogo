package com.cisco.ciscotogo.buisness;

import com.cisco.ciscotogo.dao.CustomerDao;
import com.cisco.ciscotogo.model.Customer;

public class CustomerBiz {
	public static Customer validatePassword(String cec, String password) {
		Customer customer;
		
		customer = CustomerDao.get(cec);
		if (customer == null || customer.getCec() == null)  {
			System.out.println("customer == null || customer.getPassword() == null");
			return null;
		}

		if (!customer.getPassword().equals(password)) {
			System.out.println("passwords dont match");
			return null;
		} 
		// Set password to null so that its not passed over Json
		// nevermind this gives odd behavior
		//customer.setPassword(null);
		// This should fetch the customer balance, which I'll hard code for now.
		customer.setBalance(20.00);
		System.out.println("returning customer");
		return customer;
	}

}
