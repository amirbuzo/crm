package com.crm.sessionbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crm.entities.Roles;

/**
 *
 * @author abuzo
 */
@Stateless
public class RolesFacade extends AbstractFacade<Roles> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}
	
	public RolesFacade() {
	
		super(Roles.class);
	}
}
