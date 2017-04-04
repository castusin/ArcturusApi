package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareUpdatePasswordServiceWebservice {
	
	static Logger logger = Logger.getLogger(DigihealthCareForgotPasswordWebservice.class);
	
	DigiHealthCareUpdatePasswordServiceBL updatePasswordServiceBL=new DigiHealthCareUpdatePasswordServiceBL();

	public CISResults updatePassword(String userId,String password) {
		
		 CISResults cisResult = updatePasswordServiceBL.updatePassword(userId,password);
		 logger.info(" DigitalHealthCare:ProfileDataWebService :"+cisResult);
		return cisResult;
	}
}