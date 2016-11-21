package com.crm.presentation.marketing;

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

import com.crm.entities.Events;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.EventsFacade;

@Named("eventsController")
@ViewScoped
public class EventsController implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LogManager.getLogger(EventsController.class);

	@EJB
	private com.crm.sessionbean.EventsFacade ejbFacade;
	private List<Events> items = null;
	private Events selected;
	
	public EventsController() {
	}
	
	public Events getSelected() {
		return selected;
	}
	
	public void setSelected(Events selected) {
		this.selected = selected;
	}
	
	protected void setEmbeddableKeys() {
	}
	
	protected void initializeEmbeddableKey() {
	}
	
	private EventsFacade getFacade() {
		return ejbFacade;
	}
	
	public Events prepareCreate() {
		selected = new Events();
		initializeEmbeddableKey();
		return selected;
	}
	
	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EventsCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EventsUpdated"));
	}
	
	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EventsDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public List<Events> getItems() {
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
	
	public Events getEvents(java.lang.Integer id) {
		return getFacade().find(id);
	}
	
	public List<Events> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}
	
	public List<Events> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	@FacesConverter(forClass = Events.class)
	public static class EventsControllerConverter implements Converter {
		
		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			EventsController controller = (EventsController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "eventsController");
			return controller.getEvents(getKey(value));
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
			if (object instanceof Events) {
				Events o = (Events) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Events.class.getName()});
				return null;
			}
		}
		
	}
	
}
