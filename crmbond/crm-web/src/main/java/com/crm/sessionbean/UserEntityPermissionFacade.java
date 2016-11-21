/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.sessionbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crm.entities.UserEntityPermission;

/**
 *
 * @author abuzo
 */
@Stateless
public class UserEntityPermissionFacade extends AbstractFacade<UserEntityPermission> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}
	
	public UserEntityPermissionFacade() {
	
		super(UserEntityPermission.class);
	}
}
