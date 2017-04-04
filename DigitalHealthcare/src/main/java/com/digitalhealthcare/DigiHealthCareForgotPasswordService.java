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
public class DigiHealthCareForgotPasswordService {

	 
	@RequestMapping(value="/forgotPassword",method=RequestMethod.GET,produces={"application/json"})

	 public String forgotPassword(HttpServletRequest request,@RequestParam ("emailId") String emailId, @RequestParam ("phoneNumber") String phoneNumber){
		 Logger logger = Logger.getLogger(DigitalHealthCareGetContentRest.class);
			String getContentParameters = "emailId=" +emailId + "&phoneNumber=" + phoneNumber ;
			 logger.info(" DigitalHealthCare:Request OTP :"+getContentParameters);
		logger.info(" DigitalHealthCare:contentData :"+getContentParameters);
		
        CommonCISValidation CommonCISValidation=new CommonCISValidation();
		
		CISResults cisResults=CommonCISValidation.forgotPasswordValidation(request,emailId,phoneNumber);
		if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
			DigihealthCareForgotPasswordWebservice forgotPasswordWebservice= new DigihealthCareForgotPasswordWebservice();
		  cisResults  = forgotPasswordWebservice.forgotPassword(emailId,phoneNumber);
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