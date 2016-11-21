package com.crm.login;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Stateless
@Named
public class LoginBean {
	
	private static final Logger LOG = LogManager.getLogger(LoginBean.class);
	
	private String username;
	
	private String password;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
	
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
	
		this.username = username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
	
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
	
		this.password = password;
	}
	
	public String login() {
	
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			request.login(this.username, this.password);
			LOG.log(Level.INFO, username + " Login successfully!");
		} catch (ServletException e) {
			LOG.log(Level.ERROR, e.getMessage(), e);
			context.addMessage(null, new FacesMessage("Login failed."));
			return "/home/index.xhtml?faces-redirect=true";
		}
		return "/home/index.xhtml?faces-redirect=true";
	}
	
	public String logout() {
	
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			LOG.log(Level.INFO, "Logout successfully!");
			request.logout();
		} catch (ServletException e) {
			LOG.log(Level.ERROR, e.getMessage(), e);
			context.addMessage(null, new FacesMessage("Logout failed."));
		}
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.invalidate();
		return "/login.xhtml?faces-redirect=true";
	}
}
