package com.crm.report;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.crm.report.util.AbstractReportBean;

@Named("clientStatusReportBean")
@SessionScoped
public class ClientStatusReportsBean extends AbstractReportBean {
	
	private final String COMPILE_FILE_NAME = "client_status";
	
	@Override
	protected String getCompileFileName() {
	
		return COMPILE_FILE_NAME;
	}
	
	@Override
	protected Map<String, Object> getReportParameters() {
	
		Map<String, Object> reportParameters = new HashMap<String, Object>();
		reportParameters.put("rtitle", "Hello JasperReports");
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
