/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requests.findAll", query = "SELECT r FROM Requests r"),
    @NamedQuery(name = "Requests.findById", query = "SELECT r FROM Requests r WHERE r.id = :id"),
    @NamedQuery(name = "Requests.findByClientContactID",
        query = "SELECT r FROM Requests r WHERE r.clientContactID = :clientContactID"),
    @NamedQuery(name = "Requests.findByUserID",
        query = "SELECT r FROM Requests r WHERE r.userID = :userID"),
    @NamedQuery(name = "Requests.findByStatus",
        query = "SELECT r FROM Requests r WHERE r.status = :status"),
    @NamedQuery(name = "Requests.findByPriority",
        query = "SELECT r FROM Requests r WHERE r.priority = :priority"),
    @NamedQuery(name = "Requests.findByIsActive",
        query = "SELECT r FROM Requests r WHERE r.isActive = :isActive"),
    @NamedQuery(name = "Requests.findByCreatedDate",
        query = "SELECT r FROM Requests r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "Requests.findByModifiedDate",
        query = "SELECT r FROM Requests r WHERE r.modifiedDate = :modifiedDate")})
public class Requests extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int clientContactID;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int userID;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int status;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int priority;
	
	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(nullable = false)
	private String description;
	
	@JoinColumn(name = "ClaimID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Claims claimID;
	
	public Requests() {
	
	}
	
	public Requests(Integer id) {
	
		this.id = id;
	}
	
	public Requests(Integer id, int clientContactID, int userID, int status, int priority,
	    String description, boolean isActive, Date createdDate, Date modifiedDate) {
	
		this.id = id;
		this.clientContactID = clientContactID;
		this.userID = userID;
		this.status = status;
		this.priority = priority;
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
	
	public int getClientContactID() {
	
		return clientContactID;
	}
	
	public void setClientContactID(int clientContactID) {
	
		this.clientContactID = clientContactID;
	}
	
	public int getUserID() {
	
		return userID;
	}
	
	public void setUserID(int userID) {
	
		this.userID = userID;
	}
	
	public int getStatus() {
	
		return status;
	}
	
	public void setStatus(int status) {
	
		this.status = status;
	}
	
	public int getPriority() {
	
		return priority;
	}
	
	public void setPriority(int priority) {
	
		this.priority = priority;
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
	
	public Claims getClaimID() {
	
		return claimID;
	}
	
	public void setClaimID(Claims claimID) {
	
		this.claimID = claimID;
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
		if (!(object instanceof Requests)) {
			return false;
		}
		Requests other = (Requests) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return "com.crm.entities.Requests[ id=" + id + " ]";
	}
	
	@Override
	public String getShortDescription() {
	
		// TODO Auto-generated method stub
		return description;
	}
}
