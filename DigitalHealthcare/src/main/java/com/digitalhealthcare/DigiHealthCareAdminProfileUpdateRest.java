/**
 * 
 */
package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * @author Darshan
 *
 */
@RestController
public class DigiHealthCareAdminProfileUpdateRest {
	@RequestMapping(value="/adminUpdateProfile",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)

	 public String updateProfile(HttpServletRequest request,@RequestBody DigiHealthCareAdminProfileUpdate adminUpdateProfile){	 
		 Logger logger = Logger.getLogger(DigitalHealthCareGetContentRest.class);
			String requestParameters = "appId=" + adminUpdateProfile.appId + "&userId=" + adminUpdateProfile.userId + "&firstName=" +           
					adminUpdateProfile.firstName +"&lastName=" +adminUpdateProfile.lastName + "&phoneNumber="+adminUpdateProfile.phoneNumber+ "&emailId="+adminUpdateProfile.emailId+ "&photo="+adminUpdateProfile.photo+ "&accountType="+adminUpdateProfile.accountType+ "&gender="+adminUpdateProfile.gender+ "&dob="+adminUpdateProfile.dob+ "&date="+adminUpdateProfile.date;
			 logger.info("Digital HealthCare UpdateProfile Request Parameters :"+requestParameters);
		 
			 String sessionId=adminUpdateProfile.getSessionId();
			 String userId=adminUpdateProfile.getUserId();
		 CommonCISValidation CommonCISValidation=new CommonCISValidation();
		CISResults cisResult=CommonCISValidation.adminUpdateProfileValidation(adminUpdateProfile,request,userId);
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			  DigiHealthCareAdminProfileUpdateWebservice profileUpdateWebservice= new DigiHealthCareAdminProfileUpdateWebservice();
		       cisResult = profileUpdateWebservice.updateProfile(adminUpdateProfile);
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
