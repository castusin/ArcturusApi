/**
 * 
 */
package com.digitalhealthcare;

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
 * Rest Controller : Checks if account already exists
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareIsAccountExistService {
	 /**
	  * Checks if account already exists
	 * @param phoneNumber user phone number
	 * @return returns 1 in case of error or 0 if successful
	 * @throws Throwable 
	 */
	@RequestMapping(value="/isAccountExists",method=RequestMethod.GET,produces={"application/json"})


	 public String isAccountExists(HttpServletRequest request,@RequestParam ("phoneNumber") String phoneNumber,@RequestParam ("deviceId") String deviceId) throws Throwable{
		 Logger logger = Logger.getLogger(DigitalHealthCareLoginRest.class);
		 String isAccountExistsParameters = "phoneNumber=" +phoneNumber ;
		 logger.info(" DigitalHealthCare:isAccountExists :"+isAccountExistsParameters);
		  TimeCheck time=new TimeCheck();
		  
		// Capture service Start time
	 	   testServiceTime sessionTimeCheck=new testServiceTime();
		   String serviceStartTime=time.getTimeZone();
		 
		 // Make sure input parameters are valid
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 
		 CISResults cisResult=CommonCISValidation.accountExistValidaiton(phoneNumber,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			  DigitalHealthCareIsAccountExistWebservice digiHealthCareIsAccountExist = new DigitalHealthCareIsAccountExistWebservice();
			  cisResult  = digiHealthCareIsAccountExist.isAccountExists(phoneNumber,deviceId);
		  }
		 
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Total service time for isacountexists service in milli seconds:: " +result );
		  
		 return returnJsonData(cisResult);
	 }
	
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	 }