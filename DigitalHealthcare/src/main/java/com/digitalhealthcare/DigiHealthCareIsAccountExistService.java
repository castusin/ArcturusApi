/**
 * 
 */
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
	 */
	@RequestMapping(value="/isAccountExists",method=RequestMethod.GET,produces={"application/json"})


	 public String isAccountExists(HttpServletRequest request,@RequestParam ("phoneNumber") String phoneNumber,@RequestParam ("deviceId") String deviceId){
		 Logger logger = Logger.getLogger(DigitalHealthCareLoginRest.class);
		 String isAccountExistsParameters = "phoneNumber=" +phoneNumber ;
		 logger.info(" DigitalHealthCare:isAccountExists :"+isAccountExistsParameters);
		
		// Capture service Start time
				 testServiceTime sessionTimeCheck=new testServiceTime();
				 Calendar currentdate = Calendar.getInstance();
			      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
			      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
			      formatter.setTimeZone(obj);
			     // System.out.println("Local:: " +currentdate.getTime());
			      //System.out.println("CST:: "+ formatter.format(currentdate.getTime()));
				  String serviceStartTime=formatter.format(currentdate.getTime());
		 
		 
		 
		 
		 
		 // Make sure input parameters are valid
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 
		 CISResults cisResult=CommonCISValidation.accountExistValidaiton(phoneNumber,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			  DigitalHealthCareIsAccountExistWebservice digiHealthCareIsAccountExist = new DigitalHealthCareIsAccountExistWebservice();
			  cisResult  = digiHealthCareIsAccountExist.isAccountExists(phoneNumber,deviceId);
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