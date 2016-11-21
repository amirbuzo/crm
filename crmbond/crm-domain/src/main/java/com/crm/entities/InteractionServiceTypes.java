/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
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
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InteractionServiceTypes.findAll",
        query = "SELECT i FROM InteractionServiceTypes i"),
    @NamedQuery(name = "InteractionServiceTypes.findById",
        query = "SELECT i FROM InteractionServiceTypes i WHERE i.id = :id"),
    @NamedQuery(name = "InteractionServiceTypes.findByDescription",
        query = "SELECT i FROM InteractionServiceTypes i WHERE i.description = :description"),
    @NamedQuery(name = "InteractionServiceTypes.findByIsActive",
        query = "SELECT i FROM InteractionServiceTypes i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "InteractionServiceTypes.findByCreatedDate",
        query = "SELECT i FROM InteractionServiceTypes i WHERE i.createdDate = :createdDate"),
    @NamedQuery(name = "InteractionServiceTypes.findByModifiedDate",
        query = "SELECT i FROM InteractionServiceTypes i WHERE i.modifiedDate = :modifiedDate")})
public class InteractionServiceTypes extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String description;
	
	@OneToMany(mappedBy = "interactionType", fetch = FetchType.EAGER)
	private List<InteractionLogs> interactionServicesList;
	
	public InteractionServiceTypes() {
	
	}
	
	public InteractionServiceTypes(Integer id) {
	
		this.id = id;
	}
	
	public InteractionServiceTypes(Integer id, String description, boolean isActive,
	    Date createdDate, Date modifiedDate) {
	
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
	public List<InteractionLogs> getInteractionServicesList() {
	
		return interactionServicesList;
	}
	
	public void setInteractionServicesList(List<InteractionLogs> interactionServicesList) {
	
		this.interactionServicesList = interactionServicesList;
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
		if (!(object instanceof InteractionServiceTypes)) {
			return false;
		}
		InteractionServiceTypes other = (InteractionServiceTypes) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return description;
	}
	
	@Override
	public String getShortDescription() {
	
		// TODO Auto-generated method stub
		return description;
	}
}
