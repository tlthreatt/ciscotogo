package com.cisco.ciscotogo.buisness;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.Target;

import com.cisco.ciscotogo.dao.CustomerDao;
import com.cisco.ciscotogo.dao.EmployeeDao;
import com.cisco.ciscotogo.dao.LocationDao;
import com.cisco.ciscotogo.model.Category;
import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Employee;
import com.cisco.ciscotogo.model.Item;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.LocationList;

public class Debug {
	public static void main(String[] args) {
		Debug.InitializeDatabase();
	}
	public static void InitializeDatabase() {
		System.out.println("Theoretically starting to create schema");
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SchemaExport schemaExport = new SchemaExport(serviceRegistry, configuration);
		schemaExport.create(Target.BOTH);
		System.out.println("Theoretically finished creating schema");
		/*
		try {
			Location location = LocationDao.get(1);
			LocationDao.delete(location);
			
			
			System.out.println("Theoretically deleted");
		} catch (Exception e) {
			System.out.println("Not deleted " + e.getMessage());
			LocationDao.getSession().close();
		}
		
	try {
		Customer customer = CustomerDao.get("tathreat");
		CustomerDao.delete(customer);
	} catch (Exception e) {
		System.out.println("Not deleted " + e.getMessage());
		CustomerDao.getSession().close();
	}
		*/
		LocationList allLocations = new LocationList();
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<Item> itemsJ = new ArrayList<Item>();
		Set<Category> categoriesJ = new HashSet<Category>();
		ArrayList<Item> menuItemsFLSC2 = new ArrayList<Item>();
		ArrayList<Category> menuCategoriesFLSC2 = new ArrayList<Category>();
		
		Location location = new Location();
		location.setName("Bldg J");
		
		Category americanGrill = new Category("American Grill", false);
		americanGrill.setLocation(location);
		
		Item chickenSandwhich = new Item();
		chickenSandwhich.setName("Chicken Sandwhich");
		chickenSandwhich.setListPrice(6.00);
		chickenSandwhich.setCategory(americanGrill);
		
		Item pepsi = new Item();
		pepsi.setName("Pepsi");
		pepsi.setListPrice(1.00);
		pepsi.setCategory(americanGrill);
		
		itemsJ.add(chickenSandwhich); itemsJ.add(pepsi);
		
		americanGrill.setItems(itemsJ);
		
		categoriesJ.add(americanGrill);
		
		location.setCategories(categoriesJ);
	
		LocationDao.save(location);
	
		locations.add(location);
		
		
		Customer customer = new Customer("tathreat");
		customer.setEmail("tathreat@cisco.com");
		customer.setFirstName("Taylor");
		customer.setLastName("Threatt");
		customer.setPassword("password");
		customer.setTextEnabled(true);
		//turn this off
		CustomerDao.save(customer);
		
		Employee employee = new Employee("matthew@ciscotogo.com");
		employee.setFirstName("Matthew");
		employee.setLastName("Moisen");
		employee.setPassword("password");
		employee.setLocation(location);
		EmployeeDao.save(employee);
	
		
		
	}
}
