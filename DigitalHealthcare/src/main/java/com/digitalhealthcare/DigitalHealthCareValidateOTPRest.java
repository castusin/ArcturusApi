package com.digitalhealthcare;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;


import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Validates OTP 
 * @author Castus Info Solutions
 *
 */
@RestController
public class DigitalHealthCareValidateOTPRest {
	 /**
	 * Validates OTP. Compares input OTP with OTP stored in the database for the input phone number
	 * @param phoneNumber
	 * @param emailId
	 * @param otp - One time password entered by the user
	 * @return Returns 0 for success, 1 for failure
	 */
	@RequestMapping(value="/validateOTP",method=RequestMethod.GET,produces={"application/json"})

	 public String validateOTP(HttpServletRequest request,@RequestParam ("phoneNumber") String phoneNumber,@RequestParam ("emailId") String emailId,@RequestParam ("otp") String otp){
		 Logger logger = Logger.getLogger(DigitalHealthCareValidateOTPRest.class);
		 String postData = "phoneNumber=" +phoneNumber + "&emailId=" + emailId + "&otp=" + otp ;
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
			/*
			 * Validate input parameters
			 */

		 CISResults cisResult=CommonCISValidation.validateOTPValidation(phoneNumber,emailId,otp,request);
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
		 DigihealthCareValidateOTPWebservice verifyOTPWebService= new DigihealthCareValidateOTPWebservice();
		   cisResult  = verifyOTPWebService.validateOTP(phoneNumber,emailId,otp);
		  logger.info(" DigitalHealthCare:Validate OTP :"+postData);
		  }
		  return returnJsonData(cisResult);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
