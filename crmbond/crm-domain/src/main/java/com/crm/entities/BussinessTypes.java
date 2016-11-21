/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;
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
@Model
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BussinessTypes.findAll", query = "SELECT b FROM BussinessTypes b"),
    @NamedQuery(name = "BussinessTypes.findById",
        query = "SELECT b FROM BussinessTypes b WHERE b.id = :id"),
    @NamedQuery(name = "BussinessTypes.findByBussinessType",
        query = "SELECT b FROM BussinessTypes b WHERE b.bussinessType = :bussinessType"),
    @NamedQuery(name = "BussinessTypes.findByIsActive",
        query = "SELECT b FROM BussinessTypes b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BussinessTypes.findByCreatedDate",
        query = "SELECT b FROM BussinessTypes b WHERE b.createdDate = :createdDate"),
    @NamedQuery(name = "BussinessTypes.findByModifiedDate",
        query = "SELECT b FROM BussinessTypes b WHERE b.modifiedDate = :modifiedDate")})
public class BussinessTypes extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String bussinessType;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bussinessType", fetch = FetchType.LAZY)
	private List<Clients> clientsList;
	
	public BussinessTypes() {
	
	}
	
	public BussinessTypes(Integer id) {
	
		this.id = id;
	}
	
	public BussinessTypes(Integer id, String bussinessType, boolean isActive, Date createdDate,
	    Date modifiedDate) {
	
		this.id = id;
		this.bussinessType = bussinessType;
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
	
	public String getBussinessType() {
	
		return bussinessType;
	}
	
	public void setBussinessType(String bussinessType) {
	
		this.bussinessType = bussinessType;
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
		if (!(object instanceof BussinessTypes)) {
			return false;
		}
		BussinessTypes other = (BussinessTypes) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return bussinessType;
	}
	
	@Override
	public String getShortDescription() {
	
		return bussinessType;
	}
}
