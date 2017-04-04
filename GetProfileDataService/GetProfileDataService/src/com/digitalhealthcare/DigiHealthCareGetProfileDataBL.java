package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import COM.CIS.CISResults;


public class DigiHealthCareGetProfileDataBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareGetProfileDataDAO profileDAO=(DigiHealthCareGetProfileDataDAO)ctx.getBean("profileDAO");

	public CISResults getProfileData(String phoneNumber) {
		final Logger logger = Logger.getLogger(DigiHealthCareGetProfileDataBL.class);
		 
		CISResults otResult = profileDAO.getProfileData(phoneNumber);
		logger.info("DigitalHealthCare:ProfileDataBL  service" +otResult );
		return otResult;
	}


}