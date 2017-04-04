package com.digitalhealthcare;

import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * User Logout Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */

public class DigihealthCareUserLogoutWebservice {
	static Logger logger = Logger.getLogger(DigihealthCareUserLogoutWebservice.class);
	DigihealthCareUserLogoutBL userLogoutBL=new DigihealthCareUserLogoutBL();

	/**
	 * @param userId
	 * @param sessionId
	 * @return
	 */
	public CISResults userLogout(String userId,String sessionId) {
		
		 CISResults cisResult = userLogoutBL.userLogout(userId,sessionId);
		 logger.debug(" DigitalHealthCare:save content :"+cisResult);
		return cisResult;
	}
}