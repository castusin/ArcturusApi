package com.digitalhealthcare;


import javax.servlet.http.HttpServletRequest;

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

@RestController
public class DigiHealthCareUpdatePasswordRestService {

	 
	@RequestMapping(value="/updatePassword",method=RequestMethod.GET,produces={"application/json"})

	 public String updatePassword(HttpServletRequest request,@RequestParam ("userId") String userId, @RequestParam ("password") String password){
		 Logger logger = Logger.getLogger(DigitalHealthCareGetContentRest.class);
			String getContentParameters = "userId=" +userId + "&password=" + password ;
			 logger.info(" DigitalHealthCare:Request OTP :"+getContentParameters);
		logger.info(" DigitalHealthCare:contentData :"+getContentParameters);
		
        CommonCISValidation CommonCISValidation=new CommonCISValidation();
		
		CISResults cisResults=CommonCISValidation.updatePasswordValidation(request,userId,password);
		if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
			DigiHealthCareUpdatePasswordServiceWebservice updatePasswordService= new DigiHealthCareUpdatePasswordServiceWebservice();
		  cisResults  = updatePasswordService.updatePassword(userId,password);
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