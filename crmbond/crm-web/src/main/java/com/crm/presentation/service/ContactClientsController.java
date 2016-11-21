package com.crm.presentation.service;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import com.crm.entities.ContactClients;
import com.crm.presentation.util.AbstractManageBean;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.ContactClientsFacade;

@Named("contactClientsController")
@ViewScoped
public class ContactClientsController extends AbstractManageBean<ContactClients> implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(ContactClientsController.class);
	
	@EJB
	private com.crm.sessionbean.ContactClientsFacade ejbFacade;
	private LazyDataModel<ContactClients> items = null;
	private ContactClients selected;


	@PostConstruct
	public void init()
	{
		if(items == null)
			items=getItems();

	}

	public ContactClientsController() {
	}

	public ContactClients getSelected() {
		return selected;
	}

	public void setSelected(ContactClients selected) {
		this.selected = selected;
	}

	protected void setEmbeddableKeys() {
	}

	protected void initializeEmbeddableKey() {
	}

	@Override
	public ContactClientsFacade getFacade() {
		return ejbFacade;
	}

	public ContactClients prepareCreate() {
		selected = new ContactClients();
		selected.setUserModified(getUserId());
		initializeEmbeddableKey();
		return selected;
	}
	public String addNewField(String fieldName)
	{
		selected.getAttributes().put(fieldName, "");
		setNewfieldname(null);
		return "";
	}
	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ContactClientsCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}

	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ContactClientsUpdated"));
	}

	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ContactClientsDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
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

	public ContactClients getContactClients(java.lang.Integer id) {
		return getFacade().find(id);
	}

	public List<ContactClients> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}

	public List<ContactClients> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}


}
