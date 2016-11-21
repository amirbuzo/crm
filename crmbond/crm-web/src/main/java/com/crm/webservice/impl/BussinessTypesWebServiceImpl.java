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

import com.crm.entities.BussinessTypes;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.BussinessTypeWebService;

/**
 *
 * @author abuzo
 */
@WebService(portName = "BussinessType",
serviceName = "BussinessTypeWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.BussinessTypeWebService")
@Stateless
public class BussinessTypesWebServiceImpl extends AbstractFacade<BussinessTypes> implements BussinessTypeWebService<BussinessTypes>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public BussinessTypesWebServiceImpl() {
		
		super(BussinessTypes.class);
	}
	
	@WebMethod
	@Override
	public void create(BussinessTypes entity) {
		
		super.create(entity);
	}
	
	@WebMethod
	public void edit(Integer id, BussinessTypes entity) {
		
		super.edit(entity);
	}
	
	@WebMethod
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	@WebMethod
	public BussinessTypes find(Integer id) {
		
		return super.find(id);
	}
	
	@WebMethod
	@Override
	public List<BussinessTypes> findAll() {
		
		return super.findAll();
	}
	
	@WebMethod
	public List<BussinessTypes> findRange(Integer from, Integer to) {
		
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
