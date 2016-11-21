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

import com.crm.entities.InteractionServices;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.InteractionServicesWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "InteractionServices", serviceName = "InteractionServicesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.InteractionServicesWebService")
public class InteractionServicesWebServiceImpl extends AbstractFacade<InteractionServices> implements InteractionServicesWebService<InteractionServices> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public InteractionServicesWebServiceImpl() {
		
		super(InteractionServices.class);
	}
	
	@Override
	public void create(InteractionServices entity) {
		
		super.create(entity);
	}
	
	public void edit(Integer id, InteractionServices entity) {
		
		super.edit(entity);
	}
	
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	public InteractionServices find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	public List<InteractionServices> findAll() {
		
		return super.findAll();
	}
	
	public List<InteractionServices> findRange(Integer from, Integer to) {
		
		return super.findRange(new int[] {from, to});
	}
	
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
}
