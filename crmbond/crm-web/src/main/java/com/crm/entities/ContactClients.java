/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ContactClients.findAll", query = "SELECT c FROM ContactClients c"),
	@NamedQuery(name = "ContactClients.findById",
	query = "SELECT c FROM ContactClients c WHERE c.id = :id"),
	@NamedQuery(name = "ContactClients.findByName",
	query = "SELECT c FROM ContactClients c WHERE c.name = :name"),
	@NamedQuery(name = "ContactClients.findBySurname",
	query = "SELECT c FROM ContactClients c WHERE c.surname = :surname"),
	@NamedQuery(name = "ContactClients.findByPosition",
	query = "SELECT c FROM ContactClients c WHERE c.position = :position"),
	@NamedQuery(name = "ContactClients.findByDepartament",
	query = "SELECT c FROM ContactClients c WHERE c.departament = :departament"),
	@NamedQuery(name = "ContactClients.findByEmail",
	query = "SELECT c FROM ContactClients c WHERE c.email = :email"),
	@NamedQuery(name = "ContactClients.findByOfficeAddress",
	query = "SELECT c FROM ContactClients c WHERE c.officeAddress = :officeAddress"),
	@NamedQuery(name = "ContactClients.findByOfficeNumber",
	query = "SELECT c FROM ContactClients c WHERE c.officeNumber = :officeNumber"),
	@NamedQuery(name = "ContactClients.findByMobilePhone",
	query = "SELECT c FROM ContactClients c WHERE c.mobilePhone = :mobilePhone"),
	@NamedQuery(name = "ContactClients.findByFax",
	query = "SELECT c FROM ContactClients c WHERE c.fax = :fax"),
	@NamedQuery(name = "ContactClients.findByUserModified",
	query = "SELECT c FROM ContactClients c WHERE c.userModified = :userModified"),
	@NamedQuery(name = "ContactClients.findByUserCreated",
	query = "SELECT c FROM ContactClients c WHERE c.userCreated = :userCreated"),
	@NamedQuery(name = "ContactClients.findByIsActive",
	query = "SELECT c FROM ContactClients c WHERE c.isActive = :isActive"),
	@NamedQuery(name = "ContactClients.findByCreatedDate",
	query = "SELECT c FROM ContactClients c WHERE c.createdDate = :createdDate"),
	@NamedQuery(name = "ContactClients.findByModifiedDate",
	query = "SELECT c FROM ContactClients c WHERE c.modifiedDate = :modifiedDate")})
public class ContactClients extends AEntity implements Serializable {
	
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
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String position;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String departament;
	
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider using this annotation to
	// enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String email;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String officeAddress;
	
	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(nullable = false)
	private String information;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String officeNumber;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String mobilePhone;
	
	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or
	// fax number consider using this annotation to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = false, length = 100)
	private String fax;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientContactID", fetch = FetchType.LAZY)
	private List<InteractionServices> interactionServicesList;
	
	@JoinColumn(name = "ClientID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Clients clientID;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(name="name")
	@Column(name="value")
	@CollectionTable(name="contact_attributes", joinColumns=@JoinColumn(name="id"))
	private Map<String, String> attributes;
	
	public ContactClients() {
		
	}
	
	public ContactClients(Integer id) {
		
		this.id = id;
	}
	
	public ContactClients(Integer id, String name, String surname, String position,
			String departament, String email, String officeAddress, String information,
			String officeNumber, String mobilePhone, String fax, boolean isActive, Date createdDate,
			Date modifiedDate) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.departament = departament;
		this.email = email;
		this.officeAddress = officeAddress;
		this.information = information;
		this.officeNumber = officeNumber;
		this.mobilePhone = mobilePhone;
		this.fax = fax;
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
	
	public String getPosition() {
		
		return position;
	}
	
	public void setPosition(String position) {
		
		this.position = position;
	}
	
	public String getDepartament() {
		
		return departament;
	}
	
	public void setDepartament(String departament) {
		
		this.departament = departament;
	}
	
	public String getEmail() {
		
		return email;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	public String getOfficeAddress() {
		
		return officeAddress;
	}
	
	public void setOfficeAddress(String officeAddress) {
		
		this.officeAddress = officeAddress;
	}
	
	public String getInformation() {
		
		return information;
	}
	
	public void setInformation(String information) {
		
		this.information = information;
	}
	
	public String getOfficeNumber() {
		
		return officeNumber;
	}
	
	public void setOfficeNumber(String officeNumber) {
		
		this.officeNumber = officeNumber;
	}
	
	public String getMobilePhone() {
		
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobilePhone) {
		
		this.mobilePhone = mobilePhone;
	}
	
	public String getFax() {
		
		return fax;
	}
	
	public void setFax(String fax) {
		
		this.fax = fax;
	}
	
	@Override
	public Integer getUserModified() {
		
		return userModified;
	}
	
	@Override
	public void setUserModified(Integer userModified) {
		
		this.userModified = userModified;
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
	
	public Clients getClientID() {
		
		return clientID;
	}
	
	public void setClientID(Clients clientID) {
		
		this.clientID = clientID;
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
		if (!(object instanceof ContactClients)) {
			return false;
		}
		ContactClients other = (ContactClients) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		
		return name + " " + surname + "-" + clientID.getClientName();
	}
	
	@Override
	public String getShortDescription() {
		
		return name + " " + surname + "-" + getClientID().getClientName();
	}
}
