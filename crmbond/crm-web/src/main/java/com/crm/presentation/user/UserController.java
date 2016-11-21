package com.crm.presentation.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJBException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.UserPermission;
import com.crm.entities.UserRights;
import com.crm.entities.Users;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.UserFacade;
import com.crm.util.Utility;

@Named("userController")
@ViewScoped
public class UserController implements Serializable {
	private static final Logger LOG = LogManager.getLogger(UserController.class);
	
	@Inject
	private com.crm.sessionbean.UserFacade ejbFacade;
	
	@Inject
	private com.crm.sessionbean.UserRightsFacade ejbUserFacade;

	private List<UserPermission> userpermissions = null;

	@Inject
	private com.crm.presentation.session.UserManager userManager;

	private List<Users> items = null;
	private Users selected;
	
	public UserController() {
	}
	
	public Users getSelected() {
		return selected;
	}
	
	public void setSelected(Users selected) {
		this.selected = selected;
	}
	
	protected void setEmbeddableKeys() {
	}
	
	protected void initializeEmbeddableKey() {
	}
	
	private UserFacade getFacade() {
		return ejbFacade;
	}
	
	
	public Users prepareCreate() {
		selected = new Users();
		

		userpermissions = new ArrayList<UserPermission>();
		for(UserRights userright: ejbUserFacade.findAll())
		{
			UserPermission up = new UserPermission(userright,true, true, true, new Date(), new Date(), 1);
			up.setUserRefID(selected);

			up.setCreatedDate(new Date());
			up.setModifiedDate(new Date());
			up.setIsActive(true);
			up.setUserCreated(userManager.getCurrentUser().getId());

			userpermissions.add(up);
		}
		selected.setUserpermissions(userpermissions);
		initializeEmbeddableKey();
		return selected;
	}
	
	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UserCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UserUpdated"));
	}
	
	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UserDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public List<Users> getItems() {
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
					if(selected.getId() != null)
						getFacade().edit(selected);
					else
					{
						selected.setUserPass(Utility.getHashedPassword(selected.getUserPass()));
						getFacade().edit(selected);

					}
				}
				else {
					getFacade().inactivate(selected);
				}
				JsfUtil.addSuccessMessage(successMessage);
			} catch (EJBException ex) {
				ex.printStackTrace();
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
	
	public Users getUser(java.lang.Integer id) {
		return getFacade().find(id);
	}
	
	public List<Users> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}
	
	public List<Users> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	/**
	 * @return the userpermissions
	 */
	public List<UserPermission> getUserpermissions() {

		return userpermissions;
	}
	
	/**
	 * @param userpermissions the userpermissions to set
	 */
	public void setUserpermissions(List<UserPermission> userpermissions) {

		this.userpermissions = userpermissions;
	}
	
	@FacesConverter(forClass = Users.class)
	public static class UserControllerConverter implements Converter {
		
		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			UserController controller = (UserController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "userController");
			return controller.getUser(getKey(value));
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
			if (object instanceof Users) {
				Users o = (Users) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Users.class.getName()});
				return null;
			}
		}
		
	}
	

	/**
	 * @return the userManager
	 */
	public com.crm.presentation.session.UserManager getUserManager() {

		return userManager;
	}
	

	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(com.crm.presentation.session.UserManager userManager) {

		this.userManager = userManager;
	}
	


}
