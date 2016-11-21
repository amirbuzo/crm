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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	@NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
	@NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
	@NamedQuery(name = "Clients.findByClientName",
	query = "SELECT c FROM Clients c WHERE c.clientName = :clientName"),
	@NamedQuery(name = "Clients.findByLegalStatus",
	query = "SELECT c FROM Clients c WHERE c.legalStatus = :legalStatus"),
	@NamedQuery(name = "Clients.findByPhone",
	query = "SELECT c FROM Clients c WHERE c.phone = :phone"),
	@NamedQuery(name = "Clients.findByMobilePhone",
	query = "SELECT c FROM Clients c WHERE c.mobilePhone = :mobilePhone"),
	@NamedQuery(name = "Clients.findByAdministrator",
	query = "SELECT c FROM Clients c WHERE c.administrator = :administrator"),
	@NamedQuery(name = "Clients.findByNipt", query = "SELECT c FROM Clients c WHERE c.nipt = :nipt"),
	@NamedQuery(name = "Clients.findByClientSinceDate",
	query = "SELECT c FROM Clients c WHERE c.clientSinceDate = :clientSinceDate"),
	@NamedQuery(name = "Clients.findByFax", query = "SELECT c FROM Clients c WHERE c.fax = :fax"),
	@NamedQuery(name = "Clients.findByAddress",
	query = "SELECT c FROM Clients c WHERE c.address = :address"),
	@NamedQuery(name = "Clients.findByEmail",
	query = "SELECT c FROM Clients c WHERE c.email = :email"),
	@NamedQuery(name = "Clients.findByWebsite",
	query = "SELECT c FROM Clients c WHERE c.website = :website"),
	@NamedQuery(name = "Clients.findByCity", query = "SELECT c FROM Clients c WHERE c.city = :city"),
	@NamedQuery(name = "Clients.findByNumberOfEmployee",
	query = "SELECT c FROM Clients c WHERE c.numberOfEmployee = :numberOfEmployee"),
	@NamedQuery(name = "Clients.findByStatus",
	query = "SELECT c FROM Clients c WHERE c.status = :status"),
	@NamedQuery(name = "Clients.findByUserIDAssistent",
	query = "SELECT c FROM Clients c WHERE c.userIDAssistent = :userIDAssistent"),
	@NamedQuery(name = "Clients.findByUserModified",
	query = "SELECT c FROM Clients c WHERE c.userModified = :userModified"),
	@NamedQuery(name = "Clients.findByUserCreated",
	query = "SELECT c FROM Clients c WHERE c.userCreated = :userCreated"),
	@NamedQuery(name = "Clients.findByIsActive",
	query = "SELECT c FROM Clients c WHERE c.isActive = :isActive"),
	@NamedQuery(name = "Clients.findByCreatedDate",
	query = "SELECT c FROM Clients c WHERE c.createdDate = :createdDate"),
	@NamedQuery(name = "Clients.findByModifiedDate",
	query = "SELECT c FROM Clients c WHERE c.modifiedDate = :modifiedDate")})
public class Clients extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String clientName;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String legalStatus;
	
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
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String administrator;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String nipt;
	
	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(nullable = false)
	private String otherInformation;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date clientSinceDate;
	
	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or
	// fax number consider using this annotation to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String fax;
	
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
	@Size(min = 1, max = 80)
	@Column(nullable = false, length = 80)
	private String website;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int city;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int numberOfEmployee;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int status;
	
	@JoinColumn(name = "userIDAssistent", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Users userIDAssistent;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID", fetch = FetchType.EAGER)
	private List<ContactClients> contactClientsList;
	
	@JoinColumn(name = "Priority", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Priorities priority;
	
	@JoinColumn(name = "BussinessType", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private BussinessTypes bussinessType;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(name="name")
	@Column(name="value")
	@CollectionTable(name="client_attributes", joinColumns=@JoinColumn(name="id"))
	private Map<String, String> attributes;

	public Clients() {
		
	}
	
	public Clients(Integer id) {
		
		this.id = id;
	}
	
	public Clients(Integer id, String clientName, String legalStatus, String phone,
			String mobilePhone, String administrator, String nipt, String otherInformation,
			Date clientSinceDate, String fax, String address, String email, String website, int city,
			int numberOfEmployee, int status, boolean isActive, Date createdDate, Date modifiedDate) {
		
		this.id = id;
		this.clientName = clientName;
		this.legalStatus = legalStatus;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.administrator = administrator;
		this.nipt = nipt;
		this.otherInformation = otherInformation;
		this.clientSinceDate = clientSinceDate;
		this.fax = fax;
		this.address = address;
		this.email = email;
		this.website = website;
		this.city = city;
		this.numberOfEmployee = numberOfEmployee;
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
	
	public String getClientName() {
		
		return clientName;
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
	
	public void setClientName(String clientName) {
		
		this.clientName = clientName;
	}
	
	public String getLegalStatus() {
		
		return legalStatus;
	}
	
	public void setLegalStatus(String legalStatus) {
		
		this.legalStatus = legalStatus;
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
	
	public String getAdministrator() {
		
		return administrator;
	}
	
	public void setAdministrator(String administrator) {
		
		this.administrator = administrator;
	}
	
	public String getNipt() {
		
		return nipt;
	}
	
	public void setNipt(String nipt) {
		
		this.nipt = nipt;
	}
	
	public String getOtherInformation() {
		
		return otherInformation;
	}
	
	public void setOtherInformation(String otherInformation) {
		
		this.otherInformation = otherInformation;
	}
	
	public Date getClientSinceDate() {
		
		return clientSinceDate;
	}
	
	public void setClientSinceDate(Date clientSinceDate) {
		
		this.clientSinceDate = clientSinceDate;
	}
	
	public String getFax() {
		
		return fax;
	}
	
	public void setFax(String fax) {
		
		this.fax = fax;
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
	
	public String getWebsite() {
		
		return website;
	}
	
	public void setWebsite(String website) {
		
		this.website = website;
	}
	
	public int getCity() {
		
		return city;
	}
	
	public void setCity(int city) {
		
		this.city = city;
	}
	
	public int getNumberOfEmployee() {
		
		return numberOfEmployee;
	}
	
	public void setNumberOfEmployee(int numberOfEmployee) {
		
		this.numberOfEmployee = numberOfEmployee;
	}
	
	public int getStatus() {
		
		return status;
	}
	
	public void setStatus(int status) {
		
		this.status = status;
	}
	
	public Users getUserIDAssistent() {
		
		return userIDAssistent;
	}
	
	public void setUserIDAssistent(Users userIDAssistent) {
		
		this.userIDAssistent = userIDAssistent;
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
	public List<ContactClients> getContactClientsList() {
		
		return contactClientsList;
	}
	
	public void setContactClientsList(List<ContactClients> contactClientsList) {
		
		this.contactClientsList = contactClientsList;
	}
	
	public Priorities getPriority() {
		
		return priority;
	}
	
	public void setPriority(Priorities priority) {
		
		this.priority = priority;
	}
	
	public BussinessTypes getBussinessType() {
		
		return bussinessType;
	}
	
	public void setBussinessType(BussinessTypes bussinessType) {
		
		this.bussinessType = bussinessType;
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
		if (!(object instanceof Clients)) {
			return false;
		}
		Clients other = (Clients) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Clients [clientName=" + clientName + ", legalStatus=" + legalStatus + ", phone="
				+ phone + ", mobilePhone=" + mobilePhone + ", administrator=" + administrator + ", nipt="
				+ nipt + ", otherInformation=" + otherInformation + ", clientSinceDate=" + clientSinceDate
				+ ", fax=" + fax + ", address=" + address + ", email=" + email + ", website=" + website
				+ ", city=" + city + ", numberOfEmployee=" + numberOfEmployee + ", status=" + status
				+ ", userIDAssistent=" + userIDAssistent + ", userModified=" + userModified
				+ ", userCreated=" + userCreated + ", contactClientsList=" + contactClientsList
				+ ", priority=" + priority + ", bussinessType=" + bussinessType + "]";
	}
	
	@Override
	public String getShortDescription() {
		
		return clientName + "-" + nipt;
	}
}
