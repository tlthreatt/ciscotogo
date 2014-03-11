package com.cisco.order.dao;

import java.util.List;
import java.util.Map;

import com.cisco.order.model.hibernate.Category;

public interface CategoryDao extends IdentifiableEntityDao<Category>{
	public List<Category> searchCategory(Map<String, Object> criteria);
}
