package com.cisco.order.dao;

import com.cisco.order.domain.DataAccessException;
import com.cisco.order.domain.IdentifiableEntity;


public interface IdentifiableEntityDao<E extends IdentifiableEntity> {
	public E getById(Long id) throws DataAccessException;

    public void save(E entity) throws DataAccessException;

    public void delete(E entity) throws DataAccessException;
}
