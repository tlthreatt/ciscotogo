package com.cisco.ciscotogo.dao;

import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Employee;

public class EmployeeDao extends Dao {

	public static Employee get(String email) {
		session = getSession();
		Employee employee = (Employee) session.createQuery("select e from Employee e where email = '" + email + "'").uniqueResult();
		return employee;
	}

	
	public static void save(Employee employee) {
		session = getSession();
		session.beginTransaction();
		
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
	}

	
	public static void delete(Customer employee) {
		session = getSession();
		session.beginTransaction();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		
	}
	

}
