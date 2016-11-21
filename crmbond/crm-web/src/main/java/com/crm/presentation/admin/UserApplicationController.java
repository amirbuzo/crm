package com.crm.presentation.admin;

import static javax.ejb.ConcurrencyManagementType.BEAN;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.Users;
import com.crm.sessionbean.UserFacade;

@Named("userApplicationController")
@Singleton
@Startup
@ConcurrencyManagement(BEAN)
public class UserApplicationController implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(UserApplicationController.class);

	@Inject
	private com.crm.sessionbean.UserFacade ejbFacade;


	
	
	
	private List<Users> items = null;
	private Map<String, String> users = new HashMap<String, String>();
	
	public UserApplicationController() {
	}
	
	

	protected void initializeEmbeddableKey() {
	}

	private UserFacade getFacade() {
		return ejbFacade;
	}



	public List<Users> getItems() {
		if (items == null) {
			items = getFacade().findAll();
			for (Users users : items) {
				this.users.put(users.getId()+"", users.getUserName());
			}
		}

		return items;
	}


	public String getUser(String id) {
		
		if( users.get(id) == null);
		getItems();
		return users.get(id) ;
	}

	public List<Users> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}

	public List<Users> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	
	
	
	/**
	 * @return the users
	 */
	public Map<String, String> getUsers() {

		return users;
	}
	
	
	
	
	/**
	 * @param users the users to set
	 */
	public void setUsers(Map<String, String> users) {

		this.users = users;
	}

	
	
}
