package com.digitalhealthcare;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

@RestController
public class DigiHealthCareViewPatientsRestService {

	
	
	@RequestMapping(value="/viewPatients",method=RequestMethod.GET,produces={"application/json"})
	
		public String viewPatients(HttpServletRequest request, DigihealthCareSaveProfile viewPatients){	 
		 Logger logger = Logger.getLogger(DigitalHealthCareGetProfileDataRest.class);
		 /*String requestParameters = "firstName=" + firstName + "&lastName=" +lastName + "&phoneNumber="+phoneNumber+ "&emailId="+emailId+ "&gender="+gender;*/
		  //logger.info("Digital HealthCare view patients Request Parameters :"+requestParameters);
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		 CISResults cisResults=CommonCISValidation.viewPatientsValidation(request,viewPatients);
		if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			 DigiHealthCareViewPatientsServiceWebservice patientsServiceWebservice= new DigiHealthCareViewPatientsServiceWebservice();
			   cisResults  = patientsServiceWebservice.viewPatients(viewPatients);
		  logger.info(" DigitalHealthCare:viewPatients :"+cisResults);
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
