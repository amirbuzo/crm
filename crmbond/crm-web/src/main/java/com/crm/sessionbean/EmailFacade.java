/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.sessionbean;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crm.entities.Email;

/**
 *
 * @author abuzo
 */
@RolesAllowed("ADMIN")
@Stateless
public class EmailFacade extends AbstractFacade<Email> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}
	
	public EmailFacade() {
	
		super(Email.class);
	}
}
