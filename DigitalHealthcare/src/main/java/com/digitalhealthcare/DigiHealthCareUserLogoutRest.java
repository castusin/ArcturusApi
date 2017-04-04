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
 * Rest Controller : User Logout Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */


@RestController
public class DigiHealthCareUserLogoutRest {
	/**
	 * @param request
	 * @param userId
	 * @param sessionId
	 *  * @return returns 1 in case of error or 0 if successful
	 */
	@RequestMapping(value="/userLogout",method=RequestMethod.GET,produces={"application/json"})


	 public String userLogout(HttpServletRequest request,@RequestParam ("userId") String userId,@RequestParam ("sessionId") String sessionId){
		 Logger logger = Logger.getLogger(DigiHealthCareUserLogoutRest.class);
		 String userLogoutParameters = "userId=" +userId + "&sessionId=" + sessionId;
		 logger.info(" DigitalHealthCare:isAccountExists :"+userLogoutParameters);
		 // Make sure input parameters are valid
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 
		 CISResults cisResult=CommonCISValidation.userLogOut(userId,sessionId,request);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			  DigihealthCareUserLogoutWebservice userLogoutWebservice = new DigihealthCareUserLogoutWebservice();
			  cisResult  = userLogoutWebservice.userLogout(userId,sessionId);
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
