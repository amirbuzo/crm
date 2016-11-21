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

import com.crm.entities.UserRights;
import com.crm.webservice.AbstractFacade;
import com.crm.webservice.UserRightsWebService;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "UserRights",
serviceName = "UserRightsWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.UserRightsWebService")
public class UserRightsWebServiceImpl extends AbstractFacade<UserRights> implements UserRightsWebService<UserRights> {

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	public UserRightsWebServiceImpl() {

		super(UserRights.class);
	}

	@Override
	public void create(UserRights entity) {

		super.create(entity);
	}

	public void edit(Integer id, UserRights entity) {

		super.edit(entity);
	}

	public void remove(Integer id) {

		super.remove(super.find(id));
	}

	public UserRights find(Integer id) {

		return super.find(id);
	}

	@Override
	public List<UserRights> findAll() {

		return super.findAll();
	}

	public List<UserRights> findRange(Integer from, Integer to) {

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
