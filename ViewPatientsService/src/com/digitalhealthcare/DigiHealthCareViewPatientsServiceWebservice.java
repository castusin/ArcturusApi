package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareViewPatientsServiceWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareGetProfileDataWebservice.class);
	
	DigiHealthCareViewPatientsServiceBL viewPatientsServiceBL=new DigiHealthCareViewPatientsServiceBL();

		public CISResults viewPatients(DigihealthCareSaveProfile viewPatients) {
		 CISResults cisResult = viewPatientsServiceBL.viewPatients(viewPatients);
		 logger.info(" DigitalHealthCare:viewPatientsWebService :"+cisResult);
		return cisResult;
	}
}