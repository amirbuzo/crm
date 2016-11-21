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

import com.crm.entities.PotentialContactCategories;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.PotentialContactCategoriesWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "PotentialContactCategoriesWebService",
serviceName = "PotentialContactCategoriesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.PotentialContactCategoriesWebService")
public class PotentialContactCategoriesWebServiceImpl extends
AbstractFacade<PotentialContactCategories> implements PotentialContactCategoriesWebService<PotentialContactCategories>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public PotentialContactCategoriesWebServiceImpl() {
		
		super(PotentialContactCategories.class);
	}
	
	@Override
	public void create(PotentialContactCategories entity) {
		
		super.create(entity);
	}
	
	public void edit(Integer id, PotentialContactCategories entity) {
		
		super.edit(entity);
	}
	
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	public PotentialContactCategories find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	public List<PotentialContactCategories> findAll() {
		
		return super.findAll();
	}
	
	public List<PotentialContactCategories> findRange(Integer from, Integer to) {
		
		return super.findRange(new int[] {from, to});
	}
	
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
}
