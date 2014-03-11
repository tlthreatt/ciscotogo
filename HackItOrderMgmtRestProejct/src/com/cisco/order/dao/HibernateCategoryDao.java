package com.cisco.order.dao;

import java.util.List;
import java.util.Map;

import com.cisco.order.model.hibernate.Category;

public class HibernateCategoryDao extends AbstractHibernateDao<Category> implements CategoryDao{

	@Override
	public List<Category> searchCategory(Map<String, Object> criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
