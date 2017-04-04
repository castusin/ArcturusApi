/**
 * 
 */
package com.digitalhealthcare;

import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author Darshan
 *
 */
public class DigiHealthCareAdminAddCareTakerWebService {

	public CISResults addPatients(String userId, String phoneNumber) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(DigiHealthCareAdminAddCareTakerWebService.class);
		DigiHealthCareAdminAddCareTakerBL adminCareTakerServiceBL = new DigiHealthCareAdminAddCareTakerBL();
		CISResults cisResult = adminCareTakerServiceBL.addCareTakers(userId,phoneNumber);	
		logger.info("Digital HealthCare Add patients Webservice:: " +cisResult );
		return cisResult;
	
	}

}
