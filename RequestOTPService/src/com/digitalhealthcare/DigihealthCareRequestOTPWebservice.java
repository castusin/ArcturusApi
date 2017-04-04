package com.digitalhealthcare;


import org.apache.log4j.Logger;


import com.cis.CISResults;
/**
 * Service to return OTP (One Time Password)
 * 
 * @author Castus info solutions
 *
 */
public class DigihealthCareRequestOTPWebservice {
	
	static Logger logger = Logger.getLogger(DigihealthCareRequestOTPWebservice.class);
	DigihealthCareRequestOTPBL otpBL=new DigihealthCareRequestOTPBL();

	public CISResults requestOTP(String phoneNumber,String emailId) {
		CISResults cisResult = null;
		try {
			 cisResult = otpBL.requestOTP(phoneNumber,emailId);
			// logger.info(" DigitalHealthCare:Webservice Request OTP :"+cisResult);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cisResult;
	}


}
