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

import com.crm.entities.ContractTypes;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.ContractTypesWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "ContractTypesWebService", serviceName = "ContractTypesWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.ContractTypesWebService")
public class ContractTypesWebServiceImpl extends AbstractFacade<ContractTypes> implements  ContractTypesWebService<ContractTypes>{

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public ContractTypesWebServiceImpl() {

		super(ContractTypes.class);
	}
	@WebMethod
	@Override
	public void create(ContractTypes entity) {

		super.create(entity);
	}
	@WebMethod
	public void edit(Integer id, ContractTypes entity) {

		super.edit(entity);
	}
	@WebMethod
	public void remove(Integer id) {

		super.remove(super.find(id));
	}
	@WebMethod
	public ContractTypes find(Integer id) {

		return super.find(id);
	}
	@WebMethod
	@Override
	public List<ContractTypes> findAll() {

		return super.findAll();
	}
	@WebMethod
	public List<ContractTypes> findRange(Integer from, Integer to) {

		return super.findRange(new int[] {from, to});
	}

	
	@Override
	protected EntityManager getEntityManager() {

		return em;
	}
}
