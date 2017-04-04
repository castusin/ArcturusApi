package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;
/**
 * Get Profile  Service
 * 
 * @author Castus Info Solutions
 *
 */

public class DigiHealthCareGetProfileDataWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareGetProfileDataWebservice.class);
	
	DigiHealthCareGetProfileDataBL profileBL=new DigiHealthCareGetProfileDataBL();

	/**
	 * @param userId
	 * @return
	 */
	public CISResults getProfileData(String userId) {
		
		 CISResults cisResult = profileBL.getProfileData(userId);
		 logger.info(" DigitalHealthCare:ProfileDataWebService :"+cisResult);
		return cisResult;
	}
}