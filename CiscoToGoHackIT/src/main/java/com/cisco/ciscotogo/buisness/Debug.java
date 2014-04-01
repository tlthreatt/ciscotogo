package com.cisco.ciscotogo.buisness;

import java.util.ArrayList;
import java.util.List;

import com.cisco.ciscotogo.dao.CustomerDao;
import com.cisco.ciscotogo.dao.LocationDao;
import com.cisco.ciscotogo.model.Category;
import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Item;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.LocationList;

public class Debug {
	public static void main(String[] args) {
		Debug.InitializeDatabase();
	}
	public static List<Location> InitializeDatabase() {
		LocationList allLocations = new LocationList();
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<Item> itemsJ = new ArrayList<Item>();
		ArrayList<Category> categoriesJ = new ArrayList<Category>();
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
	
		
		LocationDao locationDao = new LocationDao();
		locationDao.save(location);
		
		locations.add(location);
		
		CustomerDao customerDao = new CustomerDao();
		Customer customer = new Customer("tathreat");
		customer.setEmail("tathreat@cisco.com");
		customer.setFirstName("Taylor");
		customer.setLastName("Threatt");
		customer.setTextEnabled(true);
		
		customerDao.save(customer);
		
		return locations;
	}
}
