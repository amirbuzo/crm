/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "InteractionLogs.findAll", query = "SELECT l FROM InteractionLogs l"),
	@NamedQuery(name = "InteractionLogs.findById",
	query = "SELECT l FROM InteractionLogs l WHERE l.id = :id"),
	@NamedQuery(name = "InteractionLogs.findByInteractionID",
	query = "SELECT l FROM InteractionLogs l WHERE l.interactionID = :interactionID"),
	@NamedQuery(name = "InteractionLogs.findByUserID",
	query = "SELECT l FROM InteractionLogs l WHERE l.userID = :userID"),
	@NamedQuery(name = "InteractionLogs.findByInteractionStatus",
	query = "SELECT l FROM InteractionLogs l WHERE l.interactionStatus = :interactionStatus"),
	@NamedQuery(name = "InteractionLogs.findByTimePeriod",
	query = "SELECT l FROM InteractionLogs l WHERE l.timePeriod = :timePeriod"),
	@NamedQuery(name = "InteractionLogs.findByInteractionType",
	query = "SELECT l FROM InteractionLogs l WHERE l.interactionType = :interactionType"),
	@NamedQuery(name = "InteractionLogs.findByContactID",
	query = "SELECT l FROM InteractionLogs l WHERE l.contactID = :contactID"),
	@NamedQuery(name = "InteractionLogs.findByCreatedDate",
	query = "SELECT l FROM InteractionLogs l WHERE l.createdDate = :createdDate"),
	@NamedQuery(name = "InteractionLogs.findByModifiedDate",
	query = "SELECT l FROM InteractionLogs l WHERE l.modifiedDate = :modifiedDate")})
public class InteractionLogs extends AEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "InteractionID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private InteractionServices interactionID;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int userID;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(nullable = false)
	private String note;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int interactionStatus;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private double timePeriod;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int contactID;

	@JoinColumn(name = "InteractionType", referencedColumnName = "ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private InteractionServiceTypes interactionType;


	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(name="name")
	@Column(name="value")
	@CollectionTable(name="inter_logs_attributes", joinColumns=@JoinColumn(name="id"))
	private Map<String, String> attributes;
	
	public InteractionLogs() {

	}

	public InteractionLogs(Integer id) {

		this.id = id;
	}

	public InteractionLogs(Integer id, int userID, String note, int interactionStatus,
			double timePeriod, int contactID, Date createdDate, Date modifiedDate) {

		this.id = id;
		this.userID = userID;
		this.note = note;
		this.interactionStatus = interactionStatus;
		this.timePeriod = timePeriod;
		this.contactID = contactID;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	@Override
	public Integer getId() {

		return id;
	}

	@Override
	public void setId(Integer id) {

		this.id = id;
	}

	public InteractionServices getInteractionID() {

		return interactionID;
	}

	public void setInteractionID(InteractionServices interactionID) {

		this.interactionID = interactionID;
	}

	public int getUserID() {

		return userID;
	}

	public void setUserID(int userID) {

		this.userID = userID;
	}

	public String getNote() {

		return note;
	}

	public void setNote(String note) {

		this.note = note;
	}

	public int getInteractionStatus() {

		return interactionStatus;
	}

	public void setInteractionStatus(int interactionStatus) {

		this.interactionStatus = interactionStatus;
	}

	public double getTimePeriod() {

		return timePeriod;
	}

	public void setTimePeriod(double timePeriod) {

		this.timePeriod = timePeriod;
	}

	public InteractionServiceTypes getInteractionType() {

		return interactionType;
	}

	public void setInteractionType(InteractionServiceTypes interactionType) {

		this.interactionType = interactionType;
	}

	public int getContactID() {

		return contactID;
	}

	public void setContactID(int contactID) {

		this.contactID = contactID;
	}

	@Override
	public Date getCreatedDate() {

		return createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {

		this.createdDate = createdDate;
	}

	@Override
	public Date getModifiedDate() {

		return modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {

		this.modifiedDate = modifiedDate;
	}

	@Override
	public int hashCode() {

		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InteractionLogs)) {
			return false;
		}
		InteractionLogs other = (InteractionLogs) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "com.crm.entities.InteractionLogs[ id=" + id + " ]";
	}

	@Override
	public String getShortDescription() {

		return interactionID.getShortDescription();
	}
	

	/**
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {

		return attributes;
	}
	

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, String> attributes) {

		this.attributes = attributes;
	}


}
