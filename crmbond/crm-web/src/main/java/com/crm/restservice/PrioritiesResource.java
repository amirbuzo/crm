/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.restservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.crm.entities.Priorities;

/**
 *
 * @author abuzo
 */
@Stateless
@Path("priorities")
public class PrioritiesResource extends AbstractFacade<Priorities> {
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;
	
	public PrioritiesResource() {
	
		super(Priorities.class);
	}
	
	@POST
	@Override
	@Consumes({"application/xml", "application/json"})
	public void create(Priorities entity) {
	
		super.create(entity);
	}
	
	@PUT
	@Path("{id}")
	@Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Priorities entity) {
	
		super.edit(entity);
	}
	
	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Integer id) {
	
		super.remove(super.find(id));
	}
	
	@GET
	@Path("{id}")
	@Produces({"application/xml", "application/json"})
	public Priorities find(@PathParam("id") Integer id) {
	
		return super.find(id);
	}
	
	@GET
	@Override
	@Produces({"application/xml", "application/json"})
	public List<Priorities> findAll() {
	
		return super.findAll();
	}
	
	@GET
	@Path("{from}/{to}")
	@Produces({"application/xml", "application/json"})
	public List<Priorities> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
	
		return super.findRange(new int[] {from, to});
	}
	
	@GET
	@Path("count")
	@Produces("text/plain")
	public String countREST() {
	
		return String.valueOf(super.count());
	}
	
	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}
}
