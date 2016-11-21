/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author abuzo
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "EventLog.findAll", query = "SELECT e FROM EventLog e"),
	@NamedQuery(name = "EventLog.findById", query = "SELECT e FROM EventLog e WHERE e.id = :id"),
	@NamedQuery(name = "EventLog.findByLogTimestamp", query = "SELECT e FROM EventLog e WHERE e.logTimestamp = :logTimestamp")})
public class EventLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "log_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logTimestamp;
	@Lob
	@Column(name = "log_level")
	private String logLevel;
	@Lob
	@Column(name = "thread_name")
	private String threadName;
	@Lob
	@Column(name = "class_name")
	private String className;
	@Lob
	@Column(name = "log_message")
	private String logMessage;
	@Lob
	@Column(name = "ex_full")
	private String exFull;
	@Lob
	@Column(name = "ex_short")
	private String exShort;
	@Lob
	@Column(name = "ex_class_name")
	private String exClassName;
	@Lob
	@Column(name = "ex_file_name")
	private String exFileName;
	@Lob
	@Column(name = "ex_line_number")
	private String exLineNumber;
	@Lob
	@Column(name = "ex_method_name")
	private String exMethodName;
	@Lob
	@Column(name = "ex_message")
	private String exMessage;
	@Lob
	@Column(name = "ex_localized_message")
	private String exLocalizedMessage;
	@Lob
	@Column(name = "user_id")
	private String userId;
	@Lob
	@Column(name = "username")
	private String username;
	@Lob
	@Column(name = "objecttype")
	private String objecttype;
	@Lob
	@Column(name = "action")
	private String action;
	@Lob
	@Column(name = "appid")
	private String appid;
	@Lob
	@Column(name = "usersession")
	private String usersession;
	@Lob
	@Column(name = "event")
	private String event;
	@Lob
	@Column(name = "objectid")
	private String objectid;
	@Lob
	@Column(name = "moduleid")
	private String moduleid;
	@Lob
	@Column(name = "resultid")
	private String resultid;

	public EventLog() {
	}

	public EventLog(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLogTimestamp() {
		return logTimestamp;
	}

	public void setLogTimestamp(Date logTimestamp) {
		this.logTimestamp = logTimestamp;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getExFull() {
		return exFull;
	}

	public void setExFull(String exFull) {
		this.exFull = exFull;
	}

	public String getExShort() {
		return exShort;
	}

	public void setExShort(String exShort) {
		this.exShort = exShort;
	}

	public String getExClassName() {
		return exClassName;
	}

	public void setExClassName(String exClassName) {
		this.exClassName = exClassName;
	}

	public String getExFileName() {
		return exFileName;
	}

	public void setExFileName(String exFileName) {
		this.exFileName = exFileName;
	}

	public String getExLineNumber() {
		return exLineNumber;
	}

	public void setExLineNumber(String exLineNumber) {
		this.exLineNumber = exLineNumber;
	}

	public String getExMethodName() {
		return exMethodName;
	}

	public void setExMethodName(String exMethodName) {
		this.exMethodName = exMethodName;
	}

	public String getExMessage() {
		return exMessage;
	}

	public void setExMessage(String exMessage) {
		this.exMessage = exMessage;
	}

	public String getExLocalizedMessage() {
		return exLocalizedMessage;
	}

	public void setExLocalizedMessage(String exLocalizedMessage) {
		this.exLocalizedMessage = exLocalizedMessage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getObjecttype() {
		return objecttype;
	}

	public void setObjecttype(String objecttype) {
		this.objecttype = objecttype;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getUsersession() {
		return usersession;
	}

	public void setUsersession(String usersession) {
		this.usersession = usersession;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getResultid() {
		return resultid;
	}

	public void setResultid(String resultid) {
		this.resultid = resultid;
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
		if (!(object instanceof EventLog)) {
			return false;
		}
		EventLog other = (EventLog) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.airhacks.workshops.business.EventLog[ id=" + id + " ]";
	}
	
}
