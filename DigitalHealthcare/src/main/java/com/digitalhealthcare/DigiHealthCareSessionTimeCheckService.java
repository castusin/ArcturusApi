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
import com.cis.CISSessionWebservice;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Session Time check service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareSessionTimeCheckService {
	 /**
	 * @param request
	 * @param userId
	 * @param sessionId
	 *  * @return returns 1 in case of error or 0 if successful
	 */
	/**
	 * @param request
	 * @param userId
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value="/checkSession",method=RequestMethod.GET,produces={"application/json"})

	 public String checkSession(HttpServletRequest request,@RequestParam ("userId") String userId,@RequestParam ("sessionId") String sessionId){
		 Logger logger = Logger.getLogger(DigiHealthCareSessionTimeCheckService.class);
		 logger.info(" DigitalHealthCare: SessionCheck UserId ::"+userId);
		 logger.info(" DigitalHealthCare: SessionCheck SessionId :: "+sessionId);
		 CISSessionWebservice cisSession= new CISSessionWebservice();
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResult=CommonCISValidation.checkSessionValidations(userId,sessionId,request);
		  /*if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			  cisResult  = cisSession.getSessionDetails(userId,sessionId);
		  }*/
		  return returnJsonData(cisResult);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}

}
