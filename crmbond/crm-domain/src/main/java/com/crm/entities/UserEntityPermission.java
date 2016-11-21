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
    @NamedQuery(name = "UserEntityPermission.findAll",
        query = "SELECT u FROM UserEntityPermission u"),
    @NamedQuery(name = "UserEntityPermission.findById",
        query = "SELECT u FROM UserEntityPermission u WHERE u.id = :id"),
    @NamedQuery(name = "UserEntityPermission.findByUserRefID",
        query = "SELECT u FROM UserEntityPermission u WHERE u.userRefID = :userRefID"),
    @NamedQuery(name = "UserEntityPermission.findByEntityType",
        query = "SELECT u FROM UserEntityPermission u WHERE u.entityType = :entityType"),
    @NamedQuery(name = "UserEntityPermission.findByEntityID",
        query = "SELECT u FROM UserEntityPermission u WHERE u.entityID = :entityID"),
    @NamedQuery(name = "UserEntityPermission.findByUserID",
        query = "SELECT u FROM UserEntityPermission u WHERE u.userID = :userID"),
    @NamedQuery(name = "UserEntityPermission.findByCreatedDate",
        query = "SELECT u FROM UserEntityPermission u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserEntityPermission.findByModifiedDate",
        query = "SELECT u FROM UserEntityPermission u WHERE u.modifiedDate = :modifiedDate")})
public class UserEntityPermission extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int userRefID;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int entityType;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int entityID;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int userID;
	
	public UserEntityPermission() {
	
	}
	
	public UserEntityPermission(Integer id) {
	
		this.id = id;
	}
	
	public UserEntityPermission(Integer id, int userRefID, int entityType, int entityID, int userID,
	    Date cDate, Date lastUpdate) {
	
		this.id = id;
		this.userRefID = userRefID;
		this.entityType = entityType;
		this.entityID = entityID;
		this.userID = userID;
		this.createdDate = cDate;
		this.modifiedDate = lastUpdate;
	}
	
	@Override
	public Integer getId() {
	
		return id;
	}
	
	@Override
	public void setId(Integer id) {
	
		this.id = id;
	}
	
	public int getUserRefID() {
	
		return userRefID;
	}
	
	public void setUserRefID(int userRefID) {
	
		this.userRefID = userRefID;
	}
	
	public int getEntityType() {
	
		return entityType;
	}
	
	public void setEntityType(int entityType) {
	
		this.entityType = entityType;
	}
	
	public int getEntityID() {
	
		return entityID;
	}
	
	public void setEntityID(int entityID) {
	
		this.entityID = entityID;
	}
	
	public int getUserID() {
	
		return userID;
	}
	
	public void setUserID(int userID) {
	
		this.userID = userID;
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
		if (!(object instanceof UserEntityPermission)) {
			return false;
		}
		UserEntityPermission other = (UserEntityPermission) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return "com.crm.entities.UserEntityPermission[ id=" + id + " ]";
	}
	
	@Override
	public String getShortDescription() {
	
		// TODO Auto-generated method stub
		return null;
	}
}
