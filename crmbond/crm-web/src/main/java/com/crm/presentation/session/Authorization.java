package com.crm.presentation.session;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Named;

import com.crm.entities.Users;
import com.crm.presentation.util.JsfUtil;
import com.crm.sessionbean.UserFacade;


@Stateless
@Named("authorization")
public class Authorization implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private Users currentUser;

	@Resource
	private SessionContext sessionContext;
	
	@EJB
	private com.crm.sessionbean.UserFacade ejbFacade;
	

	public boolean doSomething() {


		return this.sessionContext.isCallerInRole("ADMIN");
	}

	/**
	 * @return the sessionContext
	 */
	public SessionContext getSessionContext() {
		
		return sessionContext;
	}

	public Principal getPrincipal() {
		
		return sessionContext.getCallerPrincipal();
	}

	
	/**
	 * @param sessionContext the sessionContext to set
	 */
	public void setSessionContext(SessionContext sessionContext) {
		
		this.sessionContext = sessionContext;
	}
	
	

	/**
	 * @return the currentUser
	 */
	public Users getCurrentUser() {

		return ejbFacade.findByUsername(sessionContext.getCallerPrincipal().getName());
	}
	
	

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(Users currentUser) {

		this.currentUser = currentUser;
	}

	public String updatePreferences()
	{
		JsfUtil.addSuccessMessage("user updated");
		
		getFacade().edit(currentUser);
		return "";

	}
	
	private UserFacade getFacade() {
		return ejbFacade;
	}

	
}