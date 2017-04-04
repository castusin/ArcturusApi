package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.testServiceTime;
import com.digitalhealthcare.DigihealthCareSaveFeedBack;
import com.digitalhealthcare.DigihealthCareSaveFeedBackWebservice;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;


@RestController
public class DigitalHealthAdminCreateRestService {

	
	@RequestMapping(value="/addPatients",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	 public String addPatients(HttpServletRequest request,@RequestBody DigihealthCareSaveProfile savePatient){
	
		// Capture service Start time
				 testServiceTime sessionTimeCheck=new testServiceTime();
				 Calendar currentdate = Calendar.getInstance();
			      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
			      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
			      formatter.setTimeZone(obj);
			      System.out.println("Local:: " +currentdate.getTime());
			      System.out.println("CST:: "+ formatter.format(currentdate.getTime()));
				  String serviceStartTime=formatter.format(currentdate.getTime());
				  
		Logger logger = Logger.getLogger(DigitalHealthSaveFeedbackRest.class);
		/*String requestParameters = "patientId=" + savePatient.patientId + "&firstName=" + savePatient.firstName + "&lastName=" +           
				savePatient.lastName +"&phoneNumber=" +savePatient.phoneNumber + "&emailId="+savePatient.emailId+ "&type="+savePatient.type+ "&age="+savePatient.age+ "&gender="+savePatient.gender;
		logger.info("Digital HealthCare add patient Request Parameters :"+requestParameters);*/
		CommonCISValidation CommonCISValidation=new CommonCISValidation();
		
		CISResults cisResult=CommonCISValidation.addPatientValidation(savePatient,request);
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
		DigihealthCareAdminCreateServiceWebservice adminCreateServiceWebservice = new DigihealthCareAdminCreateServiceWebservice();
		 cisResult = adminCreateServiceWebservice.addPatients(savePatient);
		 }
		
		// Capture Service End time
		  Calendar ServiceEnd= Calendar.getInstance();
	      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj1 = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	      formatter1.setTimeZone(obj1);
		  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
		  sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  
		return returnJsonData(cisResult);
		

	}
	
	private String returnJsonData(Object src){
		// TODO Auto-generated method stub
        Gson gson = new Gson();
		String feeds = gson.toJson(src);
		return feeds;
	}
}
