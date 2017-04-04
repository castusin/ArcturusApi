package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.cis.CISResults;



import com.digitalhealthcare.DigiHealthCareSaveContentWebservice;
import com.google.gson.Gson;
/**
 * Rest Controller : Save Content Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthCareSaveContentRest {
	@RequestMapping(value="/saveContent",method=RequestMethod.GET,produces={"application/json"})

	 public String saveContent(@RequestParam ("userId") String userId,@RequestParam ("contentName") String contentName,@RequestParam ("contentType") String contentType,@RequestParam ("contentText") String contentText,@RequestParam ("urlType") String urlType){
		 Logger logger = Logger.getLogger(DigitalHealthCareSaveContentRest.class);
		 // logger.debug(" OT:GetHomeCareRegistration :"+testId);
		  
		 DigiHealthCareSaveContentWebservice saveContentWebService = new DigiHealthCareSaveContentWebservice();
		  CISResults cisResults  = saveContentWebService.saveContent(userId,contentName,contentType,contentText,urlType);
		  logger.info(" DigitalHealthCare:save content :"+cisResults);
		  return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}