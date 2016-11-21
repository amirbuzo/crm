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

import com.crm.entities.Contracts;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.ContractsWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "ContractsWebService",
serviceName = "ContractsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.ContractsWebService")
public class ContractsWebServiceImpl extends AbstractFacade<Contracts> implements ContractsWebService<Contracts> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public ContractsWebServiceImpl() {
		
		super(Contracts.class);
	}
	
	@Override
	public void create(Contracts entity) {
		
		super.create(entity);
	}
	
	public void edit(Integer id, Contracts entity) {
		
		super.edit(entity);
	}
	
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	public Contracts find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	public List<Contracts> findAll() {
		
		return super.findAll();
	}
	
	public List<Contracts> findRange(Integer from, Integer to) {
		
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
