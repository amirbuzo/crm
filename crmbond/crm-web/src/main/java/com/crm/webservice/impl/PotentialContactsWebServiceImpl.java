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

import com.crm.entities.PotentialContacts;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.PotentialContactsWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "PotentialContactsWebService",
serviceName = "PotentialContactsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.PotentialContactsWebService")
public class PotentialContactsWebServiceImpl extends AbstractFacade<PotentialContacts> implements PotentialContactsWebService<PotentialContacts>{

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public PotentialContactsWebServiceImpl() {

		super(PotentialContacts.class);
	}
	@WebMethod
	@Override
	public void create(PotentialContacts entity) {
		
		super.create(entity);
	}
	@WebMethod
	public void edit(Integer id, PotentialContacts entity) {
		
		super.edit(entity);
	}
	@WebMethod
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	@WebMethod
	public PotentialContacts find(Integer id) {
		
		return super.find(id);
	}
	@WebMethod
	@Override
	public List<PotentialContacts> findAll() {
		
		return super.findAll();
	}
	@WebMethod
	public List<PotentialContacts> findRange(Integer from, Integer to) {
		
		return super.findRange(new int[] {from, to});
	}

	@Override
	protected EntityManager getEntityManager() {

		return em;
	}
}
