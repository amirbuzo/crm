package com.crm.report;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.crm.report.util.AbstractReportBean;

@Named("reportsBean")
@SessionScoped
public class ReportsBean extends AbstractReportBean {
	
	private final String COMPILE_FILE_NAME = "logs";
	
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
