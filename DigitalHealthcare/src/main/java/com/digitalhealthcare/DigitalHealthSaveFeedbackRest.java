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
import com.digitalhealthcare.DigihealthCareSaveFeedBack;
import com.digitalhealthcare.DigihealthCareSaveFeedBackWebservice;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * Rest Controller : Save Feedback service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigitalHealthSaveFeedbackRest {

	
	/**
	 * @param request
	 * @param saveFeedback
	 *  * @return returns 1 in case of error or 0 if successful
	 */
	@RequestMapping(value="/saveFeedback",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public String saveFeedback(HttpServletRequest request,@RequestBody DigihealthCareSaveFeedBack saveFeedback){
	
		Logger logger = Logger.getLogger(DigitalHealthSaveFeedbackRest.class);
		String requestParameters = "appId=" + saveFeedback.appId + "&userId=" + saveFeedback.userId + "&firstName=" +           
				saveFeedback.firstName +"&lastName=" +saveFeedback.lastName + "&phoneNumber="+saveFeedback.phoneNumber+ "&emailId="+saveFeedback.emailId+ "&sessionId="+saveFeedback.sessionId+ "&feedbackSet="+saveFeedback.feedbackSet+ "&serviceProvideBy="+saveFeedback.serviceProvideBy+ "&serviceDate="+saveFeedback.serviceDate;
		logger.info("Digital HealthCare SaveFeedback Request Parameters :"+requestParameters);
		CommonCISValidation CommonCISValidation=new CommonCISValidation();
		String sessionId=saveFeedback.getSessionId();
		String userId=saveFeedback.getUserId();
		CISResults cisResult=CommonCISValidation.saveFeedbackValidation(saveFeedback,request,userId,sessionId);
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
		DigihealthCareSaveFeedBackWebservice saveFeedBackWebservice = new DigihealthCareSaveFeedBackWebservice();
		cisResult = saveFeedBackWebservice.saveFeedback(saveFeedback);
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
