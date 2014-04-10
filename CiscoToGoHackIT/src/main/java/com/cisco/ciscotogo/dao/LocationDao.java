package com.cisco.ciscotogo.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.cisco.ciscotogo.model.Category;
import com.cisco.ciscotogo.model.Item;
import com.cisco.ciscotogo.model.Location;

public class LocationDao extends Dao {
	public static void main(String[] args) {
		Set<Location> locations = getAllLocationsAndCategoriesAndItems();
	}
	public static Location get(int id) {
		session = getSession();
		Location location = (Location) session.get(Location.class, id);
		
		return location;
	}

	
	public static List<Location> getAll() {
		session = getSession();
		
		Query query = session.createQuery("from Location");
		
		List<Location> locations = (List<Location>)query.list();
		
		return locations;
	}
	public static Set<Location> getAllLocationsAndCategoriesAndItems() {
		session = getSession();
		Query query = session.createQuery("select location from com.cisco.ciscotogo.model.Location location join location.categories categories join categories.items items where location.id = categories.location.id AND items.category.id = categories.id");
		
		Set<Location> locations = new HashSet<Location>((List<Location>)query.list());
		/*
		System.out.println("locations length = " + locations.size());
		for (Location location : locations) {
			System.out.print(location.getName());
			for (Category category : location.getCategories()) {
				System.out.println(category.getName() + " ");
				for (Item item : category.getItems()) {
					System.out.println(item.getName() + " ");
				}
			}
		}
		*/
		return locations;
		
	}
	
	public static void save(Location location) {
		session = getSession();
		session.beginTransaction();
		
		session.save(location);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public static void delete(Location location) {
		session = getSession();
		session.beginTransaction();
		session.delete(location);
		session.getTransaction().commit();
		session.close();
	}

	

}
