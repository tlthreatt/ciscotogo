package com.cisco.order.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.cisco.order.domain.DataAccessException;
import com.cisco.order.domain.DuplicateEntityException;
import com.cisco.order.model.hibernate.Order;

import org.apache.commons.lang.*;


public class HibernateOrderDao extends AbstractHibernateDao<Order> implements OrderDao {
	
	@Override
	public List<Order> getAll() throws DataAccessException {
		return (List<Order>) super.findAll("from Order order by id");
	}
	
	@Override
	public List<Order> searchOrder(Map<String, Object> criteria)
			throws DataAccessException {
		Criteria criterion = this.getSession().createCriteria(Order.class,"order");
		if(criteria.get("LOCATION_ID") != null && !StringUtils.isEmpty(criteria.get("LOCATION_ID").toString()) ){
			criterion.add(Restrictions.eq("order.buildingID", criteria.get("LOCATION_ID")));
		}
		if(criteria.get("CUSTOMER_CEC") != null && !StringUtils.isEmpty(criteria.get("CUSTOMER_CEC").toString()) ){
			criterion.add(Restrictions.eq("order.userCEC", criteria.get("CUSTOMER_CEC").toString()));
		}	
		if(criteria.get("EMPLOYEE_ID") != null && !StringUtils.isEmpty(criteria.get("EMPLOYEE_ID").toString()) ){
			criterion.add(Restrictions.eq("order.employeeId", criteria.get("EMPLOYEE_ID")));
		}	
		if(criteria.get("ORDER_STATUS") != null && !StringUtils.isEmpty(criteria.get("ORDER_STATUS").toString()) ){
			criterion.add(Restrictions.eq("order.status", criteria.get("ORDER_STATUS").toString()));
		}
		if(criteria.get("DATE_FROM") != null && !StringUtils.isEmpty(criteria.get("DATE_FROM").toString()) ){
			criterion.add(Restrictions.gt("order.orderDate", criteria.get("DATE_FROM")));
		}
		if(criteria.get("DATE_TO") != null && !StringUtils.isEmpty(criteria.get("DATE_TO").toString()) ){
			criterion.add(Restrictions.lt("order.orderDate", criteria.get("DATE_TO")));
		}	
		criterion.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Order>) super.findAll(criterion);
	}
}
