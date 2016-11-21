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

import com.crm.entities.States;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.StatesWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "States",
serviceName = "StatesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.StatesWebService")
public class StatesWebServiceImpl extends AbstractFacade<States> implements StatesWebService<States>{

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public StatesWebServiceImpl() {

		super(States.class);
	}

	@Override
	public void create(States entity) {

		super.create(entity);
	}

	public void edit(Integer id, States entity) {

		super.edit(entity);
	}

	public void remove(Integer id) {

		super.remove(super.find(id));
	}

	public States find(Integer id) {

		return super.find(id);
	}

	@Override
	public List<States> findAll() {

		return super.findAll();
	}

	public List<States> findRange(Integer from, Integer to) {

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
