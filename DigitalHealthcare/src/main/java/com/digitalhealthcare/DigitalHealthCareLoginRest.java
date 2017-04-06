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
 * Rest Controller : User Login Service
 * 
 * @author Castus Info Solutions
 *
 */
@RestController
public class DigitalHealthCareLoginRest {
	 /**
	  * User login service
	 * @param userId 
	 * @param password 
	 * @param accountType either patient type (U) or admin(A)
	 * @return returns userid and session id and profile data. Returns 1 in case error
	 */
	@RequestMapping(value="/loginService",method=RequestMethod.GET,produces={"application/json"})

	 public String login(HttpServletRequest request,@RequestParam ("userId") String userId,@RequestParam ("password") String password,@RequestParam ("accountType") String accountType) throws Throwable{
		 Logger logger = Logger.getLogger(DigitalHealthCareLoginRest.class);
		 String loginServiceParameters = "userId=" +userId + "&accountType=" + accountType+"&password=" + password ;
		 logger.info(" DigitalHealthCare: loginService :"+loginServiceParameters);
		 
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime sessionTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 
		 
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResult=CommonCISValidation.loginValidation(userId,password,accountType,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
		     DigihealthCareLoginWebservice loginService= new DigihealthCareLoginWebservice();
		     cisResult  = loginService.login(userId,password,accountType);
		  }
		  
		  
		// Capture Service End time
		  String serviceEndTime=time.getTimeZone();
		  long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Total service time for login service in milli seconds :: " +result );
		 return returnJsonData(cisResult);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
