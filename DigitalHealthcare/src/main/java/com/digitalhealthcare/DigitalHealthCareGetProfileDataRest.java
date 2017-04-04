package com.digitalhealthcare;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;



import com.digitalhealthcare.DigiHealthCareGetProfileDataWebservice;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;
/**
 * Rest Controller : Get Profile  Service
 * 
 * @author Castus Info Solutions
 *
 */
@RestController
public class DigitalHealthCareGetProfileDataRest {
	
	
	/**
	 * @param userId
	 * @param sessionId
	 * @param request
	 *  * @return returns 1 in case of error or 0 if successful and response profile result object
	 */
	@RequestMapping(value="/getProfileData",method=RequestMethod.GET,produces={"application/json"})

	 public String getProfileData(@RequestParam ("userId") String userId,@RequestParam ("sessionId") String sessionId,HttpServletRequest request){
		 Logger logger = Logger.getLogger(DigitalHealthCareGetProfileDataRest.class);
		 String  getProfileDataServiceParameters = "userId=" +userId + "&sessionId=" + sessionId;
		 logger.info(" DigitalHealthCare: getProfileData Service : " +getProfileDataServiceParameters);
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResults=CommonCISValidation.getProfileValidation(userId,sessionId,request);
		 if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
		 DigiHealthCareGetProfileDataWebservice profileWebService= new DigiHealthCareGetProfileDataWebservice();
		  cisResults  = profileWebService.getProfileData(userId);
		  logger.info(" DigitalHealthCare:ProfileData :"+cisResults);
		  }
		  return returnJsonData(cisResults);
	 }
	 	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
