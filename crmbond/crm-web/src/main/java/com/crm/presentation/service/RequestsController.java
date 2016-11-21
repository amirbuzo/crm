package com.crm.presentation.service;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.Requests;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.RequestsFacade;

@Named("requestsController")
@ViewScoped
public class RequestsController implements Serializable {
	private static final Logger LOG = LogManager.getLogger(RequestsController.class);

	@EJB
	private com.crm.sessionbean.RequestsFacade ejbFacade;
	private List<Requests> items = null;
	private Requests selected;
	
	public RequestsController() {
	}
	
	public Requests getSelected() {
		return selected;
	}
	
	public void setSelected(Requests selected) {
		this.selected = selected;
	}
	
	protected void setEmbeddableKeys() {
	}
	
	protected void initializeEmbeddableKey() {
	}
	
	private RequestsFacade getFacade() {
		return ejbFacade;
	}
	
	public Requests prepareCreate() {
		selected = new Requests();
		initializeEmbeddableKey();
		return selected;
	}
	
	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RequestsCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RequestsUpdated"));
	}
	
	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RequestsDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public List<Requests> getItems() {
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
	
	public Requests getRequests(java.lang.Integer id) {
		return getFacade().find(id);
	}
	
	public List<Requests> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}
	
	public List<Requests> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	@FacesConverter(forClass = Requests.class)
	public static class RequestsControllerConverter implements Converter {
		
		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			RequestsController controller = (RequestsController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "requestsController");
			return controller.getRequests(getKey(value));
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
			if (object instanceof Requests) {
				Requests o = (Requests) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Requests.class.getName()});
				return null;
			}
		}
		
	}
	
}
