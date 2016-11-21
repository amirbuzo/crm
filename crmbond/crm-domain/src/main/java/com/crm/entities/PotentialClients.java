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
	@NamedQuery(name = "PotentialClients.findAll", query = "SELECT p FROM PotentialClients p"),
	@NamedQuery(name = "PotentialClients.findById",
	query = "SELECT p FROM PotentialClients p WHERE p.id = :id"),
	@NamedQuery(name = "PotentialClients.findByName",
	query = "SELECT p FROM PotentialClients p WHERE p.name = :name"),
	@NamedQuery(name = "PotentialClients.findByPhone",
	query = "SELECT p FROM PotentialClients p WHERE p.phone = :phone"),
	@NamedQuery(name = "PotentialClients.findByMobilePhone",
	query = "SELECT p FROM PotentialClients p WHERE p.mobilePhone = :mobilePhone"),
	@NamedQuery(name = "PotentialClients.findByPriority",
	query = "SELECT p FROM PotentialClients p WHERE p.priority = :priority"),
	@NamedQuery(name = "PotentialClients.findByAddress",
	query = "SELECT p FROM PotentialClients p WHERE p.address = :address"),
	@NamedQuery(name = "PotentialClients.findByEmail",
	query = "SELECT p FROM PotentialClients p WHERE p.email = :email"),
	@NamedQuery(name = "PotentialClients.findByInformation",
	query = "SELECT p FROM PotentialClients p WHERE p.information = :information"),
	@NamedQuery(name = "PotentialClients.findByStatus",
	query = "SELECT p FROM PotentialClients p WHERE p.status = :status"),
	@NamedQuery(name = "PotentialClients.findByUserCreated",
	query = "SELECT p FROM PotentialClients p WHERE p.userCreated = :userCreated"),
	@NamedQuery(name = "PotentialClients.findByIsActive",
	query = "SELECT p FROM PotentialClients p WHERE p.isActive = :isActive"),
	@NamedQuery(name = "PotentialClients.findByCreatedDate",
	query = "SELECT p FROM PotentialClients p WHERE p.createdDate = :createdDate"),
	@NamedQuery(name = "PotentialClients.findByModifiedDate",
	query = "SELECT p FROM PotentialClients p WHERE p.modifiedDate = :modifiedDate")})
public class PotentialClients extends AEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String name;

	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or
	// fax number consider using this annotation to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String phone;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String mobilePhone;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int priority;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String address;

	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using this annotation to
	// enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 70)
	@Column(nullable = false, length = 70)
	private String email;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1000)
	@Column(nullable = false, length = 1000)
	private String information;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int status;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "potentialClient", fetch = FetchType.EAGER)
	private List<PotentialContacts> potentialContactsList;

	public PotentialClients() {

	}

	public PotentialClients(Integer id) {

		this.id = id;
	}

	public PotentialClients(Integer id, String name, String phone, String mobilePhone, int priority,
			String address, String email, String information, int status, boolean isActive,
			Date createdDate, Date modifiedDate) {

		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.priority = priority;
		this.address = address;
		this.email = email;
		this.information = information;
		this.status = status;
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

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getPhone() {

		return phone;
	}

	public void setPhone(String phone) {

		this.phone = phone;
	}

	public String getMobilePhone() {

		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {

		this.mobilePhone = mobilePhone;
	}

	public int getPriority() {

		return priority;
	}

	public void setPriority(int priority) {

		this.priority = priority;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getInformation() {

		return information;
	}

	public void setInformation(String information) {

		this.information = information;
	}

	public int getStatus() {

		return status;
	}

	public void setStatus(int status) {

		this.status = status;
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
	public List<PotentialContacts> getPotentialContactsList() {

		return potentialContactsList;
	}

	public void setPotentialContactsList(List<PotentialContacts> potentialContactsList) {

		this.potentialContactsList = potentialContactsList;
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
		if (!(object instanceof PotentialClients)) {
			return false;
		}
		PotentialClients other = (PotentialClients) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "com.crm.entities.PotentialClients[ id=" + id + " ]";
	}

	@Override
	public String getShortDescription() {

		// TODO Auto-generated method stub
		return getName();
	}
}
