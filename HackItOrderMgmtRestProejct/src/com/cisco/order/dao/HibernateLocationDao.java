package com.cisco.order.dao;

import java.util.List;
import java.util.Map;

import com.cisco.order.model.hibernate.Location;
import com.cisco.order.model.hibernate.Order;
public class HibernateLocationDao extends AbstractHibernateDao<Location>implements LocationDao{
	@Override
	public List<Location> searchLocation(Map<String, Object> criteria){
		return null;
		
	}
}
