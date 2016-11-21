package com.crm.presentation.user;

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

import com.crm.entities.UserEntityPermission;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.UserEntityPermissionFacade;

@Named("userEntityPermissionController")
@ViewScoped
public class UserEntityPermissionController implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(UserEntityPermissionController.class);

	@EJB
	private com.crm.sessionbean.UserEntityPermissionFacade ejbFacade;
	private List<UserEntityPermission> items = null;
	private UserEntityPermission selected;
	
	public UserEntityPermissionController() {
	}
	
	public UserEntityPermission getSelected() {
		return selected;
	}
	
	public void setSelected(UserEntityPermission selected) {
		this.selected = selected;
	}
	
	
	private UserEntityPermissionFacade getFacade() {
		return ejbFacade;
	}
	
	public UserEntityPermission prepareCreate() {
		selected = new UserEntityPermission();
		return selected;
	}
	
	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UserEntityPermissionCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UserEntityPermissionUpdated"));
	}
	
	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UserEntityPermissionDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public List<UserEntityPermission> getItems() {
		if (items == null) {
			items = getFacade().findAll();
		}
		return items;
	}
	
	private void persist(PersistAction persistAction, String successMessage) {
		if (selected != null) {
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
	
	public UserEntityPermission getUserEntityPermission(java.lang.Integer id) {
		return getFacade().find(id);
	}
	
	public List<UserEntityPermission> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}
	
	public List<UserEntityPermission> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	
	/**
	 * @return the ejbFacade
	 */
	public com.crm.sessionbean.UserEntityPermissionFacade getEjbFacade() {
		
		return ejbFacade;
	}

	
	/**
	 * @param ejbFacade the ejbFacade to set
	 */
	public void setEjbFacade(com.crm.sessionbean.UserEntityPermissionFacade ejbFacade) {
		
		this.ejbFacade = ejbFacade;
	}

	
	/**
	 * @param items the items to set
	 */
	public void setItems(List<UserEntityPermission> items) {
		
		this.items = items;
	}

	@FacesConverter(forClass = UserEntityPermission.class)
	public static class UserEntityPermissionControllerConverter implements Converter {
		
		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			UserEntityPermissionController controller = (UserEntityPermissionController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "userEntityPermissionController");
			return controller.getUserEntityPermission(getKey(value));
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
			if (object instanceof UserEntityPermission) {
				UserEntityPermission o = (UserEntityPermission) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), UserEntityPermission.class.getName()});
				return null;
			}
		}
		
	}
	
}
