package com.cisco.ciscotogo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Rating;

public class RatingDao extends Dao  {

	
	public static Rating get(int id) {
		session = getSession();
		Rating rating = (Rating) session.get(Rating.class, id);
		return rating;
	}


	public static void save(Rating rating) {
		session = getSession();
		session.beginTransaction();
		session.save(rating);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public static void delete(Rating rating) {
		session = getSession();
		session.beginTransaction();
		session.delete(rating);
		session.getTransaction().commit();
		session.close();
	}
	
	public static List<Rating> getAll(Location location) {
		session = getSession();
		String hql = "from com.cisco.ciscotogo.model.Rating where location.id = :id";
		Query query = session.createQuery(hql).setInteger("id",  location.getId());
		
		List<Rating> ratings = (ArrayList<Rating>)query.list();
		
		return ratings;
	}

}
