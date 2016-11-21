/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Model;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abuzo
 */
@Model
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"userName"})})
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
	@NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
	@NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
	@NamedQuery(name = "Users.findBySurname",
	query = "SELECT u FROM Users u WHERE u.surname = :surname"),
	@NamedQuery(name = "Users.findByUserName",
	query = "SELECT u FROM Users u WHERE u.userName = :userName"),
	@NamedQuery(name = "Users.findByUserPass",
	query = "SELECT u FROM Users u WHERE u.userPass = :userPass"),
	@NamedQuery(name = "Users.findByAddress",
	query = "SELECT u FROM Users u WHERE u.address = :address"),
	@NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
	@NamedQuery(name = "Users.findByMobile",
	query = "SELECT u FROM Users u WHERE u.mobile = :mobile"),
	@NamedQuery(name = "Users.findByType", query = "SELECT u FROM Users u WHERE u.type = :type"),
	@NamedQuery(name = "Users.findByUserID",
	query = "SELECT u FROM Users u WHERE u.userID = :userID"),
	@NamedQuery(name = "Users.findByCreatedDate",
	query = "SELECT u FROM Users u WHERE u.createdDate = :createdDate"),
	@NamedQuery(name = "Users.findByModifiedDate",
	query = "SELECT u FROM Users u WHERE u.modifiedDate = :modifiedDate"),
	@NamedQuery(name = "Users.findByIsActive",
	query = "SELECT u FROM Users u WHERE u.isActive = :isActive")})
public class Users extends AEntity implements Serializable {
	
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
	private String userName;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String userPass;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String address;
	
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
	private String mobile;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String type;
	
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int userID;
	
	@Size(max = 50)
	@Column(nullable = true, length = 50)
	private String theme;
	
	@Size(max = 50)
	@Column(nullable = true, length = 50)
	private String language;
	
	@Size(max = 50)
	@Column(nullable = true, length = 50)
	private String currency;
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH})
	@JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "UserID",
	referencedColumnName = "ID")}, inverseJoinColumns = {@JoinColumn(name = "Role",
	referencedColumnName = "ID")})
	private Set<Roles> roles;


	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.REMOVE}, mappedBy = "userRefID", fetch = FetchType.EAGER)
	private List<UserPermission> userpermissions;

	@Size(max = 100)
	@Column(nullable = true, length = 100)
	private String dateformat;
	//	@Basic(optional = false)
	//	@NotNull
	//	@Size(min = 1, max = 50)
	//	@Column(nullable = false, length = 50)
	@Size(max = 50)
	@Column(nullable = true, length = 50)
	private String email;
	
	@Basic(optional = true)
	@Column(nullable = true)
	private boolean gender;
	
	
	@Basic(optional = true)
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

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
	
	public String getUserName() {
		
		return userName;
	}
	
	public void setUserName(String userName) {
		
		this.userName = userName;
	}
	
	public String getUserPass() {
		
		return userPass;
	}
	
	public void setUserPass(String userPass) {
		
		this.userPass = userPass;
	}
	
	public String getAddress() {
		
		return address;
	}
	
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	public String getPhone() {
		
		return phone;
	}
	
	public void setPhone(String phone) {
		
		this.phone = phone;
	}
	
	public String getMobile() {
		
		return mobile;
	}
	
	public void setMobile(String mobile) {
		
		this.mobile = mobile;
	}
	
	public String getType() {
		
		return type;
	}
	
	public void setType(String type) {
		
		this.type = type;
	}
	
	public int getUserID() {
		
		return userID;
	}
	
	public void setUserID(int userID) {
		
		this.userID = userID;
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
	public boolean getIsActive() {
		
		return isActive;
	}
	
	@Override
	public void setIsActive(boolean isActive) {
		
		this.isActive = isActive;
	}
	
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		
		this.isActive = isActive;
	}
	
	/**
	 * @return the theme
	 */
	public String getTheme() {
		
		return theme;
	}
	
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		
		this.theme = theme;
	}
	
	/**
	 * @return the language
	 */
	public String getLanguage() {
		
		return language;
	}
	
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		
		this.language = language;
	}
	
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		
		return currency;
	}
	
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		
		this.currency = currency;
	}
	
	/**
	 * @return the roles
	 */
	@XmlTransient
	public Set<Roles> getRoles() {
		
		return roles;
	}
	
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Roles> roles) {
		
		this.roles = roles;
	}
	
	/**
	 * @return the userpermissions
	 */
	@XmlTransient
	public List<UserPermission> getUserpermissions() {
		
		return userpermissions;
	}
	
	/**
	 * @param userpermissions the userpermissions to set
	 */
	public void setUserpermissions(List<UserPermission> userpermissions) {
		
		this.userpermissions = userpermissions;
	}
	
	
	/**
	 * @return the dateformat
	 */
	public String getDateformat() {
		
		return dateformat;
	}

	
	/**
	 * @param dateformat the dateformat to set
	 */
	public void setDateformat(String dateformat) {
		
		this.dateformat = dateformat;
	}

	
	/**
	 * @return the email
	 */
	public String getEmail() {
		
		return email;
	}

	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		
		this.email = email;
	}

	
	/**
	 * @return the gender
	 */
	public boolean isGender() {
		
		return gender;
	}

	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(boolean gender) {
		
		this.gender = gender;
	}

	
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		
		return birthday;
	}

	
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		
		this.birthday = birthday;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Users)) {
			return false;
		}
		Users other = (Users) object;
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
		
		return "Users [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public String getShortDescription() {
		
		// TODO Auto-generated method stub
		return name + " " + surname + "\n" + userName;
	}
}
