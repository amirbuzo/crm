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

import com.crm.entities.Company;
import com.crm.presentation.util.AbstractManageBean;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.CompanyFacade;

@Named("companyController")
@ViewScoped
public class CompanyController  extends AbstractManageBean<Company> implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LogManager.getLogger(CompanyController.class);

	@EJB
	private com.crm.sessionbean.CompanyFacade ejbFacade;
	//private List<Company> items = null;
	private Company selected;
	private LazyDataModel<Company> items;        // getter and setter

	
	
	public CompanyController() {
	}
	
	public Company getSelected() {
		return selected;
	}
	
	public void setSelected(Company selected) {
		this.selected = selected;
	}
	
	protected void setEmbeddableKeys() {
	}
	
	protected void initializeEmbeddableKey() {
	}
	
	@Override
	public CompanyFacade getFacade() {
		return ejbFacade;
	}
	
	public Company prepareCreate() {
		selected = new Company();
		initializeEmbeddableKey();
		return selected;
	}
	
	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CompanyCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CompanyUpdated"));
	}
	
	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CompanyDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public String addNewField(String fieldName)
	{
		selected.getAttributes().put(fieldName, "");
		setNewfieldname(null);
		return "";
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
	
	public Company getCompany(java.lang.Integer id) {
		return getFacade().find(id);
	}
	
	public List<Company> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}
	
	public List<Company> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	@FacesConverter(forClass = Company.class)
	public static class CompanyControllerConverter implements Converter {
		
		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			CompanyController controller = (CompanyController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "companyController");
			return controller.getCompany(getKey(value));
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
			if (object instanceof Company) {
				Company o = (Company) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Company.class.getName()});
				return null;
			}
		}
		
	}
	
}
