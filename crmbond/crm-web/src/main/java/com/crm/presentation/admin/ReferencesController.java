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

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.References;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.ReferencesFacade;

@Named("referencesController")
@Singleton
@Startup
@ConcurrencyManagement(BEAN)
public class ReferencesController implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LogManager.getLogger(ReferencesController.class);
	
	@EJB
	private com.crm.sessionbean.ReferencesFacade ejbFacade;
	private List<References> items = null;
	private References selected;
	
	public ReferencesController() {
	}
	
	public References getSelected() {
		return selected;
	}
	
	public void setSelected(References selected) {
		this.selected = selected;
	}
	
	protected void setEmbeddableKeys() {
	}
	
	protected void initializeEmbeddableKey() {
	}
	
	private ReferencesFacade getFacade() {
		return ejbFacade;
	}
	
	public References prepareCreate() {
		selected = new References();
		initializeEmbeddableKey();
		return selected;
	}
	
	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ReferencesCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ReferencesUpdated"));
		items = null;    // Invalidate list of items to trigger re-query.
		
	}
	
	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ReferencesDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public List<References> getItems() {
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
	
	public References getReferences(java.lang.Integer id) {
		return getFacade().find(id);
	}
	
	public List<References> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}
	
	public List<References> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	@FacesConverter(forClass = References.class)
	public static class ReferencesControllerConverter implements Converter {
		
		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			ReferencesController controller = (ReferencesController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "referencesController");
			return controller.getReferences(getKey(value));
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
			if (object instanceof References) {
				References o = (References) object;
				return getStringKey(o.getId());
			} else {
				LOG.error("object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), References.class.getName()});
				return null;
			}
		}
		
	}
	
}
