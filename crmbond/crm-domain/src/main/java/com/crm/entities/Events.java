/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e"),
	@NamedQuery(name = "Events.findById", query = "SELECT e FROM Events e WHERE e.id = :id"),
	@NamedQuery(name = "Events.findByContactID",
	query = "SELECT e FROM Events e WHERE e.contactID = :contactID"),
	@NamedQuery(name = "Events.findByContactWay",
	query = "SELECT e FROM Events e WHERE e.contactWay = :contactWay"),
	@NamedQuery(name = "Events.findByContactDate",
	query = "SELECT e FROM Events e WHERE e.contactDate = :contactDate"),
	@NamedQuery(name = "Events.findByUserCreated",
	query = "SELECT e FROM Events e WHERE e.userCreated = :userCreated"),
	@NamedQuery(name = "Events.findByInformation",
	query = "SELECT e FROM Events e WHERE e.information = :information"),
	@NamedQuery(name = "Events.findByReContact",
	query = "SELECT e FROM Events e WHERE e.reContact = :reContact"),
	@NamedQuery(name = "Events.findByReContactDate",
	query = "SELECT e FROM Events e WHERE e.reContactDate = :reContactDate"),
	@NamedQuery(name = "Events.findByReContactWay",
	query = "SELECT e FROM Events e WHERE e.reContactWay = :reContactWay"),
	@NamedQuery(name = "Events.findByIsActive",
	query = "SELECT e FROM Events e WHERE e.isActive = :isActive"),
	@NamedQuery(name = "Events.findByCreatedDate",
	query = "SELECT e FROM Events e WHERE e.createdDate = :createdDate"),
	@NamedQuery(name = "Events.findByModifiedDate",
	query = "SELECT e FROM Events e WHERE e.modifiedDate = :modifiedDate")})
public class Events extends AEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int contactID;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String contactWay;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date contactDate;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1000)
	@Column(nullable = false, length = 1000)
	private String information;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private boolean reContact;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date reContactDate;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int reContactWay;

	@JoinColumn(name = "Category", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private EventCategories category;

	public Events() {

	}

	public Events(Integer id) {

		this.id = id;
	}

	public Events(Integer id, int contactID, String contactWay, Date contactDate, String information,
			boolean reContact, Date reContactDate, int reContactWay, boolean isActive, Date createdDate,
			Date modifiedDate) {

		this.id = id;
		this.contactID = contactID;
		this.contactWay = contactWay;
		this.contactDate = contactDate;
		this.information = information;
		this.reContact = reContact;
		this.reContactDate = reContactDate;
		this.reContactWay = reContactWay;
		this.isActive = isActive;
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

	public int getContactID() {

		return contactID;
	}

	public void setContactID(int contactID) {

		this.contactID = contactID;
	}

	public String getContactWay() {

		return contactWay;
	}

	public void setContactWay(String contactWay) {

		this.contactWay = contactWay;
	}

	public Date getContactDate() {

		return contactDate;
	}

	public void setContactDate(Date contactDate) {

		this.contactDate = contactDate;
	}


	public String getInformation() {

		return information;
	}

	public void setInformation(String information) {

		this.information = information;
	}

	public boolean getReContact() {

		return reContact;
	}

	public void setReContact(boolean reContact) {

		this.reContact = reContact;
	}

	public Date getReContactDate() {

		return reContactDate;
	}

	public void setReContactDate(Date reContactDate) {

		this.reContactDate = reContactDate;
	}

	public int getReContactWay() {

		return reContactWay;
	}

	public void setReContactWay(int reContactWay) {

		this.reContactWay = reContactWay;
	}

	@Override
	public boolean getIsActive() {

		return isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {

		this.isActive = isActive;
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

	public EventCategories getCategory() {

		return category;
	}

	public void setCategory(EventCategories category) {

		this.category = category;
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
		if (!(object instanceof Events)) {
			return false;
		}
		Events other = (Events) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "com.crm.entities.Events[ id=" + id + " ]";
	}

	@Override
	public String getShortDescription() {

		return information;
	}
}
