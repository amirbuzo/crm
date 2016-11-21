/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
	@NamedQuery(name = "UserRights.findAll", query = "SELECT u FROM UserRights u"),
	@NamedQuery(name = "UserRights.findById", query = "SELECT u FROM UserRights u WHERE u.id = :id"),
	@NamedQuery(name = "UserRights.findByName",
	query = "SELECT u FROM UserRights u WHERE u.name = :name"),
	@NamedQuery(name = "UserRights.findByDescription",
	query = "SELECT u FROM UserRights u WHERE u.description = :description"),
	@NamedQuery(name = "UserRights.findByModuleID",
	query = "SELECT u FROM UserRights u WHERE u.roleID = :roleID")})
public class UserRights extends AEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String name;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(nullable = false, length = 200)
	private String description;

	@XmlTransient
	@JoinColumn(name = "RoleID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Roles roleID;

	public UserRights() {

	}

	public UserRights(Integer id) {

		this.id = id;
	}

	public UserRights(Integer id, String name, String description) {

		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public Integer getId() {

		return id;
	}

	@Override
	public void setId(Integer id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public Roles getRoleID() {

		return roleID;
	}

	public void setRoleID(Roles roleID) {

		this.roleID = roleID;
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
		if (!(object instanceof UserRights)) {
			return false;
		}
		UserRights other = (UserRights) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "com.crm.entities.UserRights[ id=" + id + " ]";
	}

	@Override
	public String getShortDescription() {

		// TODO Auto-generated method stub
		return name;
	}
}
