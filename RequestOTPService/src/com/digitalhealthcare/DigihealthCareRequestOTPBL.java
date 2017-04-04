package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SMSCommunication;
import com.cis.checkOTPTime;
import com.cis.testServiceTime;


/**
 * Generates OTP (currently using java random methods, but will move to other API later )
 * 
 * @author Castus info solutions
 *
 */


public class DigihealthCareRequestOTPBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareRequestOTPDAO otpDAO=(DigihealthCareRequestOTPDAO)ctx.getBean("RequestotpDAO");
	

	/**
	 * Generates OTP. SMS OTP to phone number. saves in the database (currently using java random methods, but will move to other API later )
	 * @param phoneNumber
	 * @param emailId - Not supported in this version
	 * @return 0-Success,1-Error
	 */
	public CISResults requestOTP(String phoneNumber,String emailId) throws Throwable  {
		SMSCommunication smsCommunicaiton=new SMSCommunication();
		      final Logger logger = Logger.getLogger(DigihealthCareRequestOTPBL.class);
		      checkOTPTime otpTimeCheck=new checkOTPTime();
		   // Capture service Start time
				 testServiceTime seriveTimeCheck=new testServiceTime();
				 Calendar current = Calendar.getInstance();
			      DateFormat formatterTime = new SimpleDateFormat(CISConstants.DATE_FORMAT);
			      TimeZone objTime = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
			      formatterTime.setTimeZone( objTime);
			    //  System.out.println("Local:: " +current.getTime());
			    //  System.out.println("CST:: "+ formatterTime.format(current.getTime()));
				  String serviceStartTime=formatterTime.format(current.getTime());
		      
		      
		      
		      String contact = CISConstants.USA_COUNTRY_CODE+phoneNumber;
		      String deleteInd=CISConstants.DELETE_IND;
			 
		      Calendar currentdate = Calendar.getInstance();
		      DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		      formatter.setTimeZone(obj);
		      
		      Random random = new Random( System.currentTimeMillis() );
			  int otpNumber= ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
			  
			  
			  CISResults cisResults = otpDAO.validateOTPTime(contact,emailId,deleteInd);
			 
			  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			  {
			     DigihealthCareValidateOTP validate=(DigihealthCareValidateOTP)cisResults.getResultObject();
			     otpNumber=Integer.parseInt(validate.getOtp());
			     cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);
			  }
			  else
			  {
				  cisResults=smsCommunicaiton.sendSMS(contact,otpNumber);
				  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
				  {
			        cisResults = otpDAO.requestOTP(contact,emailId,otpNumber,formatter.format(currentdate.getTime()),deleteInd);
			        cisResults.setResultObject(cisResults);
				  }
			  }
	
				// Capture Service End time
			  Calendar ServiceEnd= Calendar.getInstance();
		      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		      TimeZone obj1 = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		      formatter1.setTimeZone(obj1);
			  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
			  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  
			  
			  
			  
			  
			  
		return cisResults;
		
	}

}
