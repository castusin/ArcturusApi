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
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 Calendar currentdate = Calendar.getInstance();
		      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		      formatter.setTimeZone(obj);
		     // System.out.println("Local:: " +currentdate.getTime());
		     // System.out.println("CST:: "+ formatter.format(currentdate.getTime()));
			  String serviceStartTime=formatter.format(currentdate.getTime());

		  
		  
		  
		  
		  
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.requestOTPValidation(phoneNumber,emailId,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
		    DigihealthCareRequestOTPWebservice otpRequest= new DigihealthCareRequestOTPWebservice();
		    cisResult  = otpRequest.requestOTP(phoneNumber,emailId);    
		  }
		  
		  
			// Capture Service End time
		  Calendar ServiceEnd= Calendar.getInstance();
	      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj1 = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	      formatter1.setTimeZone(obj1);
		  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
      	  sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  

		  
		  return returnJsonData(cisResult);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
