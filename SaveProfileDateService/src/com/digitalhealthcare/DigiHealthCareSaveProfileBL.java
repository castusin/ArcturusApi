package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.testServiceTime;

public class DigiHealthCareSaveProfileBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareSaveProfileDAO homeCareDAOReg=(DigiHealthCareSaveProfileDAO)ctx.getBean("DigiSaveProfile");
	DigihealthCareLoginDAO sessionDAO=(DigihealthCareLoginDAO)ctx.getBean("loginDAO");

	public CISResults healthCareRegistration(DigihealthCareSaveProfile registration) {
		  DigitalHalthCareTakersModel careTakers = new DigitalHalthCareTakersModel();
		  CISResults cisResult = new CISResults();
		  List<DigiHealthCareViewPatientsService> patientDetails = null;
		// Capture service Start time
		  testServiceTime seriveTimeCheck=new testServiceTime();
		  Calendar current = Calendar.getInstance();
	      DateFormat formatterTime = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone objTime = TimeZone.getTimeZone("CST");
	      formatterTime.setTimeZone( objTime);
	      System.out.println("Local:: " +current.getTime());
	      System.out.println("CST:: "+ formatterTime.format(current.getTime()));
		  String serviceStartTime=formatterTime.format(current.getTime());
		
		
		  final Logger logger = Logger.getLogger(DigiHealthCareSaveProfileBL.class);
		  DigihealthCareSaveProfile homeCareRegistration=new DigihealthCareSaveProfile();
		  Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone("CST");
	      formatter.setTimeZone(obj);
	      System.out.println("Local:: " +currentdate.getTime());
	      System.out.println("CST:: "+ formatter.format(currentdate.getTime()));
		  String sessionId = UUID.randomUUID().toString();
		  String deleteInd=CISConstants.DELETE_IND;
		  String userId=DigestUtils.sha1Hex(sessionId);
		  String upToNCharacters = userId.substring(0, Math.min(userId.length(), 8));
		  
		  if(registration.getAccountType().contentEquals(CISConstants.PATIENT_FLAG))
		  {
			   //Update password in profile_table
			 cisResult = homeCareDAOReg.healthCareUpdateProfile(registration.getAppId(),registration.getUserId(),registration.getAccountType(),registration.getFirstName(),registration.getLastName(),registration.getPhoneNumber(),registration.getPassword(),registration.getEmailId(),registration.getGender(),registration.getPhoto(),registration.getDob(),formatter.format(currentdate.getTime()),sessionId);
		 
			  if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
				    cisResult = sessionDAO.sessionEntry(registration.getUserId(),sessionId,formatter.format(currentdate.getTime()),deleteInd);
					cisResult = homeCareDAOReg.deviceEntry(registration.getUserId(),registration.getDeviceId(),registration.getDeviceType(),registration.getDeviceToken(),registration.getStatus(),formatter.format(currentdate.getTime()));
				    homeCareRegistration.setFirstName(registration.getFirstName());
					homeCareRegistration.setLastName(registration.getLastName());
					homeCareRegistration.setPhoneNumber(registration.getPhoneNumber());
					homeCareRegistration.setEmailId(registration.getEmailId());
					homeCareRegistration.setUserId(registration.getUserId());
					homeCareRegistration.setSessionId(sessionId);
					homeCareRegistration.setSessionTimeStamp(formatter.format(currentdate.getTime()));
					cisResult.setResultObject(homeCareRegistration);
				  }
		  
		  
		  }
		  if(registration.getAccountType().contentEquals(CISConstants.FAMILY_FLAG))
		  {
			  //Generate userId and save family member details in profile table
			  //get patient_fm table patiner userid's array based on phonenumber
			  // save userid and patientId in Patiner_fm table
			 
			  String famiyUserId = upToNCharacters;
			  String patient;
			  cisResult = homeCareDAOReg.healthCareRegistration(registration.getAppId(),famiyUserId,registration.getAccountType(),registration.getFirstName(),registration.getLastName(),registration.getPhoneNumber(),registration.getPassword(),registration.getEmailId(),registration.getGender(),registration.getPhoto(),registration.getDob(),formatter.format(currentdate.getTime()),sessionId);
			  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			    {
				
				  List<DigitalHalthCareTakersModel> resultList = homeCareDAOReg.getPatientId(registration.getPhoneNumber());
				 
				  for (int x=0; x<resultList.size(); x++)
				  { 
					   patient=((DigitalHalthCareTakersModel)resultList.get(x)).patientId;
					  cisResult = homeCareDAOReg.healthCareFamilyMapping(famiyUserId,patient);
				  }
			    }
			
			  if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
				 
				    cisResult = sessionDAO.sessionEntry(famiyUserId,sessionId,formatter.format(currentdate.getTime()),deleteInd);
				  
			  }   
			  
			  if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
			  
				    cisResult = homeCareDAOReg.deviceEntry(famiyUserId,registration.getDeviceId(),registration.getDeviceType(),registration.getDeviceToken(),registration.getStatus(),formatter.format(currentdate.getTime()));
			  }
			  
			  if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
				  // Get Patient details 
				  patientDetails=homeCareDAOReg.getCareTakerPatientDetails(famiyUserId);
			  } 
				  	
				  	homeCareRegistration.setFirstName(registration.getFirstName());
					homeCareRegistration.setLastName(registration.getLastName());
					homeCareRegistration.setPhoneNumber(registration.getPhoneNumber());
					homeCareRegistration.setEmailId(registration.getEmailId());
					homeCareRegistration.setUserId(famiyUserId);
					homeCareRegistration.setSessionId(sessionId);
					homeCareRegistration.setSessionTimeStamp(formatter.format(currentdate.getTime()));
					cisResult.setResultObject(homeCareRegistration);
					cisResult.setPatientDetails(patientDetails);
				  
		  
		  }
		
		// Capture Service End time
		  Calendar ServiceEnd= Calendar.getInstance();
	      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj1 = TimeZone.getTimeZone("CST");
	      formatter1.setTimeZone(obj1);
		  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
		  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  
		  
		logger.debug("Digital HealthCare Rigistration BL service" +cisResult );
		return cisResult;
	}

}
