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

import com.crm.entities.PotentialClients;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.PotentialClientsWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "PotentialClients", serviceName = "PotentialClientsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.PotentialClientsWebService")
public class PotentialClientsWebServiceImpl extends AbstractFacade<PotentialClients> implements PotentialClientsWebService<PotentialClients>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	public PotentialClientsWebServiceImpl() {
		
		super(PotentialClients.class);
	}
	
	@Override
	public void create(PotentialClients entity) {
		
		super.create(entity);
	}
	@WebMethod
	public void edit(Integer id, PotentialClients entity) {
		
		super.edit(entity);
	}
	@WebMethod
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	@WebMethod
	public PotentialClients find(Integer id) {
		
		return super.find(id);
	}
	@WebMethod
	@Override
	public List<PotentialClients> findAll() {
		
		return super.findAll();
	}
	@WebMethod
	public List<PotentialClients> findRange(Integer from, Integer to) {
		
		return super.findRange(new int[] {from, to});
	}
	@WebMethod
	public String countREST() {
		
		return String.valueOf(super.count());
	}
	@WebMethod
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
}
