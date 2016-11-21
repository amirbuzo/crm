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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PotentialContacts.findAll", query = "SELECT p FROM PotentialContacts p"),
	@NamedQuery(name = "PotentialContacts.findById",
	query = "SELECT p FROM PotentialContacts p WHERE p.id = :id"),
	@NamedQuery(name = "PotentialContacts.findByName",
	query = "SELECT p FROM PotentialContacts p WHERE p.name = :name"),
	@NamedQuery(name = "PotentialContacts.findBySurname",
	query = "SELECT p FROM PotentialContacts p WHERE p.surname = :surname"),
	@NamedQuery(name = "PotentialContacts.findByPhone",
	query = "SELECT p FROM PotentialContacts p WHERE p.phone = :phone"),
	@NamedQuery(name = "PotentialContacts.findByMobilePhone",
	query = "SELECT p FROM PotentialContacts p WHERE p.mobilePhone = :mobilePhone"),
	@NamedQuery(name = "PotentialContacts.findByEmail",
	query = "SELECT p FROM PotentialContacts p WHERE p.email = :email"),
	@NamedQuery(name = "PotentialContacts.findByPriority",
	query = "SELECT p FROM PotentialContacts p WHERE p.priority = :priority"),
	@NamedQuery(name = "PotentialContacts.findByAddress",
	query = "SELECT p FROM PotentialContacts p WHERE p.address = :address"),
	@NamedQuery(name = "PotentialContacts.findByUserAssign",
	query = "SELECT p FROM PotentialContacts p WHERE p.userAssign = :userAssign"),
	@NamedQuery(name = "PotentialContacts.findByUserCreated",
	query = "SELECT p FROM PotentialContacts p WHERE p.userCreated = :userCreated"),
	@NamedQuery(name = "PotentialContacts.findByStatus",
	query = "SELECT p FROM PotentialContacts p WHERE p.status = :status"),
	@NamedQuery(name = "PotentialContacts.findByIsActive",
	query = "SELECT p FROM PotentialContacts p WHERE p.isActive = :isActive"),
	@NamedQuery(name = "PotentialContacts.findByCreatedDate",
	query = "SELECT p FROM PotentialContacts p WHERE p.createdDate = :createdDate"),
	@NamedQuery(name = "PotentialContacts.findByModifiedDate",
	query = "SELECT p FROM PotentialContacts p WHERE p.modifiedDate = :modifiedDate")})
public class PotentialContacts extends AEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String name;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String surname;

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
	@Column(nullable = false)
	private int priority;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String address;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int userAssign;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(nullable = false)
	private String information;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int status;

	@JoinColumn(name = "Referenca", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private References referenca;

	@JoinColumn(name = "Category", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PotentialContactCategories category;

	@JoinColumn(name = "PotentialClient", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PotentialClients potentialClient;

	public PotentialContacts() {

	}

	public PotentialContacts(Integer id) {

		this.id = id;
	}

	public PotentialContacts(Integer id, String name, String surname, String phone,
			String mobilePhone, String email, int priority, String address, int userAssign,
			String information, int status, boolean isActive, Date createdDate, Date modifiedDate) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.priority = priority;
		this.address = address;
		this.userAssign = userAssign;
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

	public String getSurname() {

		return surname;
	}

	public void setSurname(String surname) {

		this.surname = surname;
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

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
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

	public int getUserAssign() {

		return userAssign;
	}

	public void setUserAssign(int userAssign) {

		this.userAssign = userAssign;
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

	public References getReferenca() {

		return referenca;
	}

	public void setReferenca(References referenca) {

		this.referenca = referenca;
	}

	public PotentialContactCategories getCategory() {

		return category;
	}

	public void setCategory(PotentialContactCategories category) {

		this.category = category;
	}

	public PotentialClients getPotentialClient() {

		return potentialClient;
	}

	public void setPotentialClient(PotentialClients potentialClient) {

		this.potentialClient = potentialClient;
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
		if (!(object instanceof PotentialContacts)) {
			return false;
		}
		PotentialContacts other = (PotentialContacts) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "com.crm.entities.PotentialContacts[ id=" + id + " ]";
	}

	@Override
	public String getShortDescription() {

		// TODO Auto-generated method stub
		return name;
	}
}
