package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;


import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;


/**
 * Rest Controller : Service to return OTP (One Time Password)
 * 
 * @author Castus info solutions
 *
 */
@RestController
public class DigitalHealthCareRequestOTPRestServices {
	 /**
	 * This service generates OTP and sends to given phone number 
	 * @param phoneNumber 
	 * @param emailId - Not implemented for email id in this version
	 * @return Returns 0 for success , 1 for failure
	 */
	@RequestMapping(value="/requestOTP",method=RequestMethod.GET,produces={"application/json"})

	 public String requestOTP(HttpServletRequest request,@RequestParam ("phoneNumber") String phoneNumber,@RequestParam ("emailId") String emailId){
		  Logger logger = Logger.getLogger(DigihealthCareRequestOTP.class);
		  String requestOTPParameters = "phoneNumber=" +phoneNumber + "&emailId=" + emailId ;
		  logger.info(" DigitalHealthCare:Request OTP :"+requestOTPParameters);
		 
			 // Capture service Start time
		  TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
		  
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.requestOTPValidation(phoneNumber,emailId,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
		    DigihealthCareRequestOTPWebservice otpRequest= new DigihealthCareRequestOTPWebservice();
		    cisResult  = otpRequest.requestOTP(phoneNumber,emailId);    
		  }
		  
		  
			// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
      	 logger.info("Total service time for request otp service in milli seconds:: " +result );

		  
		  return returnJsonData(cisResult);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
