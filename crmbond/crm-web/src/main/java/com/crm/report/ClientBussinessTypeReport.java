package com.crm.report;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

@Named("clientBussinessTypeReport")
@ViewScoped
public class ClientBussinessTypeReport implements Serializable{

	
	@EJB
	private com.crm.sessionbean.ReportsFacade ejbFacade;
	
	private PieChartModel pieModel1;
	private PieChartModel pieModel2;

	
	public ClientBussinessTypeReport() {

		//		SELECT [BussinessType]
		//    ,(Select count(ID) from Clients
		//		where Clients.BussinessType = BussinessTypes.ID
		//		AND $P{fromDate} <= Clients.ClientSinceDate
		//		AND Clients.ClientSinceDate <= $P{toDate} AND
		//		Clients.isActive = '1' ) as "NumberOfClients"
		//FROM [BussinessTypes]
	}
	

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}
	
	
	
	private void createPieModels() {

		Map<String, Integer> map = ejbFacade.getAvailableBorderTypes(null);
		pieModel1 = new PieChartModel();
		
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			pieModel1.set(entry.getKey(), entry.getValue());
		}
		
		pieModel1.setTitle("Bussiness Type");
		pieModel1.setLegendPosition("w");
		
		
		Map<String, Integer> map1 = ejbFacade.getAvailableClientPriority(null);
		pieModel2 = new PieChartModel();
		
		for (Map.Entry<String, Integer> entry : map1.entrySet())
		{
			pieModel2.set(entry.getKey(), entry.getValue());
		}
		
		pieModel2.setTitle("Priority Type");
		pieModel2.setLegendPosition("w");
	}


	/**
	 * @return the pieModel2
	 */
	public PieChartModel getPieModel2() {
		
		return pieModel2;
	}


	/**
	 * @param pieModel2 the pieModel2 to set
	 */
	public void setPieModel2(PieChartModel pieModel2) {
		
		this.pieModel2 = pieModel2;
	}


	
	
}
