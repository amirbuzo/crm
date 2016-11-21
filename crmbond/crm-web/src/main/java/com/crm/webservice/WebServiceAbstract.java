package com.crm.webservice;

import java.util.List;

public interface WebServiceAbstract<T> {
	public void create(T entity);

	public void edit(T entity);

	public void remove(T entity);

	public T find(Object id);

	public List<T> findAll();

	public List<T> findRange(int[] range);

	public int count();
	
}
