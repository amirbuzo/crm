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

import com.crm.entities.Company;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.CompanyWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "Company", serviceName = "CompanyWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.CompanyWebService")
public class CompanyWebServiceImpl extends AbstractFacade<Company> implements CompanyWebService<Company>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public CompanyWebServiceImpl() {
		
		super(Company.class);
	}
	
	@Override
	public void create(Company entity) {
		
		super.create(entity);
	}
	
	public void edit(Integer id, Company entity) {
		
		super.edit(entity);
	}
	
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	public Company find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	public List<Company> findAll() {
		
		return super.findAll();
	}
	
	public List<Company> findRange(Integer from, Integer to) {
		
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
