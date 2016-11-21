/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Contracts.findAll", query = "SELECT c FROM Contracts c"),
	@NamedQuery(name = "Contracts.findById", query = "SELECT c FROM Contracts c WHERE c.id = :id"),
	@NamedQuery(name = "Contracts.findByClientID",
	query = "SELECT c FROM Contracts c WHERE c.clientID = :clientID"),
	@NamedQuery(name = "Contracts.findByDateStarted",
	query = "SELECT c FROM Contracts c WHERE c.dateStarted = :dateStarted"),
	@NamedQuery(name = "Contracts.findByDateFinished",
	query = "SELECT c FROM Contracts c WHERE c.dateFinished = :dateFinished"),
	@NamedQuery(name = "Contracts.findByStatus",
	query = "SELECT c FROM Contracts c WHERE c.status = :status"),
	@NamedQuery(name = "Contracts.findByContractValue",
	query = "SELECT c FROM Contracts c WHERE c.contractValue = :contractValue"),
	@NamedQuery(name = "Contracts.findByExchangeRate",
	query = "SELECT c FROM Contracts c WHERE c.exchangeRate = :exchangeRate"),
	@NamedQuery(name = "Contracts.findByContractDate",
	query = "SELECT c FROM Contracts c WHERE c.contractDate = :contractDate"),
	@NamedQuery(name = "Contracts.findByClientSign",
	query = "SELECT c FROM Contracts c WHERE c.clientSign = :clientSign"),
	@NamedQuery(name = "Contracts.findByCompanySign",
	query = "SELECT c FROM Contracts c WHERE c.companySign = :companySign"),
	@NamedQuery(name = "Contracts.findByUserModified",
	query = "SELECT c FROM Contracts c WHERE c.userModified = :userModified"),
	@NamedQuery(name = "Contracts.findByUserCreated",
	query = "SELECT c FROM Contracts c WHERE c.userCreated = :userCreated"),
	@NamedQuery(name = "Contracts.findByIsActive",
	query = "SELECT c FROM Contracts c WHERE c.isActive = :isActive"),
	@NamedQuery(name = "Contracts.findByCreatedDate",
	query = "SELECT c FROM Contracts c WHERE c.createdDate = :createdDate"),
	@NamedQuery(name = "Contracts.findByModifiedDate",
	query = "SELECT c FROM Contracts c WHERE c.modifiedDate = :modifiedDate")})
public class Contracts extends AEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int clientID;

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
	@Column(nullable = false)
	private int status;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
	// annotations to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false, precision = 19, scale = 4)
	private BigDecimal contractValue;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private double exchangeRate;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(nullable = false)
	private String information="";

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date contractDate;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int clientSign;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int companySign;


	@JoinColumn(name = "Currency", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Currency currency;

	@JoinColumn(name = "Type", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ContractTypes type;
	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(name="name")
	@Column(name="value")
	@CollectionTable(name="contract_attributes", joinColumns=@JoinColumn(name="id"))
	private Map<String, String> attributes;
	public Contracts() {

	}

	public Contracts(Integer id) {

		this.id = id;
	}

	public Contracts(Integer id, int clientID, Date dateStarted, Date dateFinished, int status,
			BigDecimal contractValue, double exchangeRate, String information, Date contractDate,
			int clientSign, int companySign, int userModified, boolean isActive, Date createdDate,
			Date modifiedDate) {

		this.id = id;
		this.clientID = clientID;
		this.dateStarted = dateStarted;
		this.dateFinished = dateFinished;
		this.status = status;
		this.contractValue = contractValue;
		this.exchangeRate = exchangeRate;
		this.information = information;
		this.contractDate = contractDate;
		this.clientSign = clientSign;
		this.companySign = companySign;
		this.userModified = userModified;
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

	public int getClientID() {

		return clientID;
	}

	public void setClientID(int clientID) {

		this.clientID = clientID;
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

	public int getStatus() {

		return status;
	}

	public void setStatus(int status) {

		this.status = status;
	}

	public BigDecimal getContractValue() {

		return contractValue;
	}

	public void setContractValue(BigDecimal contractValue) {

		this.contractValue = contractValue;
	}

	public double getExchangeRate() {

		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {

		this.exchangeRate = exchangeRate;
	}

	public String getInformation() {

		return information;
	}

	public void setInformation(String information) {

		this.information = information;
	}

	public Date getContractDate() {

		return contractDate;
	}

	public void setContractDate(Date contractDate) {

		this.contractDate = contractDate;
	}

	public int getClientSign() {

		return clientSign;
	}

	public void setClientSign(int clientSign) {

		this.clientSign = clientSign;
	}

	public int getCompanySign() {

		return companySign;
	}

	public void setCompanySign(int companySign) {

		this.companySign = companySign;
	}
	

	public void setUserModified(int userModified) {

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

	public Currency getCurrency() {

		return currency;
	}

	public void setCurrency(Currency currency) {

		this.currency = currency;
	}

	public ContractTypes getType() {

		return type;
	}

	public void setType(ContractTypes type) {

		this.type = type;
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
		if (!(object instanceof Contracts)) {
			return false;
		}
		Contracts other = (Contracts) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "com.crm.entities.Contracts[ id=" + id + " ]";
	}

	@Override
	public String getShortDescription() {

		return information + " " + companySign + "-" + clientID;
	}
	

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {

		return serialVersionUID;
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
