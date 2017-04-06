package com.digitalhealthcare;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SessionTimeCheck;
import com.cis.checkOTPTime;
/**
 * Validates OTP 
 * @author Castus Info Solutions
 *
 */

public class DigihealthCareValidateOTPBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareValidateOTPDAO verifyOTPDAO=(DigihealthCareValidateOTPDAO)ctx.getBean("validateotpDAO");

	/**
	 * @param phoneNumber
	 * @param emailId
	 * @param otp
	 * @return
	 */
	public CISResults validateOTP(String phoneNumber,String emailId,String otp) {
		final Logger logger = Logger.getLogger(DigihealthCareValidateOTPBL.class);
		checkOTPTime otpTimeCheck=new checkOTPTime();
		String contact=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		String deleteInd=CISConstants.DELETE_IND;
		 Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone("CST");
	      formatter.setTimeZone(obj);
	     
	    String OtpTimeGenerateTime;
		CISResults cisResult = verifyOTPDAO.validateOTP(contact,emailId,otp,deleteInd);
		logger.info("DigitalHealthCare:Validate OTP  BL service" +cisResult );
		if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
		 DigihealthCareValidateOTP validate=(DigihealthCareValidateOTP)cisResult.getResultObject();
		 OtpTimeGenerateTime=validate.getTimeStamp();
		  String currentDateTime = formatter.format(currentdate.getTime());
		  
		  cisResult=otpTimeCheck.getOTPTime(currentDateTime,OtpTimeGenerateTime);
		  
		}
		
		return cisResult;
	}


}