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

import com.crm.entities.ContactClients;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.ContactClientsWebService;

/**
 *
 * @author abuzo
 */
@Stateless
// spunon
@WebService(portName = "ContactClients", serviceName = "ContactClientsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.ContactClientsWebService")
public class ContactClientsWebServiceImpl extends AbstractFacade<ContactClients> implements ContactClientsWebService<ContactClients> {

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public ContactClientsWebServiceImpl() {

		super(ContactClients.class);
	}

	@WebMethod
	@Override
	public void create(ContactClients entity) {

		super.create(entity);
	}
	@WebMethod
	public void edit(Integer id, ContactClients entity) {

		super.edit(entity);
	}
	@WebMethod
	public void remove(Integer id) {

		super.remove(super.find(id));
	}

	public ContactClients find(Integer id) {

		return super.find(id);
	}
	@WebMethod
	@Override
	public List<ContactClients> findAll() {

		return super.findAll();
	}
	@WebMethod
	public List<ContactClients> findRange(Integer from, Integer to) {

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
