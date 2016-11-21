package com.crm.presentation.service;

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

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.InteractionServiceTypes;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.InteractionServiceTypesFacade;

@Named("interactionServiceTypesController")
@Singleton
@Startup
@ConcurrencyManagement(BEAN)
public class InteractionServiceTypesController implements Serializable {
	private static final Logger LOG = LogManager.getLogger(InteractionServiceTypesController.class);
	
	@EJB
	private com.crm.sessionbean.InteractionServiceTypesFacade ejbFacade;
	private List<InteractionServiceTypes> items = null;
	private InteractionServiceTypes selected;

	public InteractionServiceTypesController() {
	}

	public InteractionServiceTypes getSelected() {
		return selected;
	}

	public void setSelected(InteractionServiceTypes selected) {
		this.selected = selected;
	}

	protected void setEmbeddableKeys() {
	}

	protected void initializeEmbeddableKey() {
	}

	private InteractionServiceTypesFacade getFacade() {
		return ejbFacade;
	}

	public InteractionServiceTypes prepareCreate() {
		selected = new InteractionServiceTypes();
		initializeEmbeddableKey();
		return selected;
	}

	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InteractionServiceTypesCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}

	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InteractionServiceTypesUpdated"));
	}

	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InteractionServiceTypesDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}

	public List<InteractionServiceTypes> getItems() {
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

	public InteractionServiceTypes getInteractionServiceTypes(java.lang.Integer id) {
		return getFacade().find(id);
	}

	public List<InteractionServiceTypes> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}

	public List<InteractionServiceTypes> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}

	@FacesConverter(forClass = InteractionServiceTypes.class)
	public static class InteractionServiceTypesControllerConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			InteractionServiceTypesController controller = (InteractionServiceTypesController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "interactionServiceTypesController");
			return controller.getInteractionServiceTypes(getKey(value));
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
			if (object instanceof InteractionServiceTypes) {
				InteractionServiceTypes o = (InteractionServiceTypes) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InteractionServiceTypes.class.getName()});
				return null;
			}
		}

	}

}
