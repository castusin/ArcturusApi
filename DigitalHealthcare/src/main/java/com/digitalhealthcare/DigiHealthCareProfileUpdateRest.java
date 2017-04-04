package com.digitalhealthcare;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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
 * Rest Controller : Profile Update Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareProfileUpdateRest {

	/**
	 * @param request
	 * @param updateProfile
	 *  * @return returns 1 in case of error or 0 if successful
	 */
	@RequestMapping(value="/updateProfile",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)

	 public String updateProfile(HttpServletRequest request,@RequestBody DigihealthCareSaveProfile updateProfile){	 
		 Logger logger = Logger.getLogger(DigitalHealthCareGetContentRest.class);
			String requestParameters = "appId=" + updateProfile.appId + "&userId=" + updateProfile.userId + "&firstName=" +           
					updateProfile.firstName +"&lastName=" +updateProfile.lastName + "&phoneNumber="+updateProfile.phoneNumber+ "&emailId="+updateProfile.emailId+ "&photo="+updateProfile.photo+ "&accountType="+updateProfile.accountType+ "&gender="+updateProfile.gender+ "&dob="+updateProfile.dob+ "&date="+updateProfile.date;
			 logger.info("Digital HealthCare UpdateProfile Request Parameters :"+requestParameters);
		 
			 String sessionId=updateProfile.getSessionId();
			 String userId=updateProfile.getUserId();
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		CISResults cisResult=CommonCISValidation.updateProfileValidation(updateProfile,request,userId,sessionId);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
		      DigiHealthCareProfileUpdateWebservice profileUpdateWebservice= new DigiHealthCareProfileUpdateWebservice();
		       cisResult = profileUpdateWebservice.updateProfile(updateProfile);
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