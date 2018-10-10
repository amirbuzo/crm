package com.crm.presentation.util;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.crm.entities.AEntity;
import com.crm.entities.Users;
import com.crm.presentation.session.UserManager;
import com.crm.sessionbean.AbstractFacade;

/**
 * {@link AbstractManageBean} <b>Purpose:</b>This class serves as Base Bean for all Managed Beans in the
 * Controller Layer of the MVC pattern.
 *
 * @author abuzo
 *
 */
public abstract class AbstractManageBean<T extends AEntity> implements Serializable {

	private static final Logger LOG = LogManager.getLogger(AbstractManageBean.class);

	private static final long serialVersionUID = -2981621111018608774L;

	protected LazyDataModel<T> items = null;
	
	private String newfieldname;

	@Inject
	private com.crm.presentation.session.UserManager userManager;
	
	protected void redirectToError() {

		try {
			getExternalContext().redirect("Error");
		} catch (IOException e) {
			LOG.log(Level.ERROR,"Unexpected error!!!", e);
		}
	}

	protected void redirectToTransactionError() {

		try {
			getExternalContext().redirect("Errorr");
		} catch (IOException e) {
			LOG.log(Level.ERROR,"Unexpected error!!!", e);

		}
	}

	protected void navigateToTransactionError() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response =
				(HttpServletResponse) facesContext.getExternalContext().getResponse();
		try {
			response.sendRedirect("connectionerror");
		} catch (IOException ioe) {
			LOG.error( ioe.getMessage(), ioe);
			
		}
		facesContext.responseComplete();
	}

	/**
	 *
	 * @param severityInfo
	 * @param summary
	 * @param details
	 */
	public static void notification(Severity severityInfo, String summary, String details) {

		getCurrentInstance().addMessage(null, new FacesMessage(severityInfo, summary, details));
	}

	/**
	 *
	 */
	public static void notificationTransactionError() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response =
				(HttpServletResponse) facesContext.getExternalContext().getResponse();
		try {
			response.sendError(404);
		} catch (IOException ioe) {
			LOG.log(Level.ERROR,"Unexpected error!!!", ioe);
		}
		facesContext.responseComplete();
	}

	
	/**
	 * @return the userManager
	 */
	public UserManager getUserManager() {
		
		return userManager;
	}

	
	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(UserManager userManager) {
		
		this.userManager = userManager;
	}

	/**
	 * @return FacesContext
	 */
	private static FacesContext getCurrentInstance() {

		return FacesContext.getCurrentInstance();
	}

	/**
	 *
	 * @param componentId - name of component to be updated.
	 */
	public static void updateViewComponent(String componentId) {

		RequestContext.getCurrentInstance().update(componentId);
	}

	/**
	 * This method returns the value of the named attribute as an Object, or null if no attribute of
	 * the given name exists
	 *
	 * @param prameterName
	 * @return value of attribute
	 */
	public static String getRequestParameterValue(String prameterName) {

		HttpServletRequest request = getHttpServletRequest();
		return request.getParameter(prameterName);
	}

	/**
	 *
	 * @return HttpServletRequest request
	 */
	public static HttpServletRequest getHttpServletRequest() {

		HttpServletRequest request = (HttpServletRequest) getExternalContext().getRequest();
		return request;
	}

	/**
	 *
	 * @return ExternalContext
	 */
	public static ExternalContext getExternalContext() {

		return getCurrentInstance().getExternalContext();
	}
	
	public Date getNowDate()
	{
		return new Date();
	}
	public int getUserId()
	{
		return userManager.getCurrentUser().getUserID();
	}

	public String getUserName()
	{
		return userManager.getCurrentUser().getUserName();
	}
	protected Users getCurrentUser() {

		return  userManager.getCurrentUser();
	}


	/**
	 * @param items the items to set
	 */
	public void setItems(LazyDataModel<T> items) {

		this.items = items;
	}
	
	public LazyDataModel<T> getItems() {
		if (items == null) {
			items = new LazyDataModel<T>() {
				
				
				@Override
				public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
					
					items.setRowCount(getFacade() .count(filters));
					return getFacade() .getResultList(first, pageSize, sortField, sortOrder, filters);

				}
				@Override
				public T getRowData(String rowKey) {
					List<AEntity> objects = ((List<AEntity>) super.getWrappedData());
					for (AEntity entity : objects) {
						if (entity.getId().equals(Integer.parseInt(rowKey)))
							return (T) entity;
					}
					return null;
				}
				
			};
		}
		return items;
	}


	/**
	 * @return the ejbFacade
	 */
	public abstract AbstractFacade<T> getFacade();

	public List<T> completeTheme(String query) {
		List<T> allThemes = getFacade().findAll();
		List<T> filteredThemes = new ArrayList<T>();

		for (int i = 0; i < allThemes.size(); i++) {
			T skin = allThemes.get(i);
			if(skin.getShortDescription().toLowerCase().contains(query) || skin.getShortDescription().toLowerCase().startsWith(query)) {
				filteredThemes.add(skin);
			}
		}

		return filteredThemes;
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
