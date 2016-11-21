/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.webservice.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crm.entities.InteractionServiceTypes;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.InteractionServicesTypesWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "InteractionServicesTypesWebService",
serviceName = "InteractionServicesTypesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.InteractionServicesTypesWebService")
public class InteractionServiceTypesWebServiceImpl extends AbstractFacade<InteractionServiceTypes>
implements InteractionServicesTypesWebService<InteractionServiceTypes>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public InteractionServiceTypesWebServiceImpl() {
		
		super(InteractionServiceTypes.class);
	}
	@WebMethod
	@Override
	public void create(InteractionServiceTypes entity) {
		
		super.create(entity);
	}
	@WebMethod
	public void edit(Integer id, InteractionServiceTypes entity) {
		
		super.edit(entity);
	}
	@WebMethod
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	@WebMethod
	public InteractionServiceTypes find(Integer id) {
		
		return super.find(id);
	}
	@WebMethod
	@Override
	public List<InteractionServiceTypes> findAll() {
		
		return super.findAll();
	}
	@WebMethod
	public List<InteractionServiceTypes> findRange(Integer from, Integer to) {
		
		return super.findRange(new int[] {from, to});
	}

	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
}
