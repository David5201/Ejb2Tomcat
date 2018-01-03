package com.caida.platform.db.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	
	T get(Class<T> entityClazz , Serializable id);
	
	Serializable save(T entity);
	
	int update(T entity);
	
	int delete(T entity);
	
	int delete(Class<T> entityClazz , Serializable id);
	
	List<T> findAll(Class<T> entityClazz);
	
	int findCount(Class<T> entityClazz);

}
