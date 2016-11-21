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

import com.crm.entities.Contracts;

/**
 *
 * @author abuzo
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ContractsFacade extends AbstractFacade<Contracts> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}
	
	public ContractsFacade() {
	
		super(Contracts.class);
	}
}
