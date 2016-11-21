/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.crm.restservice;

import java.util.Set;

import javax.ws.rs.core.Application;

/**
 *
 * @author abuzo
 */
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		addRestResourceClasses(resources);
		return resources;
	}

	/**
	 * Do not modify addRestResourceClasses() method. It is automatically populated with all resources
	 * defined in the project. If required, comment out calling this method in getClasses().
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {

		resources.add(com.crm.restservice.AimsResource.class);
		resources.add(com.crm.restservice.BussinessTypesResource.class);
		resources.add(com.crm.restservice.CitiesResource.class);
		resources.add(com.crm.restservice.ClaimsResource.class);
		resources.add(com.crm.restservice.ClientsResource.class);
		resources.add(com.crm.restservice.CompanyResource.class);
		resources.add(com.crm.restservice.ContactClientsResource.class);
		resources.add(com.crm.restservice.ContractTypesResource.class);
		resources.add(com.crm.restservice.ContractsResource.class);
		resources.add(com.crm.restservice.EmailResource.class);
		resources.add(com.crm.restservice.EventCategoriesResource.class);
		resources.add(com.crm.restservice.InteractionCategoriesResource.class);
		resources.add(com.crm.restservice.InteractionServiceTypesResource.class);
		resources.add(com.crm.restservice.InteractionServicesResource.class);
		resources.add(com.crm.restservice.LogsResource.class);
		resources.add(com.crm.restservice.PotentialClientsResource.class);
		resources.add(com.crm.restservice.PotentialContactCategoriesResource.class);
		resources.add(com.crm.restservice.PotentialContactsResource.class);
		resources.add(com.crm.restservice.PrioritiesResource.class);
		resources.add(com.crm.restservice.ReferencesResource.class);
		resources.add(com.crm.restservice.RequestsResource.class);
		resources.add(com.crm.restservice.StatesResource.class);
		resources.add(com.crm.restservice.UserResource.class);
		resources.add(com.crm.restservice.UserRightsResource.class);
	}
}
