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


public class DigiHealthCareViewPatientsServiceBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareViewPatientsServiceDAO viewPatientsServiceDAO=(DigiHealthCareViewPatientsServiceDAO)ctx.getBean("viewPatients");

	public CISResults viewPatients(DigihealthCareSaveProfile viewPatients){
		
		// Capture service Start time
		TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		  
		final Logger logger = Logger.getLogger(DigiHealthCareGetProfileDataBL.class);
		 
		CISResults cisResult = viewPatientsServiceDAO.viewPatients(viewPatients.getAppId(),viewPatients.getUserId(),viewPatients.getAccountType(),viewPatients.getFirstName(),viewPatients.getLastName(),viewPatients.getPhoneNumber(),viewPatients.getPassword(),viewPatients.getEmailId(),viewPatients.getGender(),viewPatients.getPhoto(),viewPatients.getDob(),viewPatients.getDate());
		logger.info("DigitalHealthCare:viewpatientsBL  service" +cisResult );
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		  logger.info("Database time for view patients service:: " +result );
		  
		return cisResult;
	}


}