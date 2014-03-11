package com.cisco.ciscotogo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.cisco.ciscotogo.model.Category;
import com.cisco.ciscotogo.model.Location;


public class CategoryDao {
	Configuration configuration = new Configuration().configure();
	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	

	
	
	
	//session.save(location);
	
	public List<Location> getAllLocations() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.get(Location.class, "pk of class");
		
		Query query = session.createQuery("from Location");
		// Pagination
		/*
		 * query.setFirstResult(5);
		 * query.setMaxResults(5);
		 * 
		 */
		
		List<Location> locations = (List<Location>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return locations;
	}
	
	public List<Category> getAllCategories(Location location) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Category where location = :");
		List<Category> categories = (List<Category>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return null;
	}

}
