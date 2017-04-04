package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import COM.CIS.CISResults;



import com.digitalhealthcare.DigiHealthCareGetProfileDataWebservice;
import com.google.gson.Gson;

@RestController
public class DigitalHealthCareGetProfileDataRest {
	 @RequestMapping(value="/getProfileData",method=RequestMethod.GET,produces={"application/json"})

	 public String getProfileData(@RequestParam ("phoneNumber") String phoneNumber){
		 Logger logger = Logger.getLogger(DigitalHealthCareGetProfileDataRest.class);
		 // 
		  
		 DigiHealthCareGetProfileDataWebservice profileWebService= new DigiHealthCareGetProfileDataWebservice();
		  CISResults otResults  = profileWebService.getProfileData(phoneNumber);
		  logger.info(" DigitalHealthCare:ProfileData :"+otResults);
		  return returnJsonData(otResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
