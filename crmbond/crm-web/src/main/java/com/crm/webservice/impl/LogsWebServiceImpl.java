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

import com.crm.entities.InteractionLogs;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.LogsWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "Logs", serviceName = "LogsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.LogsWebService")
public class LogsWebServiceImpl extends AbstractFacade<InteractionLogs> implements LogsWebService<InteractionLogs> {

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public LogsWebServiceImpl() {

		super(InteractionLogs.class);
	}

	@Override
	public void create(InteractionLogs entity) {

		super.create(entity);
	}

	public void edit(Integer id, InteractionLogs entity) {

		super.edit(entity);
	}

	public void remove(Integer id) {

		super.remove(super.find(id));
	}

	public InteractionLogs find(Integer id) {

		return super.find(id);
	}

	@Override
	public List<InteractionLogs> findAll() {

		return super.findAll();
	}

	public List<InteractionLogs> findRange(Integer from, Integer to) {

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
