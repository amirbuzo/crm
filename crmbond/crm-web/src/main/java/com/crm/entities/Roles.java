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
	@NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
	@NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id"),
	@NamedQuery(name = "Roles.findByName", query = "SELECT r FROM Roles r WHERE r.name = :name"),
	@NamedQuery(name = "Roles.findByDescription",
	query = "SELECT r FROM Roles r WHERE r.description = :description"),
	@NamedQuery(name = "Roles.findByIsActive",
	query = "SELECT r FROM Roles r WHERE r.isActive = :isActive"),
	@NamedQuery(name = "Roles.findByCreatedDate",
	query = "SELECT r FROM Roles r WHERE r.createdDate = :createdDate"),
	@NamedQuery(name = "Roles.findByModifiedDate",
	query = "SELECT r FROM Roles r WHERE r.modifiedDate = :modifiedDate")})
public class Roles extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50)
	private String name;
	
	@Basic(optional = true)
	@Column(nullable = true, length = 300)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID", fetch = FetchType.EAGER)
	private List<UserRights> rights;
	
	@Override
	public Integer getId() {
		
		// TODO Auto-generated method stub
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		
		this.id = id;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
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
	
	public void setIsActive(Boolean isActive) {
		
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
	
	/**
	 * @return the rights
	 */
	@XmlTransient
	public List<UserRights> getRights() {
		
		return rights;
	}
	
	/**
	 * @param rights the rights to set
	 */
	public void setRights(List<UserRights> rights) {
		
		this.rights = rights;
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
		if (!(object instanceof Roles)) {
			return false;
		}
		Roles other = (Roles) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		
		return "Roles" + name;
	}
	
	@Override
	public String getShortDescription() {
		
		// TODO Auto-generated method stub
		return name;
	}
}
