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
    @NamedQuery(name = "ContractTypes.findAll", query = "SELECT c FROM ContractTypes c"),
    @NamedQuery(name = "ContractTypes.findById",
        query = "SELECT c FROM ContractTypes c WHERE c.id = :id"),
    @NamedQuery(name = "ContractTypes.findByDescription",
        query = "SELECT c FROM ContractTypes c WHERE c.description = :description"),
    @NamedQuery(name = "ContractTypes.findByIsActive",
        query = "SELECT c FROM ContractTypes c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "ContractTypes.findByCreatedDate",
        query = "SELECT c FROM ContractTypes c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "ContractTypes.findByModifiedDate",
        query = "SELECT c FROM ContractTypes c WHERE c.modifiedDate = :modifiedDate")})
public class ContractTypes extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type", fetch = FetchType.LAZY)
	private List<Contracts> contractsList;
	
	public ContractTypes() {
	
	}
	
	public ContractTypes(Integer id) {
	
		this.id = id;
	}
	
	public ContractTypes(Integer id, String description, boolean isActive, Date createdDate,
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
	public List<Contracts> getContractsList() {
	
		return contractsList;
	}
	
	public void setContractsList(List<Contracts> contractsList) {
	
		this.contractsList = contractsList;
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
		if (!(object instanceof ContractTypes)) {
			return false;
		}
		ContractTypes other = (ContractTypes) object;
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
	
		return description;
	}
}
