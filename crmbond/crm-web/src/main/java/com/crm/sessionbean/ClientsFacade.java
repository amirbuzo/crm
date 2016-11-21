/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.sessionbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crm.entities.Clients;

/**
 *
 * @author abuzo
 */
@Stateless
public class ClientsFacade extends AbstractFacade<Clients> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}
	
	public ClientsFacade() {
	
		super(Clients.class);
	}
}
