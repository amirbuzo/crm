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

import com.crm.entities.Claims;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.ClaimsWebService;

/**
 *
 * @author abuzo
 */
@WebService(portName = "ClaimsPort",
serviceName = "ClaimsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.ClaimsWebService")
@Stateless
public class ClaimsWebServiceImpl extends AbstractFacade<Claims> implements ClaimsWebService<Claims>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public ClaimsWebServiceImpl() {
		
		super(Claims.class);
	}
	
	@Override
	@WebMethod
	public void create(Claims entity) {
		
		super.create(entity);
	}
	
	@WebMethod
	public void edit(Integer id, Claims entity) {
		
		super.edit(entity);
	}
	
	@WebMethod
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	@WebMethod
	public Claims find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	@WebMethod
	public List<Claims> findAll() {
		
		return super.findAll();
	}
	
	@WebMethod
	public List<Claims> findRange(Integer from, Integer to) {
		
		return super.findRange(new int[] {from, to});
	}
	
	@WebMethod
	public String countREST() {
		
		return String.valueOf(super.count());
	}
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
}
