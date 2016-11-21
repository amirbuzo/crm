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
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findById", query = "SELECT c FROM Currency c WHERE c.id = :id"),
    @NamedQuery(name = "Currency.findByCode",
        query = "SELECT c FROM Currency c WHERE c.code = :code"),
    @NamedQuery(name = "Currency.findByDescription",
        query = "SELECT c FROM Currency c WHERE c.description = :description"),
    @NamedQuery(name = "Currency.findByUserID",
        query = "SELECT c FROM Currency c WHERE c.userID = :userID"),
    @NamedQuery(name = "Currency.findByIsDefault",
        query = "SELECT c FROM Currency c WHERE c.isDefault = :isDefault"),
    @NamedQuery(name = "Currency.findByCreatedDate",
        query = "SELECT c FROM Currency c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Currency.findByModifiedDate",
        query = "SELECT c FROM Currency c WHERE c.modifiedDate = :modifiedDate")})
public class Currency extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String code;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(nullable = false, length = 200)
	private String description;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int userID;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int isDefault;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "currency", fetch = FetchType.LAZY)
	private List<Contracts> contractsList;
	
	public Currency() {
	
	}
	
	public Currency(Integer id) {
	
		this.id = id;
	}
	
	public Currency(Integer id, String code, String description, int userID, int isDefault,
	    Date createdDate, Date modifiedDate) {
	
		this.id = id;
		this.code = code;
		this.description = description;
		this.userID = userID;
		this.isDefault = isDefault;
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
	
	public String getCode() {
	
		return code;
	}
	
	public void setCode(String code) {
	
		this.code = code;
	}
	
	public String getDescription() {
	
		return description;
	}
	
	public void setDescription(String description) {
	
		this.description = description;
	}
	
	public int getUserID() {
	
		return userID;
	}
	
	public void setUserID(int userID) {
	
		this.userID = userID;
	}
	
	public int getIsDefault() {
	
		return isDefault;
	}
	
	public void setIsDefault(int isDefault) {
	
		this.isDefault = isDefault;
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
		if (!(object instanceof Currency)) {
			return false;
		}
		Currency other = (Currency) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return code;
	}
	
	@Override
	public String getShortDescription() {
	
		return code;
	}
}
