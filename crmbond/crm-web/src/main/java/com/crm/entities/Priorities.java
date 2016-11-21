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
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Priorities.findAll", query = "SELECT p FROM Priorities p"),
    @NamedQuery(name = "Priorities.findById", query = "SELECT p FROM Priorities p WHERE p.id = :id"),
    @NamedQuery(name = "Priorities.findByPriorityName",
        query = "SELECT p FROM Priorities p WHERE p.priorityName = :priorityName"),
    @NamedQuery(name = "Priorities.findByIsActive",
        query = "SELECT p FROM Priorities p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Priorities.findByCreatedDate",
        query = "SELECT p FROM Priorities p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "Priorities.findByModifiedDate",
        query = "SELECT p FROM Priorities p WHERE p.modifiedDate = :modifiedDate")})
public class Priorities extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String priorityName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "priority", fetch = FetchType.LAZY)
	private List<Clients> clientsList;
	
	public Priorities() {
	
	}
	
	public Priorities(Integer id) {
	
		this.id = id;
	}
	
	public Priorities(Integer id, String priorityName, boolean isActive, Date createdDate,
	    Date modifiedDate) {
	
		this.id = id;
		this.priorityName = priorityName;
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
	
	public String getPriorityName() {
	
		return priorityName;
	}
	
	public void setPriorityName(String priorityName) {
	
		this.priorityName = priorityName;
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
	public List<Clients> getClientsList() {
	
		return clientsList;
	}
	
	public void setClientsList(List<Clients> clientsList) {
	
		this.clientsList = clientsList;
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
		if (!(object instanceof Priorities)) {
			return false;
		}
		Priorities other = (Priorities) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return priorityName;
	}
	
	@Override
	public String getShortDescription() {
	
		// TODO Auto-generated method stub
		return priorityName;
	}
}
