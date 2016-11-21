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
    @NamedQuery(name = "States.findAll", query = "SELECT s FROM States s"),
    @NamedQuery(name = "States.findById", query = "SELECT s FROM States s WHERE s.id = :id"),
    @NamedQuery(name = "States.findByCode", query = "SELECT s FROM States s WHERE s.code = :code"),
    @NamedQuery(name = "States.findByDescription",
        query = "SELECT s FROM States s WHERE s.description = :description"),
    @NamedQuery(name = "States.findByIsActive",
        query = "SELECT s FROM States s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "States.findByCreatedDate",
        query = "SELECT s FROM States s WHERE s.createdDate = :createdDate"),
    @NamedQuery(name = "States.findByModifiedDate",
        query = "SELECT s FROM States s WHERE s.modifiedDate = :modifiedDate")})
public class States extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(nullable = false, length = 20)
	private String code;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(nullable = false, length = 200)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stateID", fetch = FetchType.LAZY)
	private List<Cities> citiesList;
	
	public States() {
	
	}
	
	public States(Integer id) {
	
		this.id = id;
	}
	
	public States(Integer id, String code, String description, boolean isActive, Date createdDate,
	    Date modifiedDate) {
	
		this.id = id;
		this.code = code;
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
	public List<Cities> getCitiesList() {
	
		return citiesList;
	}
	
	public void setCitiesList(List<Cities> citiesList) {
	
		this.citiesList = citiesList;
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
		if (!(object instanceof States)) {
			return false;
		}
		States other = (States) object;
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
		return code + "-" + description;
	}
}
