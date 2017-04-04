package com.digitalhealthcare;


import org.apache.log4j.Logger;

import COM.CIS.CISResults;


public class DigiHealthCareGetProfileDataWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareGetProfileDataWebservice.class);
	
	DigiHealthCareGetProfileDataBL profileBL=new DigiHealthCareGetProfileDataBL();

	public CISResults getProfileData(String phoneNumber) {
		
		 CISResults otResult = profileBL.getProfileData(phoneNumber);
		 logger.info(" DigitalHealthCare:ProfileDataWebService :"+otResult);
		return otResult;
	}
}