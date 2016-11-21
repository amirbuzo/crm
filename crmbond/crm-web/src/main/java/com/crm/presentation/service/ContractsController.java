package com.crm.presentation.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
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

import com.crm.entities.Contracts;
import com.crm.presentation.util.AbstractManageBean;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.ContractsFacade;

@Named("contractsController")
@ViewScoped
public class ContractsController extends AbstractManageBean<Contracts> implements Serializable {
	private static final Logger LOG = LogManager.getLogger(ContractsController.class);

	@EJB
	private com.crm.sessionbean.ContractsFacade ejbFacade;
	private LazyDataModel<Contracts> items = null;
	private Contracts selected;
	
	@PostConstruct
	public void init()
	{
		if(items == null)
			items=getItems();
		
	}
	
	public ContractsController() {
	}
	
	public Contracts getSelected() {
		return selected;
	}
	
	public void setSelected(Contracts selected) {
		this.selected = selected;
	}
	
	protected void setEmbeddableKeys() {
	}
	
	protected void initializeEmbeddableKey() {
	}
	
	@Override
	public ContractsFacade getFacade() {
		return ejbFacade;
	}
	public String addNewField(String fieldName)
	{
		selected.getAttributes().put(fieldName, "");
		setNewfieldname(null);
		return "";
	}
	public Contracts prepareCreate() {
		selected = new Contracts();
		Map map = new HashMap();
		selected.setAttributes(map);
		return selected;
	}
	
	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ContractsCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}
	
	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ContractsUpdated"));
	}
	
	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ContractsDeleted"));
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
	
	public Contracts getContracts(java.lang.Integer id) {
		return getFacade().find(id);
	}
	
	public List<Contracts> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}
	
	public List<Contracts> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}
	
	@FacesConverter(forClass = Contracts.class)
	public static class ContractsControllerConverter implements Converter {
		
		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			ContractsController controller = (ContractsController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "contractsController");
			return controller.getContracts(getKey(value));
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
			if (object instanceof Contracts) {
				Contracts o = (Contracts) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Contracts.class.getName()});
				return null;
			}
		}
		
	}
	
}
