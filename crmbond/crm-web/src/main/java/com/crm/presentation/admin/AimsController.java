package com.crm.presentation.admin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.crm.entities.Aims;
import com.crm.presentation.util.JsfUtil;
import com.crm.presentation.util.JsfUtil.PersistAction;
import com.crm.sessionbean.AimsFacade;

@Named("aimsController")
@ViewScoped
//@Singleton
//@Startup
//@ConcurrencyManagement(BEAN)
public class AimsController extends AbstractDynamic<Aims>  implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LogManager.getLogger(AimsController.class);

	private String newfieldname;

	@EJB
	private com.crm.sessionbean.AimsFacade ejbFacade;
	
	private List<Aims> items = null;
	
	private Aims selected;



	public AimsController() {
		super(Aims.class);
	}
	public List<Aims> getItems() {
		if (items == null) {
			items = getFacade().findAll();
		}
		return items;
	}
	public Aims getSelected() {
		return selected;
	}

	public void setSelected(Aims selected) {
		this.selected = selected;
	}

	protected void setEmbeddableKeys() {
	}

	protected void initializeEmbeddableKey() {
	}

	
	public AimsFacade getFacade() {
		return ejbFacade;
	}

	public Aims prepareCreate() {
		selected = new Aims();
		Map<String, String> map = new HashMap<String, String>();

		selected.setAttributes(map);
		
		initializeEmbeddableKey();
		return selected;
	}


	

	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AimsCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}

	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AimsUpdated"));
		items=null;
	}

	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AimsDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null;    // Invalidate list of items to trigger re-query.
		}
	}


	private void persist(PersistAction persistAction, String successMessage) {
		selected.getAttributes().remove(null);
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

	public Aims getAims(java.lang.Integer id) {
		return getFacade().find(id);
	}

	public List<Aims> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}

	public List<Aims> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}

	@FacesConverter(forClass = Aims.class)
	public static class AimsControllerConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			AimsController controller = (AimsController) facesContext.getApplication().getELResolver().
					getValue(facesContext.getELContext(), null, "aimsController");
			return controller.getAims(getKey(value));
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
			if (object instanceof Aims) {
				Aims o = (Aims) object;
				return getStringKey(o.getId());
			} else {
				LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Aims.class.getName()});
				return null;
			}
		}

	}
	public String addNewField(String fieldName)
	{
		selected.getAttributes().put(fieldName, "");
		setNewfieldname(null);
		return "";
	}
	
	
	
	/**
	 * @return the newfieldname
	 */
	public String getNewfieldname() {

		return newfieldname;
	}
	
	
	
	/**
	 * @param newfieldname the newfieldname to set
	 */
	public void setNewfieldname(String newfieldname) {

		this.newfieldname = newfieldname;
	}

}
