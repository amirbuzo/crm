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

import com.crm.entities.Users;
import com.crm.webservice.AbstractFacade;

/**
 *
 * @author abuzo
 */
@Stateless
@WebService(portName = "Users",
serviceName = "UserWebService",
targetNamespace = "http://crm.com/wsdl",
endpointInterface = "com.crm.webservice.UserWebService")
public class UserWebServiceImpl extends AbstractFacade<Users> implements com.crm.webservice.UserWebService<Users>{
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public UserWebServiceImpl() {
		
		super(Users.class);
	}
	
	@Override
	public void create(Users entity) {
		
		super.create(entity);
	}
	
	public void edit(Integer id, Users entity) {
		
		super.edit(entity);
	}
	
	public void remove(Integer id) {
		
		super.remove(super.find(id));
	}
	
	public Users find(Integer id) {
		
		return super.find(id);
	}
	
	@Override
	public List<Users> findAll() {
		
		return super.findAll();
	}
	
	public List<Users> findRange(Integer from, Integer to) {
		
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
