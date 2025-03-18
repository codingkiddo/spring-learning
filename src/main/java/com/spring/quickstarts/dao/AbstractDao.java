package com.spring.quickstarts.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}
	
	public void persist(T entity) {
		this.getSession().save(entity);
	}
	
	protected CriteriaQuery<T> createEntityCriteria(){
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(persistentClass);
		return criteriaQuery;
        
    }

}
