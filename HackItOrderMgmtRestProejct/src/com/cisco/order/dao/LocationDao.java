package com.cisco.order.dao;

import java.util.List;
import java.util.Map;

import com.cisco.order.model.hibernate.Location;
public interface LocationDao extends IdentifiableEntityDao<Location>{

	public List<Location> searchLocation(Map<String, Object> criteria);

}
