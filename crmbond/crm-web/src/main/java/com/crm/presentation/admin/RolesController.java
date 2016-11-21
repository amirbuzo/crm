package com.crm.presentation.admin;
import static javax.ejb.ConcurrencyManagementType.BEAN;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.Roles;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.RolesFacade;

@Named("rolesController")
@Singleton
@Startup
@ConcurrencyManagement(BEAN)
public class RolesController implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LogManager.getLogger(RolesController.class);

	@EJB
	private com.crm.sessionbean.RolesFacade ejbFacade;
	private List<Roles> items = null;
	private Roles selected;

	public RolesController() {
	}

	public Roles getSelected() {
		return selected;
	}

	public void setSelected(Roles selected) {
		this.selected = selected;
	}

	protected void setEmbeddableKeys() {
	}

	protected void initializeEmbeddableKey() {
	}

	private RolesFacade getFacade() {
		return ejbFacade;
	}

	public Roles prepareCreate() {
		selected = new Roles();
		initializeEmbeddableKey();
		return selected;
	}

	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RolesCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}

	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RolesUpdated"));
		items = null;    // Invalidate list of items to trigger re-query.
		
	}

	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RolesDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}

	public List<Roles> getItems() {
		if (items == null) {
			items = getFacade().findAll();
		}
		return items;
	}

	private void persist(PersistAction persistAction, String successMessage) {
		if (selected != null) {
			setEmbeddableKeys();
			try {
				if (persistAction != PersistAction.DELETE) {
					getFacade().edit(selected);
				} else {
					getFacade().inactivate(selected);
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
				LOG.log(Level.ERROR, ex.getMessage(), ex);
				JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
			}
		}
	}

	public Roles getRoles(java.lang.Integer id) {
		return getFacade().find(id);
	}

	public List<Roles> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}

	public List<Roles> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}



}
