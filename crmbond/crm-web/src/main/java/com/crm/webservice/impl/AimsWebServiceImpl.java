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

import com.crm.entities.Aims;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.AimsWebService;

/**
 *
 * @author abuzo
 */
@WebService(portName = "AimsPort",
serviceName = "AimsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.AimsWebService")
@Stateless
public class AimsWebServiceImpl extends AbstractFacade<Aims> implements AimsWebService<Aims> {

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public AimsWebServiceImpl() {
		super(Aims.class);
	}

	@Override
	@WebMethod
	public void create(Aims entity) {

		super.create(entity);
	}

	@WebMethod
	public void edit(Integer id, Aims entity) {

		super.edit(entity);
	}

	@WebMethod
	public void remove(Integer id) {

		super.remove(super.find(id));
	}

	@WebMethod
	public Aims find(Integer id) {

		return super.find(id);
	}

	@Override
	@WebMethod
	public List<Aims> findAll() {

		return super.findAll();
	}

	@WebMethod
	public List<Aims> findRange(Integer from, Integer to) {

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
