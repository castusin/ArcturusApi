package com.digitalhealthcare;



import org.apache.log4j.Logger;

import com.cis.CISResults;

public class DigihealthCareAdminCreateServiceWebservice {

	
	public CISResults addPatients(DigihealthCareSaveProfile savePatient) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(DigihealthCareAdminCreateServiceWebservice.class);
		DigihealthCareAdminCreateServiceBL adminCreateServiceBL = new DigihealthCareAdminCreateServiceBL();
		CISResults cisResult = adminCreateServiceBL.addPatients(savePatient);	
		logger.info("Digital HealthCare Add patients Webservice:: " +cisResult );
		return cisResult;
	}

}
