package com.crm;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

import com.crm.webservice.AimsWebService;
import com.crm.webservice.BussinessTypeWebService;
import com.crm.webservice.ClientsWebService;
import com.crm.webservice.CompanyWebService;
import com.crm.webservice.ContactClientsWebService;
import com.crm.webservice.ContractTypesWebService;
import com.crm.webservice.ContractsWebService;
import com.crm.webservice.EventCategoriesWebService;
import com.crm.webservice.InteractionCategoriesWebService;
import com.crm.webservice.InteractionServicesTypesWebService;
import com.crm.webservice.InteractionServicesWebService;
import com.crm.webservice.LogsWebService;
import com.crm.webservice.PotentialClientsWebService;
import com.crm.webservice.PotentialContactCategoriesWebService;
import com.crm.webservice.PotentialContactsWebService;
import com.crm.webservice.PrioritiesWebService;
import com.crm.webservice.ReferencesWebService;
import com.crm.webservice.RequestsWebService;
import com.crm.webservice.StatesWebService;
import com.crm.webservice.UserRightsWebService;
import com.crm.webservice.UserWebService;

public class SoapServiceTest {
	private static final int port = Integer.parseInt(System.getProperty("httpejbd.port", "" + org.apache.openejb.util.NetworkUtil.getNextAvailablePort()));

	public static final String DOMAIN = "http://localhost:8080/crm-web/webservices/";
	public static final String URL_PATH = "/crm-web/webservices/";
	

	@Test
	public void testAims() throws Exception {


		URL url = new URL("http://localhost:8080/crm-web/webservices/AimsWebServiceImpl?wsdl");
		QName calcServiceQName = new QName("http://crm.com/wsdl", "AimsWebService");
		Service service = Service.create(url, calcServiceQName);

		assertNotNull(service);

		AimsWebService webservice = service.getPort(AimsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(14));
		assertEquals(size1, webservice.count());
	}

	@Test
	public void testBussinessTypes() throws Exception {


		URL url = new URL("http://localhost:8080/crm-web/webservices/BussinessTypesWebServiceImpl?wsdl");
		QName calcServiceQName = new QName("http://crm.com/wsdl", "BussinessTypeWebService");
		Service service = Service.create(url, calcServiceQName);

		assertNotNull(service);

		BussinessTypeWebService webservice = service.getPort(BussinessTypeWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	@Test
	public void testClients() throws Exception {
		
		URL url = new URL(DOMAIN + "ClientsWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "ClientsWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		ClientsWebService webservice = service.getPort(ClientsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	@Test
	public void testCompany() throws Exception {
		
		URL url = new URL(DOMAIN + "CompanyWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "CompanyWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		CompanyWebService webservice = service.getPort(CompanyWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	@Test
	public void testContactClients() throws Exception {
		
		URL url = new URL(DOMAIN + "ContactClientsWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "ContactClientsWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		ContactClientsWebService webservice = service.getPort(ContactClientsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}

	@Test
	public void testContracts() throws Exception {
		
		URL url = new URL(DOMAIN + "ContractsWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "ContractsWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		ContractsWebService webservice = service.getPort(ContractsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}

	@Test
	public void testEventCategories() throws Exception {
		
		URL url = new URL(DOMAIN + "EventCategoriesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "EventCategoriesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		EventCategoriesWebService webservice = service.getPort(EventCategoriesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}

	@Test
	public void testInteractionCategories() throws Exception {
		
		URL url = new URL(DOMAIN + "InteractionCategoriesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "InteractionCategoriesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		InteractionCategoriesWebService webservice = service.getPort(InteractionCategoriesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	@Test
	public void testInteractionServicesTypes() throws Exception {

		URL url = new URL(DOMAIN + "InteractionServiceTypesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "InteractionServicesTypesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		InteractionServicesTypesWebService webservice = service.getPort(InteractionServicesTypesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	@Test
	public void testInteractionServices() throws Exception {
		
		URL url = new URL(DOMAIN + "InteractionServicesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "InteractionServicesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		InteractionServicesWebService webservice = service.getPort(InteractionServicesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	@Test
	public void testLogs() throws Exception {
		
		URL url = new URL(DOMAIN + "LogsWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "LogsWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		LogsWebService webservice = service.getPort(LogsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	@Test
	public void testPotentialClients() throws Exception {
		
		URL url = new URL(DOMAIN + "PotentialClientsWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "PotentialClientsWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		PotentialClientsWebService webservice = service.getPort(PotentialClientsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	
	@Test
	public void testPotentialContactCategories() throws Exception {
		
		URL url = new URL(DOMAIN + "PotentialContactCategoriesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "PotentialContactCategoriesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		PotentialContactCategoriesWebService webservice = service.getPort(PotentialContactCategoriesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	
	@Test
	public void testContractTypes() throws Exception {
		
		URL url = new URL(DOMAIN + "ContractTypesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "ContractTypesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		ContractTypesWebService webservice = service.getPort(ContractTypesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}

	@Test
	public void testPotentialContacts() throws Exception {
		
		URL url = new URL(DOMAIN + "PotentialContactsWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "PotentialContactsWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		PotentialContactsWebService webservice = service.getPort(PotentialContactsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}


	@Test
	public void testPriorities() throws Exception {
		
		URL url = new URL(DOMAIN + "PrioritiesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "PrioritiesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		PrioritiesWebService webservice = service.getPort(PrioritiesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}



	@Test
	public void testReferences() throws Exception {
		
		URL url = new URL(DOMAIN + "ReferencesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "ReferencesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		ReferencesWebService webservice = service.getPort(ReferencesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}


	@Test
	public void testRequests() throws Exception {
		
		URL url = new URL(DOMAIN + "RequestsWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "RequestsWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		RequestsWebService webservice = service.getPort(RequestsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	@Test
	public void testStates() throws Exception {
		
		URL url = new URL(DOMAIN + "StatesWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "StatesWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		StatesWebService webservice = service.getPort(StatesWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	
	@Test
	public void testUserRights() throws Exception {
		
		URL url = new URL(DOMAIN + "UserRightsWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "UserRightsWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		UserRightsWebService webservice = service.getPort(UserRightsWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
	
	@Test
	public void testUser() throws Exception {
		
		URL url = new URL(DOMAIN + "UserWebServiceImpl?wsdl");
		QName qservice = new QName("http://crm.com/wsdl", "UserWebService");
		Service service = Service.create(url, qservice);

		assertNotNull(service);
		
		UserWebService webservice = service.getPort(UserWebService.class);
		int size1  =	webservice.count();
		assertNull( webservice.find(60000));
		assertNull( webservice.find(33333333));
		assertEquals(size1, webservice.count());
	}
}