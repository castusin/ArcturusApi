package com.digitalhealthcare;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.SMSCommunication;
import com.cis.testServiceTime;
/**
 * User Login Service. Validates password and generates session id
 * 
 * @author Castus Info Solutions
 *
 */

public class DigihealthCareLoginBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareLoginDAO loginDAO=(DigihealthCareLoginDAO)ctx.getBean("loginDAO");

	/**
	 * Validates password and generates session id
	 * @param userId
	 * @param password
	 * @param accountType
	 * @return
	 * @throws Throwable
	 */
	public CISResults login(String userId,String password,String accountType) throws Throwable {
		final Logger logger = Logger.getLogger(DigihealthCareLoginBL.class);
		List<DigiHealthCareViewPatientsService> patientDetails = null;
		CISResults cisResult = loginDAO.login(userId,password,accountType);
		
		if(accountType.contentEquals(CISConstants.FAMILY_FLAG)){
		   if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
			 patientDetails=loginDAO.getCareTakerPatientDetails(userId);
			 cisResult.setPatientDetails(patientDetails);
		     }
		}
		
		
		if(cisResult.getResponseCode().contentEquals(CISConstants.RESPONSE_SUCCESS)){
			   String sessionId = UUID.randomUUID().toString();
			   Calendar currentdate = Calendar.getInstance();
			   DateFormat formatter = new SimpleDateFormat(CISConstants.DATE_FORMAT);
			   TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
			   formatter.setTimeZone(obj);
			   String sessionTime=formatter.format(currentdate.getTime());
			   String deleteInd=CISConstants.DELETE_IND;
			   DigihealthCareSaveProfile userDetails=(DigihealthCareSaveProfile)cisResult.getResultObject();
			   userDetails.setSessionId(sessionId);
			   userDetails.setSessionTimeStamp(sessionTime);  
			   userDetails.setPassword("");
			   loginDAO.sessionEntry(userId,sessionId,sessionTime,deleteInd);
		}
		
		return cisResult;
	}
}