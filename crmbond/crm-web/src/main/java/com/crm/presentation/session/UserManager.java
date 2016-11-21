package com.crm.presentation.session;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.Currency;
import com.crm.entities.Users;
import com.crm.sessionbean.UserFacade;

@Named("userManager")
@javax.enterprise.context.SessionScoped
public class UserManager implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(UserManager.class);

	@Inject
	private com.crm.sessionbean.UserFacade ejbFacade;
	
	@Inject
	private com.crm.sessionbean.CurrencyFacade currencyFacade;
	
	private Users currentUser;
	private Currency userCurrency;
	

	private Locale locale = new Locale("en");

	public UserManager() {

	}

	@PostConstruct
	public void init()
	{
		LOG.log(Level.DEBUG, "Init UserManager"+currentUser);
		if(currentUser == null)
			setCurrentUser(ejbFacade.findByUsername(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName()));
		setUserCurrency(currencyFacade.find(currentUser.getCurrency()));
	}
	

	/**
	 * @return the ejbFacade
	 */
	public com.crm.sessionbean.UserFacade getEjbFacade() {

		return ejbFacade;
	}
	
	
	

	/**
	 * @param ejbFacade the ejbFacade to set
	 */
	public void setEjbFacade(com.crm.sessionbean.UserFacade ejbFacade) {

		this.ejbFacade = ejbFacade;
	}
	
	

	/**
	 * @return the currentUser
	 */
	public Users getCurrentUser() {

		return currentUser;
	}
	
	
	

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(Users currentUser) {

		this.currentUser = currentUser;
	}
	
	
	
	private UserFacade getFacade() {
		return ejbFacade;
	}
	

	


	
	public Locale getLocale() {

		return new Locale(currentUser.getLanguage());
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		
		this.locale = locale;
	}
	
	/**
	 * @return the userCurrency
	 */
	public Currency getUserCurrency() {

		return userCurrency;
	}
	
	/**
	 * @param userCurrency the userCurrency to set
	 */
	public void setUserCurrency(Currency userCurrency) {

		this.userCurrency = userCurrency;
	}

	/**
	 * @return the currencyFacade
	 */
	public com.crm.sessionbean.CurrencyFacade getCurrencyFacade() {
		
		return currencyFacade;
	}

	/**
	 * @param currencyFacade the currencyFacade to set
	 */
	public void setCurrencyFacade(com.crm.sessionbean.CurrencyFacade currencyFacade) {
		
		this.currencyFacade = currencyFacade;
	}


	
	
}
