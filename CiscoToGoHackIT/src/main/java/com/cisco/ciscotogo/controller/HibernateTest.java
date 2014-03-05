package com.cisco.ciscotogo.controller;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest {
	public static void main(String[] args) {
		//Location location = new Location();
		//location.setName("test Location");
		
		//Location location = new Location();

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		

		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//session.save(location);
		
		session.getTransaction().commit();
		
		session.close();
	}
}
