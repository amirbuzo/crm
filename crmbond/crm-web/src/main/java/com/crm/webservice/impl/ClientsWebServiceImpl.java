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

import com.crm.entities.Clients;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.ClientsWebService;

/**
 *
 * @author abuzo
 */
@WebService(portName = "Clients",
serviceName = "ClientsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.ClientsWebService")
@Stateless
public class ClientsWebServiceImpl extends AbstractFacade<Clients> implements ClientsWebService<Clients>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public ClientsWebServiceImpl() {
		
		super(Clients.class);
	}
	
	// spunon
	@Override
	public void create(Clients entity) {
		
		super.create(entity);
	}
	
	public void edit(Integer id, Clients entity) {
		
		super.edit(entity);
	}
	
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	public Clients find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	public List<Clients> findAll() {
		
		return super.findAll();
	}
	
	public List<Clients> findRange(Integer from, Integer to) {
		
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
