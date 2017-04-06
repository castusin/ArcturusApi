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
import com.cis.TimeCheck;
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
			  TimeCheck time=new TimeCheck();
				 testServiceTime seriveTimeCheck=new testServiceTime();
				 String serviceStartTime=time.getTimeZone();
		      
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
			  String serviceEndTime=time.getTimeZone();
			  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  logger.info("Database time for request otp service:: " +cisResults );
			
		return cisResults;
		
	}

}
