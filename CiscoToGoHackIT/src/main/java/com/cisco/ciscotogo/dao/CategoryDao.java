package com.cisco.ciscotogo.dao;

import java.util.List;

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
	

}
