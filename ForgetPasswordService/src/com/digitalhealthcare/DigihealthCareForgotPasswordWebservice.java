package com.digitalhealthcare;




import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigihealthCareForgotPasswordWebservice {
	
	static Logger logger = Logger.getLogger(DigihealthCareForgotPasswordWebservice.class);
	
	DigihealthCareForgotPasswordBL forgotPasswordBL=new DigihealthCareForgotPasswordBL();

	public CISResults forgotPassword(String emailId,String phoneNumber) {
		
		 CISResults cisResult = forgotPasswordBL.forgotPassword(emailId,phoneNumber);
		 logger.info(" DigitalHealthCare:ProfileDataWebService :"+cisResult);
		return cisResult;
	}
}