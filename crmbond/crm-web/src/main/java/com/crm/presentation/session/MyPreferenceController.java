package com.crm.presentation.session;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.Users;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.UserFacade;
import com.crm.util.Utility;

@Named("myPreferenceController")
@SessionScoped
public class MyPreferenceController implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LogManager.getLogger(MyPreferenceController.class);

	@EJB
	private com.crm.sessionbean.UserFacade ejbFacade;
	
	@Resource
	private SessionContext sessionContext;
	
	private Users currentUser;
	

	private String newPassword;

	private Locale locale = new Locale("en");

	public MyPreferenceController() {

	}

	@PostConstruct
	public void init()
	{

		if(currentUser == null)
			currentUser=ejbFacade.findByUsername(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
		LOG.log(Level.ALL, "Init Preference ALL");
		LOG.log(Level.DEBUG, "Init Preference dEBUG");
		LOG.log(Level.ERROR, "Init Preference error");
		LOG.log(Level.FATAL, "Init Preference FATAL");
		LOG.log(Level.INFO, "Init Preference INFO");
		LOG.log(Level.OFF, "Init Preference OFF");
		LOG.log(Level.TRACE, "Init Preference TRACE");
		LOG.log(Level.WARN, "Init Preference WARN");
	}
	
	public void updateUser()
	{

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
	 * @return the sessionContext
	 */
	public SessionContext getSessionContext() {

		return sessionContext;
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

		return currentUser;
	}
	
	
	

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(Users currentUser) {

		this.currentUser = currentUser;
	}
	
	
	
	protected void setEmbeddableKeys() {
	}
	
	protected void initializeEmbeddableKey() {
	}
	
	private UserFacade getFacade() {
		return ejbFacade;
	}
	
	public String changePassword()
	{
		
		
		currentUser.setUserPass(Utility.getHashedPassword(newPassword));

		persist(PersistAction.UPDATE, "Password Changed!");
		
		return "";
	}
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UserUpdated"));
		currentUser=getFacade().find(currentUser.getId());
	}
	
	
	private void persist(PersistAction persistAction, String successMessage) {
		if (currentUser != null) {
			setEmbeddableKeys();
			try {
				if (persistAction != PersistAction.DELETE) {
					getFacade().edit(currentUser);
				} else {
					getFacade().inactivate(currentUser);
				}
				JsfUtil.addSuccessMessage(successMessage);
			} catch (EJBException ex) {
				String msg = "";
				Throwable cause = ex.getCause();
				if (cause != null) {
					msg = cause.getLocalizedMessage();
				}
				if (msg.length() > 0) {
					JsfUtil.addErrorMessage(msg);
				} else {
					JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
				}
			} catch (Exception ex) {
				//LOG.log(Level.ERROR, ex.getMessage(), ex);
				LOG.log(Level.ERROR, "error", ex);

				JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
			}
		}
	}
	

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {

		return newPassword;
	}
	

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {

		this.newPassword = newPassword;
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

	
	
}
