/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
	@NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id"),
	@NamedQuery(name = "Company.findByNipt", query = "SELECT c FROM Company c WHERE c.nipt = :nipt"),
	@NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
	@NamedQuery(name = "Company.findByStatus",
	query = "SELECT c FROM Company c WHERE c.status = :status"),
	@NamedQuery(name = "Company.findByRepresentative",
	query = "SELECT c FROM Company c WHERE c.representative = :representative"),
	@NamedQuery(name = "Company.findByRegion",
	query = "SELECT c FROM Company c WHERE c.region = :region"),
	@NamedQuery(name = "Company.findByCreatedDate",
	query = "SELECT c FROM Company c WHERE c.createdDate = :createdDate"),
	@NamedQuery(name = "Company.findByModifiedDate",
	query = "SELECT c FROM Company c WHERE c.modifiedDate = :modifiedDate")})
public class Company extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Size(max = 250)
	@Column(unique = true, length = 250)
	private String nipt;
	
	@Size(max = 250)
	@Column(length = 250)
	private String name;
	
	@Size(max = 250)
	@Column(length = 250)
	private String status;
	
	@Size(max = 250)
	@Column(length = 250)
	private String representative;
	
	@Size(max = 250)
	@Column(length = 250)
	private String region;

	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(name="name")
	@Column(name="value")
	@CollectionTable(name="company_attributes", joinColumns=@JoinColumn(name="id"))
	private Map<String, String> attributes;
	public Company() {
		
	}
	
	public Company(Integer id) {
		
		this.id = id;
	}
	
	@Override
	public Integer getId() {
		
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		
		this.id = id;
	}
	
	public String getNipt() {
		
		return nipt;
	}
	
	public void setNipt(String nipt) {
		
		this.nipt = nipt;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getStatus() {
		
		return status;
	}
	
	public void setStatus(String status) {
		
		this.status = status;
	}
	
	public String getRepresentative() {
		
		return representative;
	}
	
	public void setRepresentative(String representative) {
		
		this.representative = representative;
	}
	

	/**
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {

		return attributes;
	}
	

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, String> attributes) {

		this.attributes = attributes;
	}
	
	public String getRegion() {
		
		return region;
	}
	
	public void setRegion(String region) {
		
		this.region = region;
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
	
	@Override
	public int hashCode() {
		
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Company)) {
			return false;
		}
		Company other = (Company) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		
		return "com.crm.entities.Company[ id=" + id + " ]";
	}
	
	@Override
	public String getShortDescription() {
		
		return name + "-" + nipt;
	}
}
