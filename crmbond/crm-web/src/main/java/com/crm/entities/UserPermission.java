package com.crm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abuzo
 */
@Entity
@Table(name = "UserPermission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPermission.findAll", query = "SELECT u FROM UserPermission u"),
    @NamedQuery(name = "UserPermission.findById",
        query = "SELECT u FROM UserPermission u WHERE u.id = :id"),
    @NamedQuery(name = "UserPermission.findByRightRefID",
        query = "SELECT u FROM UserPermission u WHERE u.rightRefID = :rightRefID"),
    @NamedQuery(name = "UserPermission.findByReadRight",
        query = "SELECT u FROM UserPermission u WHERE u.readRight = :readRight"),
    @NamedQuery(name = "UserPermission.findByWriteRight",
        query = "SELECT u FROM UserPermission u WHERE u.writeRight = :writeRight"),
    @NamedQuery(name = "UserPermission.findByExecuteRight",
        query = "SELECT u FROM UserPermission u WHERE u.executeRight = :executeRight"),
    @NamedQuery(name = "UserPermission.findByCreatedDate",
        query = "SELECT u FROM UserPermission u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserPermission.findByModifiedDate",
        query = "SELECT u FROM UserPermission u WHERE u.modifiedDate = :modifiedDate")})
public class UserPermission extends AEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "ReadRight")
	private boolean readRight;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "WriteRight")
	private boolean writeRight;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "ExecuteRight")
	private boolean executeRight;
	
	@JoinColumn(name = "UserRefID", referencedColumnName = "ID")
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	private Users userRefID;
	
	@JoinColumn(name = "RightRefID", referencedColumnName = "ID")
	@ManyToOne(cascade = CascadeType.MERGE, optional = false, fetch = FetchType.EAGER)
	private UserRights rightRefID;
	
	public UserPermission() {
	
	}
	
	public UserPermission(Integer id) {
	
		this.id = id;
	}
	
	public UserPermission(Users userID, UserRights rightReferenceID, boolean readRight,
	    boolean writeRight, boolean executeRight, Date createdDate, Date modifiedDate) {
	
		this.userRefID = userID;
		this.rightRefID = rightReferenceID;
		this.readRight = readRight;
		this.writeRight = writeRight;
		this.executeRight = executeRight;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	public UserPermission(UserRights rightReferenceID, boolean readRight, boolean writeRight,
	    boolean executeRight, Date createdDate, Date modifiedDate, int deleted) {
	
		this.rightRefID = rightReferenceID;
		this.readRight = readRight;
		this.writeRight = writeRight;
		this.executeRight = executeRight;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	public boolean getReadRight() {
	
		return readRight;
	}
	
	public void setReadRight(boolean readRight) {
	
		this.readRight = readRight;
	}
	
	public boolean getWriteRight() {
	
		return writeRight;
	}
	
	public void setWriteRight(boolean writeRight) {
	
		this.writeRight = writeRight;
	}
	
	public boolean getExecuteRight() {
	
		return executeRight;
	}
	
	public void setExecuteRight(boolean executeRight) {
	
		this.executeRight = executeRight;
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
	
	//
	// @Override
	// public int hashCode() {
	// int hash = 0;
	// hash += (id != null ? id.hashCode() : 0);
	// return hash;
	// }
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (executeRight ? 1231 : 1237);
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + (readRight ? 1231 : 1237);
		result = prime * result + ((rightRefID == null) ? 0 : rightRefID.hashCode());
		result = prime * result + (writeRight ? 1231 : 1237);
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
	
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPermission other = (UserPermission) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (executeRight != other.executeRight)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (readRight != other.readRight)
			return false;
		if (rightRefID == null) {
			if (other.rightRefID != null)
				return false;
		} else if (!rightRefID.equals(other.rightRefID))
			return false;
		if (writeRight != other.writeRight)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
	
		return "com.ikubinfo.foxcrm.UserPermission[ userPermissionPK= ]";
	}
	
	@Override
	public Integer getId() {
	
		return id;
	}
	
	@Override
	public void setId(Integer id) {
	
		this.id = id;
	}
	
	/**
	 * @return the rightRefID
	 */
	public UserRights getRightRefID() {
	
		return rightRefID;
	}
	
	/**
	 * @param rightRefID the rightRefID to set
	 */
	public void setRightRefID(UserRights rightRefID) {
	
		this.rightRefID = rightRefID;
	}
	
	/**
	 * @return the userRefID
	 */
	public Users getUserRefID() {
	
		return userRefID;
	}
	
	/**
	 * @param userRefID the userRefID to set
	 */
	public void setUserRefID(Users userRefID) {
	
		this.userRefID = userRefID;
	}
	
	@Override
	public String getShortDescription() {
	
		// TODO Auto-generated method stub
		return null;
	}
}
