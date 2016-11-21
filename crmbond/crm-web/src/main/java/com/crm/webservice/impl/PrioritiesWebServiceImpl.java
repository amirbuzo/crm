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

import com.crm.entities.Priorities;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.PrioritiesWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "PrioritiesWebService", serviceName = "PrioritiesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.PrioritiesWebService")
public class PrioritiesWebServiceImpl extends AbstractFacade<Priorities> implements PrioritiesWebService<Priorities>{

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public PrioritiesWebServiceImpl() {

		super(Priorities.class);
	}
	@WebMethod
	@Override
	public void create(Priorities entity) {

		super.create(entity);
	}
	@WebMethod
	public void edit(Integer id, Priorities entity) {

		super.edit(entity);
	}
	@WebMethod
	public void remove(Integer id) {

		super.remove(super.find(id));
	}
	@WebMethod
	public Priorities find(Integer id) {

		return super.find(id);
	}
	@WebMethod
	@Override
	public List<Priorities> findAll() {

		return super.findAll();
	}
	@WebMethod
	public List<Priorities> findRange(Integer from, Integer to) {

		return super.findRange(new int[] {from, to});
	}
	

	@Override
	protected EntityManager getEntityManager() {

		return em;
	}
}
