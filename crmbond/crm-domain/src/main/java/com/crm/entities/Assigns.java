/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.inject.Model;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Model
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Assigns.findAll", query = "SELECT a FROM Assigns a"),
	@NamedQuery(name = "Assigns.findById", query = "SELECT a FROM Assigns a WHERE a.id = :id"),
	@NamedQuery(name = "Assigns.findByUserID",
	query = "SELECT a FROM Assigns a WHERE a.userID = :userID"),
	@NamedQuery(name = "Assigns.findByIsActive",
	query = "SELECT a FROM Assigns a WHERE a.isActive = :isActive"),
	@NamedQuery(name = "Assigns.findByCreatedDate",
	query = "SELECT a FROM Assigns a WHERE a.createdDate = :createdDate"),
	@NamedQuery(name = "Assigns.findByModifiedDate",
	query = "SELECT a FROM Assigns a WHERE a.modifiedDate = :modifiedDate")})
public class Assigns extends AEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int userID;

	@JoinColumn(name = "InteractionID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private InteractionServices interactionID;

	public Assigns() {

	}

	public Assigns(Integer id) {

		this.id = id;
	}

	public Assigns(Integer id, int userID, boolean isActive, Date createdDate, Date modifiedDate) {

		this.userID = userID;
		
	}

	@Override
	public Integer getId() {

		return id;
	}

	@Override
	public void setId(Integer id) {

		this.id = id;
	}

	public int getUserID() {

		return userID;
	}

	public void setUserID(int userID) {

		this.userID = userID;
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

	public InteractionServices getInteractionID() {

		return interactionID;
	}

	public void setInteractionID(InteractionServices interactionID) {

		this.interactionID = interactionID;
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
		if (!(object instanceof Assigns)) {
			return false;
		}
		Assigns other = (Assigns) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "com.crm.entities.Assigns[ id=" + id + " ]";
	}

	@Override
	public String getShortDescription() {

		return id + "" + interactionID;
	}
}
