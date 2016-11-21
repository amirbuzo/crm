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

import com.crm.entities.Requests;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.RequestsWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "Requests",
serviceName = "RequestsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.RequestsWebService")
public class RequestsWebServiceImpl extends AbstractFacade<Requests> implements RequestsWebService<Requests> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public RequestsWebServiceImpl() {
		
		super(Requests.class);
	}
	
	@Override
	public void create(Requests entity) {
		
		super.create(entity);
	}
	
	public void edit(Integer id, Requests entity) {
		
		super.edit(entity);
	}
	
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	public Requests find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	public List<Requests> findAll() {
		
		return super.findAll();
	}
	
	public List<Requests> findRange(Integer from, Integer to) {
		
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
