package com.crm.report;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.crm.report.util.AbstractReportBean;

@Named("contractReportReportBean")
@SessionScoped
public class ContractReportReportsBean extends AbstractReportBean {
	
	private final String COMPILE_FILE_NAME = "contract_report";
	
	@Override
	protected String getCompileFileName() {
		
		return COMPILE_FILE_NAME;
	}
	
	@Override
	protected Map<String, Object> getReportParameters() {
		
		Map<String, Object> reportParameters = new HashMap<String, Object>();
		reportParameters.put("rtitle", "Hello JasperReports");
		reportParameters.put("dateStartFrom", new Date());
		reportParameters.put("dateFinishFrom", new Date());
		reportParameters.put("clientID", "%");
		reportParameters.put("status", "%");
		return reportParameters;
	}
	
	public void execute() {
		
		try {
			super.prepareReport();
		} catch (Exception e) {
			// make your own exception handling
			e.printStackTrace();
		}
	}
}
