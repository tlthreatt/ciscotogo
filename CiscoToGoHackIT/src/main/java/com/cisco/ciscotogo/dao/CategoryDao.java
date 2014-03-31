package com.cisco.ciscotogo.dao;

import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		CategoryDao dao = new CategoryDao();
		
		Location location = new Location();
		location.setName("Freedom Circle");
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category("Cat 1", false, null, location));
		categories.add(new Category("Cat 2", false, null, location));
		categories.add(new Category("Cat 3", false, null, location));
		dao.save(location);
		
		//List<Category> categories = dao.getAllCategories(location)
	}
	
	
	Configuration configuration = new Configuration().configure();
	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
	
	
	
	
	public void save(Location location) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(location);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Location> getAllLocations() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.get(Location.class, "pk of class");
		
		Query query = session.createQuery("from Location");
		
		List<Location> locations = (List<Location>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return locations;
	}
	
	public List<Category> getAllCategories(Location location) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Category where location.id = " + location.getId());
		List<Category> categories = (List<Category>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return null;
	}

}
