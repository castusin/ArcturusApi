package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.digitalhealthcare.DigihealthCareSaveProfile;
import com.digitalhealthcare.DigiHealthCareSaveProfileWebservice;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;


/**
 * Rest Controller : Saves Customer profile data. First name, last name, phone number, emailid, medical id, password
 * @author Castus Info Solutions
 *
 */
@RestController
public class DigitalHealthCareSaveProfileRest {
	/**
	 * Saves customer profile data. Generates new user id and generates session id.
	 * @param registration Object - First name, last name, phone number, emailid, medical id, password
	 * @return returns userid, session id. returns 1 for error 
	 */
	@RequestMapping(value="/registration",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public String HelathCareSaveprofile(HttpServletRequest request,@RequestBody DigihealthCareSaveProfile registration){
		  
		 // Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime sessionTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		
		 Logger logger = Logger.getLogger(DigitalHealthCareSaveProfileRest.class);
		  String requestParameters = "appId=" + registration.appId + "&userId=" + registration.userId + "&firstName=" +           
				 registration.firstName +"&lastName=" +registration.lastName + "&phoneNumber="+registration.phoneNumber+ "&emailId="+registration.emailId+ "&photo="+registration.photo+ "&accountType="+registration.accountType+ "&gender="+registration.gender+ "&dob="+registration.dob+ "&date="+registration.date;
		  logger.info("Digital HealthCare SaveProfile Request Parameters :"+requestParameters);
		  CommonCISValidation CommonCISValidation=new CommonCISValidation();
		  CISResults cisResult=CommonCISValidation.ProfileValidation(registration,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
		      DigiHealthCareSaveProfileWebservice healthCareWebserviceReg = new DigiHealthCareSaveProfileWebservice();
		      cisResult = healthCareWebserviceReg.healthCareRegistration(registration);
		    }
		  
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  
		  logger.info("Total service time for save profile service in milli seconds:: " +result );
		  
		  return returnJsonData(cisResult);
	}
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
