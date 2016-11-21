/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.webservice.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crm.entities.EventCategories;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.EventCategoriesWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "EventCategories", serviceName = "EventCategoriesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.EventCategoriesWebService")
public class EventCategoriesWebServiceImpl extends AbstractFacade<EventCategories> implements EventCategoriesWebService<EventCategories>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public EventCategoriesWebServiceImpl() {
		
		super(EventCategories.class);
	}
	
	@Override
	public void create(EventCategories entity) {
		
		super.create(entity);
	}
	
	public void edit(Integer id, EventCategories entity) {
		
		super.edit(entity);
	}
	
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	public EventCategories find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	public List<EventCategories> findAll() {
		
		return super.findAll();
	}
	
	public List<EventCategories> findRange(Integer from, Integer to) {
		
		return super.findRange(new int[] {from, to});
	}
	
	public String countREST() {
		
		return String.valueOf(super.count());
	}
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
}
