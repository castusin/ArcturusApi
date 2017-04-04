package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.testServiceTime;
/**
 * Adds country code to phone number and checks if account exists 
 * @author Castus Info Solutions
 *
 */
public class DigitalHealtCareIsAccountExistBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	
	DigitalHealthCareIsAccountExistDAO isAccountExistDAO=(DigitalHealthCareIsAccountExistDAO)ctx.getBean("AccountExist");

	 /**
	  * Adds country code to phone number and checks if account exists 
		 * @param phoneNumber user phone number
		 * @return returns 1 in case of error or 0 if successful
		 */
	
	public CISResults isAccountExists(String phoneNumber,String deviceId)  {
		// TODO Auto-generated method stub
	//	SMSCommunication smsCommunicaiton = new SMSCommunication();
		
		// Capture service Start time
				 testServiceTime seriveTimeCheck=new testServiceTime();
				 Calendar current = Calendar.getInstance();
			      DateFormat formatterTime = new SimpleDateFormat(CISConstants.DATE_FORMAT);
			      TimeZone objTime = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
			      formatterTime.setTimeZone( objTime);
			    //  System.out.println("Local:: " +current.getTime());
			    //  System.out.println("CST:: "+ formatterTime.format(current.getTime()));
				  String serviceStartTime=formatterTime.format(current.getTime());
		
		
		
		final Logger logger = Logger.getLogger(DigitalHealtCareIsAccountExistBL.class);
	    String contactNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber; 
		CISResults cisResult = isAccountExistDAO.isAccountExists(contactNumber);
		
		logger.debug("DigitalHealthCare:IsAccountExists BL service" +cisResult );
		
		
		// Device check
		
				 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
				 {		
					 
					 DigitalHealthCareIsAccountExistModel accountExistModel=(DigitalHealthCareIsAccountExistModel)cisResult.getResultObject();
					 String userId = accountExistModel.getUserId();	 	
					 String password = accountExistModel.getPassword();	
					 if(password.equalsIgnoreCase(CISConstants.NO))
					 {
						 cisResult  = isAccountExistDAO.checkPhoneNumberDeviceId(deviceId);
					
					 }
					 if(password.equalsIgnoreCase(CISConstants.YES))
					 {
						 cisResult  = isAccountExistDAO.checkDeviceId(userId,deviceId);
					 
					 }
					 
					 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
					 {
						 cisResult.setResultObject(accountExistModel);
					 }
					 
					 
					 
				 }
		
		
		
		
		
		
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE)&&  (cisResult.getErrorMessage().equalsIgnoreCase(CISConstants.ACCOUNT_STATUS2))) 
		  {
			 
			    cisResult  = isAccountExistDAO.checkPhoneNumberDeviceId(deviceId);
			
			    if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			    {	
			    cisResult = isAccountExistDAO.checkCareTakerDetails(contactNumber);
			    }
			 
			 
		  }
		
		
		
		
		
		// Capture Service End time
		  Calendar ServiceEnd= Calendar.getInstance();
	      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj1 = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	      formatter1.setTimeZone(obj1);
		  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
		  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		
		return cisResult;
	}

	
	
	
	
	
	
	
	public CISResults checkPhoneNumberDeviceId(String phoneNumber,
			String deviceId) {
		// TODO Auto-generated method stub
		CISResults cisResult = new CISResults();
		
		 cisResult  = isAccountExistDAO.checkPhoneNumberDeviceId(deviceId);
		
		return cisResult;
	}








	public CISResults checkDeviceId(String userId, String deviceId) {
		// TODO Auto-generated method stub
		CISResults cisResult = new CISResults();
		
		 cisResult  = isAccountExistDAO.checkDeviceId(userId,deviceId);
		
		return cisResult;
	}
	
	
	
	

}
