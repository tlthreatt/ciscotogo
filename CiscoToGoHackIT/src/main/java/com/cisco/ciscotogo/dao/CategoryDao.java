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


public class CategoryDao extends Dao implements DaoInterface<Category>{
	
	public static void main(String[] args) {
		CategoryDao dao = new CategoryDao();
		
		/*
		Location location = new Location();
		location.setName("Freedom Circle");
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category("Cat 1", false, null, location));
		categories.add(new Category("Cat 2", false, null, location));
		categories.add(new Category("Cat 3", false, null, location));
		location.setCategories(categories);
		dao.save(location);
		
		*/
		//Configuration configuration = new Configuration().configure();
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		//SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//Session session = sessionFactory.openSession();
		
		
		//List<Category> categories = dao.getAllCategories(location)
	}
	
	
	
	public Category get(int id) {
		Session session = getSession();
		Category category = (Category) session.get(Category.class, id);
		return category;
	}

	@Override
	public void save(Category category) {
		Session session = getSession();
		//session.beginTransaction();
		
		session.save(category);
		
		//session.getTransaction().commit();
		//session.close();
	}

	
	public List<Category> getAll(Location location) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Category where location.id = " + location.getId());
		List<Category> categories = (List<Category>)query.list();
		
		session.getTransaction().commit();
		//session.close();
		
		return null;
	}





}
