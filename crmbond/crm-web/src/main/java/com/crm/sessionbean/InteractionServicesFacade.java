/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.sessionbean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crm.entities.InteractionServices;

/**
 *
 * @author abuzo
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class InteractionServicesFacade extends AbstractFacade<InteractionServices> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}
	
	public InteractionServicesFacade() {
	
		super(InteractionServices.class);
	}
}
