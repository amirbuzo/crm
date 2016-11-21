package com.crm.restservice;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.SingletonBean;
import org.junit.Test;

public class RestResourceTest {

	public static final String DOMAIN = "http://localhost:8080";
	public static final String URL_PATH = "/crm-web/services/";
	public SingletonBean app() {
		return (SingletonBean) new SingletonBean(CitiesResource.class).localBean();
	}
	
	@Test
	public void getaims() throws IOException {
		final String message = WebClient.create("http://localhost:8080").path("/crm-web/services/aims/").get(String.class);
		//System.out.println(message);
		assertNotNull( message);
	}
	
	@Test
	public void getbussinesstypes() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/bussinesstypes").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void getcities() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"cities").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void getclaims() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"claims").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void getclients() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"clients").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void getcompany() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"company").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void getcontactclients() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"contactclients").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void getcontracts() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"contracts").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void getemail() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"email").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void geteventcategories() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"eventcategories").get( String.class);
		
		assertNotNull( message);
	}
	@Test
	public void getinteractioncategories() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"interactioncategories").get( String.class);
		
		assertNotNull( message);
	}

	@Test
	public void getinteractionservices() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"interactionservices").get( String.class);
		
		assertNotNull( message);
	}

	@Test
	public void getinteractionservicetypes() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"interactionservicetypes").get( String.class);
		
		assertNotNull( message);
	}

	@Test
	public void getlogs() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"logs").get( String.class);
		
		assertNotNull( message);
	}
	
	@Test
	public void getpotentialclients() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"potentialclients").get( String.class);
		
		assertNotNull( message);
	}
	
	@Test
	public void getpotentialcontactcategories() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"potentialcontactcategories").get( String.class);
		
		assertNotNull( message);
	}

	@Test
	public void getpotentialcontacts() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"potentialcontacts").get( String.class);
		
		assertNotNull( message);
	}

	@Test
	public void getpriorities() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"priorities").get( String.class);
		
		assertNotNull( message);
	}
	
	
	@Test
	public void getreferences() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"references").get( String.class);
		
		assertNotNull( message);
	}
	
	
	@Test
	public void getrequests() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"requests").get( String.class);
		
		assertNotNull( message);
	}
	
	
	
	@Test
	public void getstates() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"states").get( String.class);
		
		assertNotNull( message);
	}
	
	
	@Test
	public void getuser() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"user").get( String.class);
		
		assertNotNull( message);
	}
	
	@Test
	public void getuserrights() throws IOException {
		final String message = WebClient.create(DOMAIN).path("/crm-web/services/"+"userrights").get( String.class);
		
		assertNotNull( message);
	}
}