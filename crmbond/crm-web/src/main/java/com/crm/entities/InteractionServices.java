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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abuzo
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "InteractionServices.findAll", query = "SELECT i FROM InteractionServices i"),
	@NamedQuery(name = "InteractionServices.findById",
	query = "SELECT i FROM InteractionServices i WHERE i.id = :id"),
	@NamedQuery(name = "InteractionServices.findByUserModified",
	query = "SELECT i FROM InteractionServices i WHERE i.userModified = :userModified"),
	@NamedQuery(name = "InteractionServices.findByPlace",
	query = "SELECT i FROM InteractionServices i WHERE i.place = :place"),
	@NamedQuery(name = "InteractionServices.findByDateStarted",
	query = "SELECT i FROM InteractionServices i WHERE i.dateStarted = :dateStarted"),
	@NamedQuery(name = "InteractionServices.findByDateFinished",
	query = "SELECT i FROM InteractionServices i WHERE i.dateFinished = :dateFinished"),
	@NamedQuery(name = "InteractionServices.findByStatus",
	query = "SELECT i FROM InteractionServices i WHERE i.status = :status"),
	@NamedQuery(name = "InteractionServices.findByPriority",
	query = "SELECT i FROM InteractionServices i WHERE i.priority = :priority"),
	@NamedQuery(name = "InteractionServices.findByContract",
	query = "SELECT i FROM InteractionServices i WHERE i.contract = :contract"),
	@NamedQuery(name = "InteractionServices.findByPrice",
	query = "SELECT i FROM InteractionServices i WHERE i.price = :price"),
	@NamedQuery(name = "InteractionServices.findByOtherCost",
	query = "SELECT i FROM InteractionServices i WHERE i.otherCost = :otherCost"),
	@NamedQuery(name = "InteractionServices.findByCurrency",
	query = "SELECT i FROM InteractionServices i WHERE i.currency = :currency"),
	@NamedQuery(name = "InteractionServices.findByExchangeRate",
	query = "SELECT i FROM InteractionServices i WHERE i.exchangeRate = :exchangeRate"),
	@NamedQuery(name = "InteractionServices.findByPeriod",
	query = "SELECT i FROM InteractionServices i WHERE i.period = :period"),
	@NamedQuery(name = "InteractionServices.findByUserCreated",
	query = "SELECT i FROM InteractionServices i WHERE i.userCreated = :userCreated"),
	@NamedQuery(name = "InteractionServices.findByIsActive",
	query = "SELECT i FROM InteractionServices i WHERE i.isActive = :isActive"),
	@NamedQuery(name = "InteractionServices.findByCreatedDate",
	query = "SELECT i FROM InteractionServices i WHERE i.createdDate = :createdDate"),
	@NamedQuery(name = "InteractionServices.findByModifiedDate",
	query = "SELECT i FROM InteractionServices i WHERE i.modifiedDate = :modifiedDate")})
public class InteractionServices extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int place;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStarted;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFinished;
	
	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(nullable = false)
	private String userDescription;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int status;
	
	@JoinColumn(name = "Priority", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Priorities priority;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private boolean contract;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private double price;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private double otherCost;
	
	@JoinColumn(name = "Currency", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Currency currency;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private double exchangeRate;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private double period;
	
	@JoinColumn(name = "CategoryID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private InteractionCategories categoryID;
	
	@JoinColumn(name = "ClientContactID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ContactClients clientContactID;
	
	@JoinColumn(name = "AimID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Aims aimID;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "interactionID", fetch = FetchType.EAGER)
	private List<Assigns> assignsList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "interactionID", fetch = FetchType.EAGER)
	private List<InteractionLogs> interactionLogs;

	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(name="name")
	@Column(name="value")
	@CollectionTable(name="interac_attributes", joinColumns=@JoinColumn(name="id"))
	private Map<String, String> attributes;
	
	public InteractionServices() {
		
	}
	
	public InteractionServices(Integer id) {
		
		this.id = id;
	}
	
	public InteractionServices(Integer id, int place, Date dateStarted, Date dateFinished,
			String userDescription, int status, boolean contract, double price, double otherCost,
			double exchangeRate, double period, boolean isActive, Date createdDate, Date modifiedDate) {
		
		this.id = id;
		this.place = place;
		this.dateStarted = dateStarted;
		this.dateFinished = dateFinished;
		this.userDescription = userDescription;
		this.status = status;
		this.contract = contract;
		this.price = price;
		this.otherCost = otherCost;
		this.exchangeRate = exchangeRate;
		this.period = period;
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
	
	
	public int getPlace() {
		
		return place;
	}
	
	public void setPlace(int place) {
		
		this.place = place;
	}
	
	public Date getDateStarted() {
		
		return dateStarted;
	}
	
	public void setDateStarted(Date dateStarted) {
		
		this.dateStarted = dateStarted;
	}
	
	public Date getDateFinished() {
		
		return dateFinished;
	}
	
	public void setDateFinished(Date dateFinished) {
		
		this.dateFinished = dateFinished;
	}
	
	public String getUserDescription() {
		
		return userDescription;
	}
	
	public void setUserDescription(String userDescription) {
		
		this.userDescription = userDescription;
	}
	
	public int getStatus() {
		
		return status;
	}
	
	public void setStatus(int status) {
		
		this.status = status;
	}
	
	public Priorities getPriority() {
		
		return priority;
	}
	
	public void setPriority(Priorities priority) {
		
		this.priority = priority;
	}
	
	public boolean getContract() {
		
		return contract;
	}
	
	public void setContract(boolean contract) {
		
		this.contract = contract;
	}
	
	public double getPrice() {
		
		return price;
	}
	
	public void setPrice(double price) {
		
		this.price = price;
	}
	
	public double getOtherCost() {
		
		return otherCost;
	}
	
	public void setOtherCost(double otherCost) {
		
		this.otherCost = otherCost;
	}
	
	public Currency getCurrency() {
		
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		
		this.currency = currency;
	}
	
	public double getExchangeRate() {
		
		return exchangeRate;
	}
	
	public void setExchangeRate(double exchangeRate) {
		
		this.exchangeRate = exchangeRate;
	}
	
	public double getPeriod() {
		
		return period;
	}
	
	public void setPeriod(double period) {
		
		this.period = period;
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
	
	public InteractionCategories getCategoryID() {
		
		return categoryID;
	}
	
	public void setCategoryID(InteractionCategories categoryID) {
		
		this.categoryID = categoryID;
	}
	
	/**
	 * @return the interactionLogs
	 */
	@XmlTransient
	public List<InteractionLogs> getInteractionLogs() {
		
		return interactionLogs;
	}
	
	/**
	 * @param interactionLogs the interactionLogs to set
	 */
	public void setInteractionLogs(List<InteractionLogs> interactionLogs) {
		
		this.interactionLogs = interactionLogs;
	}
	
	public ContactClients getClientContactID() {
		
		return clientContactID;
	}
	
	public void setClientContactID(ContactClients clientContactID) {
		
		this.clientContactID = clientContactID;
	}
	
	public Aims getAimID() {
		
		return aimID;
	}
	
	public void setAimID(Aims aimID) {
		
		this.aimID = aimID;
	}
	
	@XmlTransient
	public List<Assigns> getAssignsList() {
		
		return assignsList;
	}
	
	public void setAssignsList(List<Assigns> assignsList) {
		
		this.assignsList = assignsList;
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
		if (!(object instanceof InteractionServices)) {
			return false;
		}
		InteractionServices other = (InteractionServices) object;
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
		
		return "InteractionServices [userModified=" + ", period=" + period + ", isActive=" + isActive
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", categoryID="
				+ categoryID + ", clientContactID=" + clientContactID + ", aimID=" + aimID
				+ ", assignsList=" + assignsList + ", interactionLogs=" + interactionLogs + "]";
	}
	
	@Override
	public String getShortDescription() {
		
		return clientContactID.getShortDescription() + status;
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
	
}
