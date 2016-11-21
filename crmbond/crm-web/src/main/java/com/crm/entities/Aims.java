/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
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
	@NamedQuery(name = "Aims.findAll", query = "SELECT a FROM Aims a"),
	@NamedQuery(name = "Aims.findById", query = "SELECT a FROM Aims a WHERE a.id = :id"),
	@NamedQuery(name = "Aims.findByAimDescription",
	query = "SELECT a FROM Aims a WHERE a.aimDescription = :aimDescription"),
	@NamedQuery(name = "Aims.findByIsActive",
	query = "SELECT a FROM Aims a WHERE a.isActive = :isActive"),
	@NamedQuery(name = "Aims.findByCreatedDate",
	query = "SELECT a FROM Aims a WHERE a.createdDate = :createdDate"),
	@NamedQuery(name = "Aims.findByModifiedDate",
	query = "SELECT a FROM Aims a WHERE a.modifiedDate = :modifiedDate")})
public class Aims extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String aimDescription;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aimID", fetch = FetchType.LAZY)
	private List<InteractionServices> interactionServicesList;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(name="name")
	@Column(name="value")
	@CollectionTable(name="attributes", joinColumns=@JoinColumn(name="id"))
	private Map<String, String> attributes;
	
	public Aims() {

	}
	
	public Aims(Integer id) {
		
		this.id = id;
	}
	
	public Aims(Integer id, String aimDescription, boolean isActive, Date createdDate,
			Date modifiedDate) {
		
		this.id = id;
		this.aimDescription = aimDescription;
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
	
	public String getAimDescription() {
		
		return aimDescription;
	}
	
	public void setAimDescription(String aimDescription) {
		
		this.aimDescription = aimDescription;
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
	public List<InteractionServices> getInteractionServicesList() {
		
		return interactionServicesList;
	}
	
	public void setInteractionServicesList(List<InteractionServices> interactionServicesList) {
		
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
		if (!(object instanceof Aims)) {
			return false;
		}
		Aims other = (Aims) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
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
	
	@Override
	public String toString() {
		
		return aimDescription;
	}
	
	@Override
	public String getShortDescription() {
		
		return aimDescription;
	}
}
