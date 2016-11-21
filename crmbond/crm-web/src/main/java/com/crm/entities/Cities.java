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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Model
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c"),
    @NamedQuery(name = "Cities.findById", query = "SELECT c FROM Cities c WHERE c.id = :id"),
    @NamedQuery(name = "Cities.findByDescription",
        query = "SELECT c FROM Cities c WHERE c.description = :description"),
    @NamedQuery(name = "Cities.findByIsActive",
        query = "SELECT c FROM Cities c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "Cities.findByCreatedDate",
        query = "SELECT c FROM Cities c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Cities.findByModifiedDate",
        query = "SELECT c FROM Cities c WHERE c.modifiedDate = :modifiedDate")})
public class Cities extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(nullable = false, length = 200)
	private String description;
	
	@JoinColumn(name = "StateID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private States stateID;
	
	public Cities() {
	
	}
	
	public Cities(Integer id) {
	
		this.id = id;
	}
	
	public Cities(Integer id, String description, boolean isActive, Date createdDate,
	    Date modifiedDate) {
	
		this.id = id;
		this.description = description;
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
	
	public String getDescription() {
	
		return description;
	}
	
	public void setDescription(String description) {
	
		this.description = description;
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
	
	public States getStateID() {
	
		return stateID;
	}
	
	public void setStateID(States stateID) {
	
		this.stateID = stateID;
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
		if (!(object instanceof Cities)) {
			return false;
		}
		Cities other = (Cities) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return "com.crm.entities.Cities[ id=" + id + " ]";
	}
	
	@Override
	public String getShortDescription() {
	
		return stateID.getCode() + "-" + description;
	}
}
