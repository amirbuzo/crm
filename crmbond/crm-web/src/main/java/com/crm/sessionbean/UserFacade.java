/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.sessionbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.crm.entities.Users;

/**
 *
 * @author abuzo
 */
@Stateless
public class UserFacade extends AbstractFacade<Users>  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return em;
	}

	public UserFacade() {

		super(Users.class);
	}

	public Users findByUsername(String username) {

		Query query = getEntityManager().createNamedQuery("Users.findByUserName", Users.class);
		query.setParameter("userName", username);
		Users users = (Users) query.getSingleResult();
		return users;
	}

	public Users find(Integer id) {

		return getEntityManager().find(Users.class, id);
	}
}
