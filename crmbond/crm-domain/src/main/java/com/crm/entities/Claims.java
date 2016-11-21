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
    @NamedQuery(name = "Claims.findAll", query = "SELECT c FROM Claims c"),
    @NamedQuery(name = "Claims.findById", query = "SELECT c FROM Claims c WHERE c.id = :id"),
    @NamedQuery(name = "Claims.findByClaimDescription",
        query = "SELECT c FROM Claims c WHERE c.claimDescription = :claimDescription"),
    @NamedQuery(name = "Claims.findByIsActive",
        query = "SELECT c FROM Claims c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "Claims.findByModifiedDate",
        query = "SELECT c FROM Claims c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Claims.findByCreatedDate",
        query = "SELECT c FROM Claims c WHERE c.createdDate = :createdDate")})
public class Claims extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String claimDescription;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "claimID", fetch = FetchType.LAZY)
	private List<Requests> requestsList;
	
	public Claims() {
	
	}
	
	public Claims(Integer id) {
	
		this.id = id;
	}
	
	public Claims(Integer id, String claimDescription, boolean isActive, Date modifiedDate,
	    Date createdDate) {
	
		this.id = id;
		this.claimDescription = claimDescription;
		this.isActive = isActive;
		this.modifiedDate = modifiedDate;
		this.createdDate = createdDate;
	}
	
	@Override
	public Integer getId() {
	
		return id;
	}
	
	@Override
	public void setId(Integer id) {
	
		this.id = id;
	}
	
	public String getClaimDescription() {
	
		return claimDescription;
	}
	
	public void setClaimDescription(String claimDescription) {
	
		this.claimDescription = claimDescription;
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
	public Date getModifiedDate() {
	
		return modifiedDate;
	}
	
	@Override
	public void setModifiedDate(Date modifiedDate) {
	
		this.modifiedDate = modifiedDate;
	}
	
	@Override
	public Date getCreatedDate() {
	
		return createdDate;
	}
	
	@Override
	public void setCreatedDate(Date createdDate) {
	
		this.createdDate = createdDate;
	}
	
	@XmlTransient
	public List<Requests> getRequestsList() {
	
		return requestsList;
	}
	
	public void setRequestsList(List<Requests> requestsList) {
	
		this.requestsList = requestsList;
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
		if (!(object instanceof Claims)) {
			return false;
		}
		Claims other = (Claims) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return claimDescription;
	}
	
	@Override
	public String getShortDescription() {
	
		return claimDescription;
	}
}
