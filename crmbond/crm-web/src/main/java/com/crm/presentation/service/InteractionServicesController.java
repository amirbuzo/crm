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
import org.primefaces.model.LazyDataModel;

import com.crm.entities.InteractionServices;
import com.crm.presentation.util.AbstractManageBean;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.InteractionServicesFacade;

@Named("interactionServicesController")
@ViewScoped
public class InteractionServicesController extends AbstractManageBean<InteractionServices> implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(InteractionServicesController.class);

	@EJB
	private com.crm.sessionbean.InteractionServicesFacade ejbFacade;
	private LazyDataModel<InteractionServices> items = null;
	private InteractionServices selected;
	
	
	
	public InteractionServicesController() {
	}
	
	public InteractionServices getSelected() {
		return selected;
	}
	public String addNewField(String fieldName)
	{
		selected.getAttributes().put(fieldName, "");
		setNewfieldname(null);
		return "";
	}
	public void setSelected(InteractionServices selected) {
		this.selected = selected;
	}
	
	protected void setEmbeddableKeys() {
	}
	
	protected void initializeEmbeddableKey() {
	}
	
	@Override
	public InteractionServicesFacade getFacade() {
		return ejbFacade;
	}
	
	public InteractionServices prepareCreate() {
		selected = new InteractionServices();
		selected.setDateStarted(getNowDate());
		selected.setDateFinished(getNowDate());
		initializeEmbeddableKey();
		return selected;
	}
	
	public void create() {
		
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InteractionServicesCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InteractionServicesUpdated"));
		
	}
	
	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InteractionServicesDeleted"));
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
					selected.setUserModified(getCurrentUser().getId());
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
	
	public InteractionServices getInteractionServices(java.lang.Integer id) {
		return getFacade().find(id);
	}
	
	public List<InteractionServices> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}
	public String updatePeriod()
	{
		double diff=(this.selected.getDateFinished().getTime()-this.selected.getDateStarted().getTime())/(double)(60*60 * 1000);
		
		this.selected.setPeriod(diff);
		return null;

	}
	public List<InteractionServices> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	@FacesConverter(forClass = InteractionServices.class)
	public static class InteractionServicesControllerConverter implements Converter {
		
		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			InteractionServicesController controller = (InteractionServicesController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "interactionServicesController");
			return controller.getInteractionServices(getKey(value));
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
			if (object instanceof InteractionServices) {
				InteractionServices o = (InteractionServices) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InteractionServices.class.getName()});
				return null;
			}
		}
		
	}
	
}
