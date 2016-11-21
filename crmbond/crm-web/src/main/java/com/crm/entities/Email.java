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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findById", query = "SELECT e FROM Email e WHERE e.id = :id"),
    @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email"),
    @NamedQuery(name = "Email.findByPassword",
        query = "SELECT e FROM Email e WHERE e.password = :password"),
    @NamedQuery(name = "Email.findByIsActive",
        query = "SELECT e FROM Email e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "Email.findByCreatedDate",
        query = "SELECT e FROM Email e WHERE e.createdDate = :createdDate"),
    @NamedQuery(name = "Email.findByModifiedDate",
        query = "SELECT e FROM Email e WHERE e.modifiedDate = :modifiedDate")})
public class Email extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using this annotation to
	// enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(nullable = false, length = 200)
	private String email;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(nullable = false, length = 200)
	private String password;
	
	public Email() {
	
	}
	
	public Email(Integer id) {
	
		this.id = id;
	}
	
	public Email(Integer id, String email, String password, boolean isActive, Date createdDate,
	    Date modifiedDate) {
	
		this.id = id;
		this.email = email;
		this.password = password;
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
	
	public String getEmail() {
	
		return email;
	}
	
	public void setEmail(String email) {
	
		this.email = email;
	}
	
	public String getPassword() {
	
		return password;
	}
	
	public void setPassword(String password) {
	
		this.password = password;
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
	
	@Override
	public int hashCode() {
	
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
	
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Email)) {
			return false;
		}
		Email other = (Email) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
	
		return "com.crm.entities.Email[ id=" + id + " ]";
	}
	
	@Override
	public String getShortDescription() {
	
		return email;
	}
}
