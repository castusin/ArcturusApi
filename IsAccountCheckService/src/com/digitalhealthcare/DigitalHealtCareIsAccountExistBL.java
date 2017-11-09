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
import com.cis.TimeCheck;
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
	 * @param deviceType 
		 * @return returns 1 in case of error or 0 if successful
		 */
	
	public CISResults isAccountExists(String phoneNumber,String deviceId, String deviceType)  {
		// TODO Auto-generated method stub
	//	SMSCommunication smsCommunicaiton = new SMSCommunication();
		
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		
		  Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	      formatter.setTimeZone(obj);
	      String createDate=formatter.format(currentdate.getTime());
		
		final Logger logger = Logger.getLogger(DigitalHealtCareIsAccountExistBL.class);
	    String contactNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber; 
		
	    CISResults cisResult = isAccountExistDAO.isAccountExists(contactNumber);
		
		logger.debug("DigitalHealthCare:IsAccountExists BL service" +cisResult );
		
		
		// Device check
	
				 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
				 {		
					 if(contactNumber.equalsIgnoreCase(CISConstants.TESTACCOUNT))
						{
							cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
						}
					 else {
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
					 
						 	if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
						 		{
						 		// Add device id here
						         //userid,deviceID,deviceType
						 		String deviceToken=CISConstants.DEVICETOKEN;
						 		String status=CISConstants.DEVICESTATUS;
						 		
						 		cisResult  = isAccountExistDAO.getUserDetails(userId,deviceToken,status,deviceType,createDate,deviceId);
						 
						 		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
						 		cisResult.setErrorMessage(CISConstants.NO_DEVICE_ID);
						 		cisResult.setResultObject(accountExistModel);
					   
						 		}
					 
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
		 String serviceEndTime=time.getTimeZone();
		  long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for is account exist service:: " +result );
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
