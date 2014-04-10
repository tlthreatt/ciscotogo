package com.cisco.ciscotogo.buisness;

import java.sql.Time;
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
//import com.cisco.ciscotogo.dao.RatingDao;
import com.cisco.ciscotogo.model.Category;
import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Employee;
import com.cisco.ciscotogo.model.Item;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.LocationAddress;
import com.cisco.ciscotogo.model.LocationHours;
import com.cisco.ciscotogo.model.LocationList;
import com.cisco.ciscotogo.model.Rating;

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
		ArrayList<Item> bevItemsJ = new ArrayList<Item>();
		ArrayList<Item> italyItemsJ = new ArrayList<Item>();
		
		ArrayList<Item> itemsFLSC2 = new ArrayList<Item>();
		ArrayList<Item> bevItemsFLSC2 = new ArrayList<Item>();
		ArrayList<Item> chinaItemsFLSC2 = new ArrayList<Item>();
		
		Set<Category> categoriesJ = new HashSet<Category>();
		Set<Category> categoriesFLSC2 = new HashSet<Category>();
		
		Location location = new Location();
		location.setName("Bldg J");
		LocationAddress locationAddress = new LocationAddress();
		locationAddress.setLocation(location);
		locationAddress.setCity("San Jose");
		locationAddress.setCountry("USA");
		locationAddress.setState("CA");
		locationAddress.setStreet("255 W Tasman Dr");
		locationAddress.setZip("95134");
		LocationHours locationHours = new LocationHours();
		locationHours.setLocation(location);
		locationHours.setBreakfastStart(new Time(7,30,0));
		locationHours.setBreakfastEnd(new Time(9,30,0));
		locationHours.setLunchStart(new Time(11,30,0));
		locationHours.setLunchEnd(new Time(13,30,0));
		location.setLocationAddress(locationAddress);
		location.setLocationHours(locationHours);
		
		
		Location locationFLSC2 = new Location();
		locationFLSC2.setName("Webex Tower");
		
		Category americanGrill = new Category("American Grill", false);
		americanGrill.setLocation(location);
		
		Category americanGrillFLSC2 = new Category("American Grill", false);
		americanGrillFLSC2.setLocation(locationFLSC2);
		
		Category beveragesJ = new Category("Beverages", false);
		beveragesJ.setLocation(location);
		
		Category beveragesFLSC2 = new Category("Beverages", false);
		beveragesFLSC2.setLocation(locationFLSC2);
		
		Category mariosJ = new Category("Mario's Italian Kitchen", false);
		mariosJ.setLocation(location);
		
		Category chinaFLSC2 = new Category("China Bistro", false);
		chinaFLSC2.setLocation(locationFLSC2);
		
			
		//these are items for bldg J
		Item chickenSandwhich = new Item();
		chickenSandwhich.setName("Chicken Sandwhich");
		chickenSandwhich.setListPrice(6.00);
		chickenSandwhich.setCategory(americanGrill);
		
		Item hamburgerJ = new Item();
		hamburgerJ.setName("Hamburger");
		hamburgerJ.setListPrice(6.00);
		hamburgerJ.setCategory(americanGrill);
		
		Item pepsi = new Item();
		pepsi.setName("Pepsi");
		pepsi.setListPrice(1.00);
		pepsi.setCategory(beveragesJ);
		
		Item snappleJ = new Item();
		snappleJ.setName("Snapple Green Tea");
		snappleJ.setListPrice(1.99);
		snappleJ.setCategory(beveragesJ);
		
		Item lasagnaJ = new Item();
		lasagnaJ.setName("Lasagna (contains meat)");
		lasagnaJ.setListPrice(5.99);
		lasagnaJ.setCategory(mariosJ);
		
		Item eggplantJ = new Item();
		eggplantJ.setName("Eggplant Parmesan");
		eggplantJ.setListPrice(5.99);
		eggplantJ.setCategory(mariosJ);
		
		itemsJ.add(chickenSandwhich); bevItemsJ.add(pepsi);
		itemsJ.add(hamburgerJ); bevItemsJ.add(snappleJ);
		italyItemsJ.add(eggplantJ); italyItemsJ.add(lasagnaJ);
		
		americanGrill.setItems(itemsJ);
		mariosJ.setItems(italyItemsJ);
		beveragesJ.setItems(bevItemsJ);
		
		categoriesJ.add(americanGrill);
		categoriesJ.add(beveragesJ);
		categoriesJ.add(mariosJ);
		
		location.setCategories(categoriesJ);
		System.out.println("Supposed to be saving location  J");		
		LocationDao.save(location);
	
		locations.add(location);
	
		
		//these items are for FLSC2
		Item chickenSandwhichFLSC2 = new Item();
		chickenSandwhichFLSC2.setName("Chicken Sandwhich");
		chickenSandwhichFLSC2.setListPrice(6.00);
		chickenSandwhichFLSC2.setCategory(americanGrillFLSC2);
		
		Item hamburgerFLSC2 = new Item();
		hamburgerFLSC2.setName("Hamburger");
		hamburgerFLSC2.setListPrice(6.00);
		hamburgerFLSC2.setCategory(americanGrillFLSC2);
		
		Item pepsiFLSC2 = new Item();
		pepsiFLSC2.setName("Pepsi");
		pepsiFLSC2.setListPrice(1.00);
		pepsiFLSC2.setCategory(beveragesFLSC2);
		
		Item snappleFLSC2 = new Item();
		snappleFLSC2.setName("Snapple Green Tea");
		snappleFLSC2.setListPrice(1.99);
		snappleFLSC2.setCategory(beveragesFLSC2);
		
		Item kungpowChicFLSC2 = new Item();
		kungpowChicFLSC2.setName("Kung Pow Chicken (with rice)");
		kungpowChicFLSC2.setListPrice(5.99);
		kungpowChicFLSC2.setCategory(chinaFLSC2);
		
		Item tofuFLSC2 = new Item();
		tofuFLSC2.setName("Fried Tofu Chow Mein");
		tofuFLSC2.setListPrice(5.99);
		tofuFLSC2.setCategory(chinaFLSC2);
		
		itemsFLSC2.add(chickenSandwhich); bevItemsFLSC2.add(pepsi);
		itemsFLSC2.add(hamburgerJ); bevItemsFLSC2.add(snappleJ);
		chinaItemsFLSC2.add(eggplantJ); chinaItemsFLSC2.add(lasagnaJ);
		
		americanGrillFLSC2.setItems(itemsFLSC2);
		chinaFLSC2.setItems(chinaItemsFLSC2);
		beveragesFLSC2.setItems(bevItemsFLSC2);
		
		categoriesFLSC2.add(americanGrillFLSC2);
		categoriesFLSC2.add(beveragesFLSC2);
		categoriesFLSC2.add(chinaFLSC2);
		
		locationFLSC2.setCategories(categoriesFLSC2);
		System.out.println("Supposed to be saving location FLSC2");		
		LocationDao.save(locationFLSC2);
	
		locations.add(locationFLSC2);
		
		
		
		
		//CUSTOMERS
		Customer customer = new Customer("tathreat");
		customer.setEmail("tathreat@cisco.com");
		customer.setFirstName("Taylor");
		customer.setLastName("Threatt");
		customer.setPassword("password");
		customer.setBalance(20.00);
		customer.setTextEnabled(true);
		//turn this off
		CustomerDao.save(customer);
		
		/*
		Customer customer1 = new Customer("clachan");
		customer1.setEmail("clachan@cisco.com");
		customer1.setFirstName("Clayton");
		customer1.setLastName("Chan");
		customer1.setPassword("password");
		customer1.setTextEnabled(true);
		customer1.setBalance(15.00);
		//turn this off
		CustomerDao.save(customer1);
		*/
		
		/*
		Customer customer2 = new Customer("eyaklin");
		customer2.setEmail("eyaklin@cisco.com");
		customer2.setFirstName("Eric");
		customer2.setLastName("Yaklin");
		customer2.setPassword("password");
		customer2.setTextEnabled(false);
		// turn this off
		customer2.setBalance(10.00);
		CustomerDao.save(customer2);
		
		
		// RATINGS
		Rating rating1 = new Rating("The cute lunch lady won't go out with me", 1);
		rating1.setCustomer(customer);
		rating1.setLocation(location);
		RatingDao.save(rating1);
		
		Rating rating2 = new Rating("This is my favorite cafeteria in Cisco", 5);
		rating2.setCustomer(customer1);
		rating2.setLocation(location);
		RatingDao.save(rating2);
		*/
		
		//EMPLOYEES
		Employee employee = new Employee("matthew@ciscotogo.com");
		employee.setFirstName("Matthew");
		employee.setLastName("Moisen");
		employee.setPassword("password");
		employee.setLocation(location);
		EmployeeDao.save(employee);
		/*
		Employee employee1 = new Employee("taylor@ciscotogo.com");
		employee1.setFirstName("Taylor");
		employee1.setLastName("Threatt");
		employee1.setPassword("password");
		employee1.setLocation(location);
		EmployeeDao.save(employee1);
		*/
		
		
	}
}
