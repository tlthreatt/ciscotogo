package com.cisco.ciscotogo.buisness;

import com.cisco.ciscotogo.dao.EmployeeDao;
import com.cisco.ciscotogo.model.Employee;

public class EmployeeBiz {
	public static Employee validatePassword(String email, String password) {
		Employee employee;
		
		employee = EmployeeDao.get(email);
		if (employee == null || employee.getEmail() == null)  {
			System.out.println("customer == null || customer.getPassword() == null");
			return null;
		}

		if (!employee.getPassword().equals(password)) {
			System.out.println("passwords dont match");
			return null;
		} 
		
		return employee;
	}

}
