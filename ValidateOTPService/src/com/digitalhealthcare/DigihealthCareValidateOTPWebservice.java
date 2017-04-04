package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;
/**
 * Validates OTP 
 * @author Castus Info Solutions
 *
 */

public class DigihealthCareValidateOTPWebservice {

	static Logger logger = Logger.getLogger(DigihealthCareValidateOTPWebservice.class);
	DigihealthCareValidateOTPBL verifyOTPBL=new DigihealthCareValidateOTPBL();

	/**
	 * @param phoneNumber
	 * @param emailId
	 * @param otp
	 * @return
	 */
	public CISResults validateOTP(String phoneNumber,String emailId,String otp) {
		
		 CISResults otResult = verifyOTPBL.validateOTP(phoneNumber,emailId,otp);
		 logger.info(" DigitalHealthCare:Validate OTP :"+otResult);
		return otResult;
	}
}