package com.cisco.order.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.cisco.order.domain.DataAccessException;
import com.cisco.order.domain.Entity;
import com.cisco.order.domain.IdentifiableEntity;

public abstract class AbstractHibernateDao<E extends IdentifiableEntity> {
    
	@SuppressWarnings("unchecked")
	private Class<E> classVar = (Class<E>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];;
	
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
          
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }


    protected Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public void save(E entity) throws DataAccessException {
        try {
            Session session = this.getSession();
            try {
                session.beginTransaction();
                try {
                    session.saveOrUpdate(entity);
                    session.getTransaction().commit();
                } catch (RuntimeException e) {
                    session.getTransaction().rollback();
                    throw e;
                }
            } finally {
                session.close();
            }
        } catch (RuntimeException e) {
            throw new DataAccessException("Failed to save: " + entity, e);
        }
    }

    public void delete(E entity) throws DataAccessException {
        try {
            Session session = this.getSession();
            try {
                session.beginTransaction();
                try {
                    session.delete(entity);
                    session.getTransaction().commit();
                } catch (RuntimeException e) {
                    session.getTransaction().rollback();
                    throw e;
                }
            } finally {
                session.close();
            }
        } catch (RuntimeException e) {
            throw new DataAccessException("Failed to delete: " + entity, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    public E delete(Long id) throws DataAccessException {
        try {
            Session session = this.getSession();
            try {
                session.beginTransaction();
                try {
                   
					Object obj = session.get(this.classVar, id);
                    session.delete(obj);
                    session.getTransaction().commit();
                    return (E) obj;
                } catch (RuntimeException e) {
                    session.getTransaction().rollback();
                    throw e;
                }
            } finally {
                session.close();
            }
        } catch (RuntimeException e) {
            throw new DataAccessException("Failed to delete: " , e);
        }
    }
    @SuppressWarnings("unchecked")
	public  E getById(Long id) throws DataAccessException {
        try {
            Session session = this.getSession();
            try {
                session.beginTransaction();
                try {
                    Object result =  session.get(this.classVar, id);
                    session.getTransaction().commit();
                    return (E) result;
                } catch (RuntimeException e) {
                    session.getTransaction().rollback();
                    throw e;
                }
            } finally {
                session.close();
            }
        } catch (RuntimeException e) {
            throw new DataAccessException("Failed to get by id: " + id, e);
        }
    }

    @SuppressWarnings("unchecked")
	protected List<E> findAll(String hqlQuery, Object... params) throws DataAccessException {
        try {
            Session session = this.getSession();
            try {
                session.beginTransaction();
                try {
                    Query query = session.createQuery(hqlQuery);
                    this.initQueryParams(query, params);
                    List<E> result = query.list();
                    session.getTransaction().commit();
                    return result;
                } catch (RuntimeException e) {
                    session.getTransaction().rollback();
                    throw e;
                }
            } finally {
                session.close();
            }
        } catch (RuntimeException e) {
            throw new DataAccessException("Failed to find all using query: " + hqlQuery, e);
        }
    }
    
    protected List<E> findAll(Criteria cr) throws DataAccessException {
        try {
            Session session = this.getSession();
            try {
                session.beginTransaction();
                try {
                    List<E> result = (List<E>) cr.list();
                    session.getTransaction().commit();
                    return result;
                } catch (RuntimeException e) {
                    session.getTransaction().rollback();
                    throw e;
                }
            } finally {
                session.close();
            }
        } catch (RuntimeException e) {
            throw new DataAccessException("Failed to find all using query: ", e);
        }
    }
    
    @SuppressWarnings("unchecked")
	protected E findOne(String hqlQuery, Object... params) throws DataAccessException {
        try {
            Session session = this.getSession();
            try {
                session.beginTransaction();
                try {
                    Query query = session.createQuery(hqlQuery);
                    this.initQueryParams(query, params);
                    Object result = query.uniqueResult();
                    session.getTransaction().commit();
                    return (E) result;
                } catch (RuntimeException e) {
                    session.getTransaction().rollback();
                    throw e;
                }
            } finally {
                session.close();
            }
        } catch (RuntimeException e) {
            throw new DataAccessException("Failed to find one using query: " + hqlQuery, e);
        }
    }
    
    private void initQueryParams(Query query, Object... params) {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
    }
}