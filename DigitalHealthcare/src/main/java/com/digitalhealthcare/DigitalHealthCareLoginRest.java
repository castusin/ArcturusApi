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
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResult=CommonCISValidation.loginValidation(userId,password,accountType,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
		     DigihealthCareLoginWebservice loginService= new DigihealthCareLoginWebservice();
		     cisResult  = loginService.login(userId,password,accountType);
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
