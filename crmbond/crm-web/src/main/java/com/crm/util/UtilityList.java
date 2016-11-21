package com.crm.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.ejb.Singleton;

/**
 * {@link UtilityList} implements Serializable
 * <p>
 * Purpose:
 * </p>
 * This bean is created to get lists of values for specific attributes. These values are stored into
 * a properties file in order to facilitate the update process.
 * <p>
 * <b>Details:</b> Class name - UtilityList <br/>
 * Bean name - utils <br/>
 * Bean scope - ApplicationScoped
 *
 * @author CRM
 * @since January 2015
 * @version 1.0
 */
@Singleton
@ManagedBean("utils")
public class UtilityList implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 5904158831472098657L;
	
	public Map<Integer, String> interactionstatus;
	
	public Map<Integer, String> place;
	
	public Map<Integer, String> clientstatus;
	
	public List<String> objectTypes;
	
	public Map<Integer, String> clientstatusmap;
	
	public Map<Integer, String> potentialclient;
	
	public Map<Integer, String> potentialcontact;
	
	public Map<Integer, String> contractstatus;
	
	public Map<Integer, String> requeststatus;
	
	public Map<Integer, String> eventstatus;
	
	public Map<Integer, String> interactionservicestatus;
	
	/**
	 * @return the interactionstatus
	 */
	public Map<Integer, String> getInteractionstatus() {
	
		return interactionstatus;
	}
	
	/**
	 * @param interactionstatus the interactionstatus to set
	 */
	public void setInteractionstatus(Map<Integer, String> interactionstatus) {
	
		this.interactionstatus = interactionstatus;
	}
	
	/**
	 * @return the place
	 */
	public Map<Integer, String> getPlace() {
	
		return place;
	}
	
	/**
	 * @param place the place to set
	 */
	public void setPlace(Map<Integer, String> place) {
	
		this.place = place;
	}
	
	/**
	 * @return the clientstatus
	 */
	public Map<Integer, String> getClientstatus() {
	
		return clientstatus;
	}
	
	/**
	 * @param clientstatus the clientstatus to set
	 */
	public void setClientstatus(Map<Integer, String> clientstatus) {
	
		this.clientstatus = clientstatus;
	}
	
	/**
	 * @return the objectTypes
	 */
	public List<String> getObjectTypes() {
	
		return objectTypes;
	}
	
	/**
	 * @param objectTypes the objectTypes to set
	 */
	public void setObjectTypes(List<String> objectTypes) {
	
		this.objectTypes = objectTypes;
	}
	
	/**
	 * @return the clientstatusmap
	 */
	public Map<Integer, String> getClientstatusmap() {
	
		return clientstatusmap;
	}
	
	/**
	 * @param clientstatusmap the clientstatusmap to set
	 */
	public void setClientstatusmap(Map<Integer, String> clientstatusmap) {
	
		this.clientstatusmap = clientstatusmap;
	}
	
	/**
	 * @return the potentialclient
	 */
	public Map<Integer, String> getPotentialclient() {
	
		return potentialclient;
	}
	
	/**
	 * @param potentialclient the potentialclient to set
	 */
	public void setPotentialclient(Map<Integer, String> potentialclient) {
	
		this.potentialclient = potentialclient;
	}
	
	/**
	 * @return the potentialcontact
	 */
	public Map<Integer, String> getPotentialcontact() {
	
		return potentialcontact;
	}
	
	/**
	 * @param potentialcontact the potentialcontact to set
	 */
	public void setPotentialcontact(Map<Integer, String> potentialcontact) {
	
		this.potentialcontact = potentialcontact;
	}
	
	/**
	 * @return the contractstatus
	 */
	public Map<Integer, String> getContractstatus() {
	
		return contractstatus;
	}
	
	/**
	 * @param contractstatus the contractstatus to set
	 */
	public void setContractstatus(Map<Integer, String> contractstatus) {
	
		this.contractstatus = contractstatus;
	}
	
	/**
	 * @return the requeststatus
	 */
	public Map<Integer, String> getRequeststatus() {
	
		return requeststatus;
	}
	
	/**
	 * @param requeststatus the requeststatus to set
	 */
	public void setRequeststatus(Map<Integer, String> requeststatus) {
	
		this.requeststatus = requeststatus;
	}
	
	/**
	 * @return the eventstatus
	 */
	public Map<Integer, String> getEventstatus() {
	
		return eventstatus;
	}
	
	/**
	 * @param eventstatus the eventstatus to set
	 */
	public void setEventstatus(Map<Integer, String> eventstatus) {
	
		this.eventstatus = eventstatus;
	}
	
	/**
	 * @return the interactionservicestatus
	 */
	public Map<Integer, String> getInteractionservicestatus() {
	
		return interactionservicestatus;
	}
	
	/**
	 * @param interactionservicestatus the interactionservicestatus to set
	 */
	public void setInteractionservicestatus(Map<Integer, String> interactionservicestatus) {
	
		this.interactionservicestatus = interactionservicestatus;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}
}
