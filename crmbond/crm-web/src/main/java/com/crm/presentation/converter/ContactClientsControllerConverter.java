package com.crm.presentation.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.entities.ContactClients;
import com.crm.presentation.service.ContactClientsController;

@FacesConverter("ContactClientsControllerConverter")
public class ContactClientsControllerConverter implements Converter {
	private static final Logger LOG = LogManager.getLogger(ContactClientsControllerConverter.class);
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		ContactClientsController controller = (ContactClientsController) facesContext.getApplication().getELResolver().
				getValue(facesContext.getELContext(), null, "contactClientsController");
		return controller.getContactClients(getKey(value));
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
		if (object instanceof ContactClients) {
			ContactClients o = (ContactClients) object;
			return getStringKey(o.getId());
		} else {
			LOG.error( "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ContactClients.class.getName()});
			return null;
		}
	}

}