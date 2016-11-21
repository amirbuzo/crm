/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abuzo
 */
@Entity(name = "Referenca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referenca.findAll", query = "SELECT r FROM Referenca r"),
    @NamedQuery(name = "Referenca.findById", query = "SELECT r FROM Referenca r WHERE r.id = :id"),
    @NamedQuery(name = "Referenca.findByDescription",
        query = "SELECT r FROM Referenca r WHERE r.description = :description"),
    @NamedQuery(name = "Referenca.findByIsActive",
        query = "SELECT r FROM Referenca r WHERE r.isActive = :isActive"),
    @NamedQuery(name = "Referenca.findByCreatedDate",
        query = "SELECT r FROM Referenca r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "Referenca.findByModifiedDate",
        query = "SELECT r FROM Referenca r WHERE r.modifiedDate = :modifiedDate")})
public class References extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "referenca", fetch = FetchType.LAZY)
	private List<PotentialContacts> potentialContactsList;
	
	public References() {
	
	}
	
	public References(Integer id) {
	
		this.id = id;
	}
	
	public References(Integer id, String description, boolean isActive, Date createdDate,
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
	
	@XmlTransient
	public List<PotentialContacts> getPotentialContactsList() {
	
		return potentialContactsList;
	}
	
	public void setPotentialContactsList(List<PotentialContacts> potentialContactsList) {
	
		this.potentialContactsList = potentialContactsList;
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
		if (!(object instanceof References)) {
			return false;
		}
		References other = (References) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return "com.crm.entities.References[ id=" + id + " ]";
	}
	
	@Override
	public String getShortDescription() {
	
		// TODO Auto-generated method stub
		return description;
	}
}
