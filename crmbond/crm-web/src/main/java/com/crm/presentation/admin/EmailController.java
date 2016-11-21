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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.Email;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.EmailFacade;

@Named("emailController")
@Singleton
@Startup
@ConcurrencyManagement(BEAN)
public class EmailController implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(EmailController.class);
	
	@EJB
	private com.crm.sessionbean.EmailFacade ejbFacade;
	private List<Email> items = null;
	private Email selected;

	public EmailController() {
	}

	public Email getSelected() {
		return selected;
	}

	public void setSelected(Email selected) {
		this.selected = selected;
	}

	protected void setEmbeddableKeys() {
	}

	protected void initializeEmbeddableKey() {
	}

	private EmailFacade getFacade() {
		return ejbFacade;
	}

	public Email prepareCreate() {
		selected = new Email();
		initializeEmbeddableKey();
		return selected;
	}

	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EmailCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}

	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmailUpdated"));
		items = null;    // Invalidate list of items to trigger re-query.
		
	}

	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EmailDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}

	public List<Email> getItems() {
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
				LOG.error( ex.getMessage(), ex);
				JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
			}
		}
	}

	public Email getEmail(java.lang.Integer id) {
		return getFacade().find(id);
	}

	public List<Email> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}

	public List<Email> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}

	@FacesConverter(forClass = Email.class)
	public static class EmailControllerConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			EmailController controller = (EmailController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "emailController");
			return controller.getEmail(getKey(value));
		}

		java.lang.Integer getKey(String value) {
			java.lang.Integer key;
			key = Integer.valueOf(value);
			return key;
		}

		String getStringKey(java.lang.Integer value) {
			StringBuilder sb = new StringBuilder();
			sb.append(value);
			return sb.toString();
		}

		@Override
		public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
			if (object == null) {
				return null;
			}
			if (object instanceof Email) {
				Email o = (Email) object;
				return getStringKey(o.getId());
			} else {
				LOG.error("object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Email.class.getName()});
				return null;
			}
		}

	}

}
