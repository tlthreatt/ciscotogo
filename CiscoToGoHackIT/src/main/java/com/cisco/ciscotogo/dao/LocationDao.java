package com.cisco.ciscotogo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.cisco.ciscotogo.model.Location;

public class LocationDao extends Dao implements DaoInterface<Location>{
	public Location get(int id) {
		Session session = getSession();
		Location location = (Location) session.get(Location.class, id);
		
		return location;
	}

	
	public List<Location> getAll() {
		Session session = getSession();
		
		Query query = session.createQuery("from Location");
		
		List<Location> locations = (List<Location>)query.list();
		
		return locations;
	}
	@Override
	public void save(Location location) {
		Session session = getSession();
		session.beginTransaction();
		
		session.save(location);
		
		session.getTransaction().commit();
		
	}

	

}
