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

import com.crm.entities.Cities;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.CitiesWebService;

/**
 *
 * @author abuzo
 */
@WebService(portName = "Cities",
serviceName = "CitiesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.CitiesWebService")
@Stateless
public class CitiesWebServiceImpl extends AbstractFacade<Cities> implements CitiesWebService<Cities>{

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public CitiesWebServiceImpl() {

		super(Cities.class);
	}

	@Override
	@WebMethod
	public void create(Cities entity) {

		super.create(entity);
	}

	@WebMethod
	public void edit(Integer id, Cities entity) {

		super.edit(entity);
	}

	@WebMethod
	public void remove(Integer id) {

		super.remove(super.find(id));
	}

	@WebMethod
	public Cities find(Integer id) {

		return super.find(id);
	}

	@Override
	@WebMethod
	public List<Cities> findAll() {

		return super.findAll();
	}

	@WebMethod
	public List<Cities> findRange(Integer from, Integer to) {

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
