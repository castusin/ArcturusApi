package com.digitalhealthcare;

import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareSaveProfileWebservice {
	static Logger logger = Logger.getLogger(DigiHealthCareSaveProfileWebservice.class);
	DigiHealthCareSaveProfileBL homeCareBLReg=new DigiHealthCareSaveProfileBL();

	public CISResults healthCareRegistration(DigihealthCareSaveProfile registration) {
		 CISResults cisResult = homeCareBLReg.healthCareRegistration(registration);	
		 logger.info("Digital HealthCare Webservice " +cisResult );
		 return cisResult;
	}

}
