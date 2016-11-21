package com.crm.sessionbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crm.entities.UserPermission;

/**
 *
 * @author abuzo
 */
@Stateless
public class UserPermissionFacade extends AbstractFacade<UserPermission> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}
	
	public UserPermissionFacade() {
	
		super(UserPermission.class);
	}
}
