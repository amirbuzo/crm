package com.crm.sessionbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Stateless
public class ReportsFacade {

	private static final Logger LOG = LogManager.getLogger(AbstractFacade.class);
	
	
	@PersistenceContext(unitName = "CRMPU")
	private EntityManager em;

	
	protected EntityManager getEntityManager() {

		return em;
	}
	
	public Map<String, Integer> getAvailableBorderTypes(Map<String, Object> filter) {
		// create empty map to store results in. If we don't find results, an empty hashmap will be returned
		Map<String, Integer> results = new HashMap<String, Integer>();


		// Construct and run query
		String jpaQuery = "		SELECT [BussinessType] ,(Select count(ID) from Clients where Clients.BussinessType = BussinessTypes.ID	"
				+ "  AND 	Clients.isActive = '1' ) as 'NumberOfClients'		FROM [BussinessTypes]";
		
		List<Object[]> resultList = em.createNativeQuery(jpaQuery).getResultList();

		// Place results in map
		for (Object[] borderTypes: resultList) {
			results.put((String)borderTypes[0], (Integer)borderTypes[1]);
		}

		return results;
	}

	public Map<String, Integer> getAvailableClientPriority(Map<String, Object> filter) {
		// create empty map to store results in. If we don't find results, an empty hashmap will be returned
		Map<String, Integer> results = new HashMap<String, Integer>();


		// Construct and run query
		String jpaQuery = "SELECT Priorities.PriorityName ,(Select count(ID) from Clients where Clients.BussinessType = Priorities.ID AND 	Clients.isActive = '1' ) as 'NumberOfClients'		FROM Priorities";
		
		List<Object[]> resultList = em.createNativeQuery(jpaQuery).getResultList();

		// Place results in map
		for (Object[] borderTypes: resultList) {
			results.put((String)borderTypes[0], (Integer)borderTypes[1]);
		}

		return results;
	}
}
