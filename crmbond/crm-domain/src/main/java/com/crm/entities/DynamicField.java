/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abuzo
 */
@Entity
@Table(name = "DynamicField")
@NamedQueries({
	@NamedQuery(name = "DynamicField.findAll", query = "SELECT d FROM DynamicField d"),
	@NamedQuery(name = "DynamicField.findById", query = "SELECT d FROM DynamicField d WHERE d.id = :id"),
	@NamedQuery(name = "DynamicField.findByCreatedDate", query = "SELECT d FROM DynamicField d WHERE d.createdDate = :createdDate"),
	@NamedQuery(name = "DynamicField.findByIsActive", query = "SELECT d FROM DynamicField d WHERE d.isActive = :isActive"),
	@NamedQuery(name = "DynamicField.findByModifiedDate", query = "SELECT d FROM DynamicField d WHERE d.modifiedDate = :modifiedDate"),
	@NamedQuery(name = "DynamicField.findByUserCreated", query = "SELECT d FROM DynamicField d WHERE d.userCreated = :userCreated"),
	@NamedQuery(name = "DynamicField.findByUserModified", query = "SELECT d FROM DynamicField d WHERE d.userModified = :userModified"),
	@NamedQuery(name = "DynamicField.findByFieldKey", query = "SELECT d FROM DynamicField d WHERE d.fieldKey = :fieldKey"),
	@NamedQuery(name = "DynamicField.findByFieldValue", query = "SELECT d FROM DynamicField d WHERE d.fieldValue = :fieldValue"),
	@NamedQuery(name = "DynamicField.findByLabel", query = "SELECT d FROM DynamicField d WHERE d.label = :label"),
	@NamedQuery(name = "DynamicField.findByLength", query = "SELECT d FROM DynamicField d WHERE d.length = :length"),
	@NamedQuery(name = "DynamicField.findByRequired", query = "SELECT d FROM DynamicField d WHERE d.required = :required"),
	@NamedQuery(name = "DynamicField.findByRequiredMessage", query = "SELECT d FROM DynamicField d WHERE d.requiredMessage = :requiredMessage"),
	@NamedQuery(name = "DynamicField.findByType", query = "SELECT d FROM DynamicField d WHERE d.type = :type"),
	@NamedQuery(name = "DynamicField.findByVersion", query = "SELECT d FROM DynamicField d WHERE d.version = :version"),
	@NamedQuery(name = "DynamicField.findByEntityType", query = "SELECT d FROM DynamicField d WHERE d.entityType = :entityType"),
	@NamedQuery(name = "DynamicField.findByMask", query = "SELECT d FROM DynamicField d WHERE d.mask = :mask"),
	@NamedQuery(name = "DynamicField.findByRegex", query = "SELECT d FROM DynamicField d WHERE d.regex = :regex")})
public class DynamicField extends AEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "fieldKey")
	private String fieldKey;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "label")
	private String label;
	@Basic(optional = false)
	@NotNull
	@Column(name = "length")
	private int length;
	@Basic(optional = false)
	@NotNull
	@Column(name = "required")
	private boolean required;
	@Size(max = 255)
	@Column(name = "requiredMessage")
	private String requiredMessage;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "type")
	private String type;


	@Size(max = 50)
	@Column(name = "entityType")
	private String entityType;
	@Size(max = 50)
	@Column(name = "mask")
	private String mask;
	@Size(max = 100)
	@Column(name = "regex")
	private String regex;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(name="name")
	@Column(name="value")
	@CollectionTable(name="dynamicattributes", joinColumns=@JoinColumn(name="id"))
	private Map<String, String> attributes = new HashMap<String, String>();
	
	public DynamicField() {
	}
	
	public DynamicField(Integer id) {
		this.id = id;
	}
	
	public DynamicField(String label, String fieldKey,  String type, int length,
			boolean required, String requiredMessage, String entityType) {

		this.label = label;
		this.fieldKey = fieldKey;
		this.type = type;
		this.length = length;
		this.required = required;
		this.requiredMessage = requiredMessage;
		this.entityType = entityType;

		attributes.put("Choice2", "Choice2");
		attributes.put("Choice1", "Choice1");
		attributes.put("Choice3", "Choice3");
		attributes.put("Choice4", "Choice4");
	}
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Override
	public boolean getIsActive() {
		return isActive;
	}
	
	
	
	public String getFieldKey() {
		return fieldKey;
	}
	
	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}
	

	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public boolean getRequired() {
		return required;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public String getRequiredMessage() {
		return requiredMessage;
	}
	
	public void setRequiredMessage(String requiredMessage) {
		this.requiredMessage = requiredMessage;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	

	public String getEntityType() {
		return entityType;
	}
	
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	
	public String getMask() {
		return mask;
	}
	
	public void setMask(String mask) {
		this.mask = mask;
	}
	
	public String getRegex() {
		return regex;
	}
	
	public void setRegex(String regex) {
		this.regex = regex;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof DynamicField)) {
			return false;
		}
		DynamicField other = (DynamicField) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "com.airhacks.workshops.business.DynamicField[ id=" + id + " ]";
	}

	@Override
	public String getShortDescription() {
		
		// TODO Auto-generated method stub
		return null;
	}

}
