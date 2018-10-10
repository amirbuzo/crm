package com.crm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * Interface for all JPA entities to implement.
 *
 * @author Ignas
 *
 */
@MappedSuperclass
public abstract class AEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * All entities must have an ID field.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	protected Integer id;

	@Version
	private long version;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@Basic(optional = false)
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedDate;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	protected boolean isActive = true;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	protected Integer userCreated;
	
	@Basic(optional = true)
	@Column(nullable = true)
	protected Integer userModified;

	public abstract Integer getId();

	@Override
	public abstract boolean equals(Object object);

	public abstract String getShortDescription();

	@Override
	public abstract int hashCode();

	public abstract void setId(Integer id);

	/**
	 * @return the version
	 */
	public long getVersion() {

		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(long version) {

		this.version = version;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {

		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {

		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {

		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {

		this.modifiedDate = modifiedDate;
	}

	public boolean getIsActive() {

		return isActive;
	}

	public void setIsActive(boolean isActive) {

		this.isActive = isActive;
	}

	public Integer getUserCreated() {

		return userCreated;
	}

	public void setUserCreated(Integer userCreated) {

		this.userCreated = userCreated;
	}


	
	/**
	 * @return the userModified
	 */
	public Integer getUserModified() {
		
		return userModified;
	}


	
	/**
	 * @param userModified the userModified to set
	 */
	public void setUserModified(Integer userModified) {
		
		this.userModified = userModified;
	}


	
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		
		this.isActive = isActive;
	}



}
