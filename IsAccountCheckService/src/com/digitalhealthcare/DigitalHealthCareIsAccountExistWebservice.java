package com.digitalhealthcare;

import org.apache.log4j.Logger;

import com.cis.CISResults;
/**
 * Checks if account already exists 
 * @author Castus Info Solutions
 *
 */
public class DigitalHealthCareIsAccountExistWebservice {
	static Logger logger = Logger.getLogger(DigitalHealthCareIsAccountExistWebservice.class);
	DigitalHealtCareIsAccountExistBL digiIsAccountExistBL=new DigitalHealtCareIsAccountExistBL();
	/**
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public CISResults isAccountExists(String phoneNumber,String deviceId) {
		// TODO Auto-generated method stub
		CISResults cisResult = digiIsAccountExistBL.isAccountExists(phoneNumber,deviceId);
		return cisResult;
	}
}
