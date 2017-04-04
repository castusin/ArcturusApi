package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;



import com.digitalhealthcare.DigiHealthCareGetContentDataWebservice;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;
/**
 * Rest Controller : Get Content Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareGetContentRest {

	 /**
	 * @param userId
	 * @param contentName
	 *  * @return returns 1 in case of error or 0 and content display
	 */
	@RequestMapping(value="/getContentData",method=RequestMethod.GET,produces={"application/json"})

	 public String getContentData(@RequestParam ("userId") String userId, @RequestParam ("contentName") String contentName,@RequestParam ("sessionId") String sessionId){
		 Logger logger = Logger.getLogger(DigitalHealthCareGetContentRest.class);
			String getContentParameters = "userId=" +userId + "&contentName=" + contentName ;
			 logger.info(" DigitalHealthCare:Request OTP :"+getContentParameters);
		logger.info(" DigitalHealthCare:contentData :"+getContentParameters);
		
        CommonCISValidation CommonCISValidation=new CommonCISValidation();
		
		CISResults cisResults=CommonCISValidation.getContentValidation(userId,sessionId);
		if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
		DigiHealthCareGetContentDataWebservice getContentDataWebService= new DigiHealthCareGetContentDataWebservice();
		  cisResults  = getContentDataWebService.getContentData(userId,contentName);
		  logger.info(" DigitalHealthCare:contentData :"+cisResults);
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