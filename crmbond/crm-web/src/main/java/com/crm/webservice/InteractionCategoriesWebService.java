package com.crm.webservice;

import java.util.List;

import javax.jws.WebService;

@WebService(targetNamespace = "http://com.crm/wsdl")
public interface InteractionCategoriesWebService<T> extends WebServiceAbstract<T>{
	
	@Override
	public void create(T entity);
	@Override
	public void edit(T entity);

	@Override
	public void remove(T entity);

	@Override
	public T find(Object id);

	@Override
	public List<T> findAll();

	@Override
	public List<T> findRange(int[] range);

	@Override
	public int count();
	
}
