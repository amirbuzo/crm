package com.crm.restservice;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.crm.entities.Cities;

/**
 *
 * @author abuzo
 */
public class CitiesResourceRESTTest {
	
	public CitiesResourceRESTTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of edit method, of class CitiesResource.
	 */
	@Test
	public void testEdit_GenericType() throws Exception {
		System.out.println("edit");
		Cities entity = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		instance.edit(entity);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of remove method, of class CitiesResource.
	 */
	@Test
	public void testRemoveGenericType() throws Exception {
		Cities entity = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		instance.remove(entity);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of find method, of class CitiesResource.
	 */
	@Test
	public void testFindObject() throws Exception {
		Object id = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		Cities expResult = null;
		Cities result = instance.find(id);
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findRange method, of class CitiesResource.
	 */
	@Test
	public void testFindRange_intArr() throws Exception {
		System.out.println("findRange");
		int[] range = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		List<Cities> expResult = null;
		List<Cities> result = instance.findRange(range);
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of count method, of class CitiesResource.
	 */
	@Test
	public void testCount() throws Exception {
		System.out.println("count");
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		int expResult = 0;
		int result = instance.count();
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of create method, of class CitiesResource.
	 */
	@Test
	public void testCreate() throws Exception {
		System.out.println("create");
		Cities entity = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		instance.create(entity);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of edit method, of class CitiesResource.
	 */
	@Test
	public void testEditInteger_Cities() throws Exception {
		System.out.println("edit");
		Integer id = null;
		Cities entity = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		instance.edit(id, entity);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of remove method, of class CitiesResource.
	 */
	@Test
	public void testRemove_Integer() throws Exception {
		System.out.println("remove");
		Integer id = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		instance.remove(id);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of find method, of class CitiesResource.
	 */
	@Test
	public void testFind_Integer() throws Exception {
		System.out.println("find");
		Integer id = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		Cities expResult = null;
		Cities result = instance.find(id);
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findAll method, of class CitiesResource.
	 */
	@Test
	public void testFindAll() throws Exception {
		System.out.println("findAll");
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		List<Cities> expResult = null;
		List<Cities> result = instance.findAll();
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of findRange method, of class CitiesResource.
	 */
	@Test
	public void testFindRange_Integer_Integer() throws Exception {
		System.out.println("findRange");
		Integer from = null;
		Integer to = null;
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		List<Cities> expResult = null;
		List<Cities> result = instance.findRange(from, to);
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of countREST method, of class CitiesResource.
	 */
	@Test
	public void testCountREST() throws Exception {
		System.out.println("countREST");
		EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
		CitiesResource instance = (CitiesResource)container.getContext().lookup("java:global/classes/CitiesResource");
		String expResult = "";
		String result = instance.countREST();
		assertEquals(expResult, result);
		container.close();
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
