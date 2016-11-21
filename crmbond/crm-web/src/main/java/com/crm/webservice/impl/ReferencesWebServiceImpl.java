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

import com.crm.entities.References;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.ReferencesWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "ReferencesWebService",
serviceName = "ReferencesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.ReferencesWebService")
public class ReferencesWebServiceImpl extends AbstractFacade<References> implements ReferencesWebService<References>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public ReferencesWebServiceImpl() {
		
		super(References.class);
	}
	@WebMethod
	@Override
	public void create(References entity) {
		
		super.create(entity);
	}
	@WebMethod
	public void edit(Integer id, References entity) {
		
		super.edit(entity);
	}
	@WebMethod
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	@WebMethod
	public References find(Integer id) {
		
		return super.find(id);
	}
	@WebMethod
	@Override
	public List<References> findAll() {
		
		return super.findAll();
	}
	@WebMethod
	public List<References> findRange(Integer from, Integer to) {
		
		return super.findRange(new int[] {from, to});
	}
	
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
}
