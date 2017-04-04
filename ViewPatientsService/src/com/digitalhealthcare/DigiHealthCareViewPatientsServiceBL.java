package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;


public class DigiHealthCareViewPatientsServiceBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareViewPatientsServiceDAO viewPatientsServiceDAO=(DigiHealthCareViewPatientsServiceDAO)ctx.getBean("viewPatients");

	public CISResults viewPatients(DigihealthCareSaveProfile viewPatients){
		final Logger logger = Logger.getLogger(DigiHealthCareGetProfileDataBL.class);
		 
		CISResults cisResult = viewPatientsServiceDAO.viewPatients(viewPatients.getAppId(),viewPatients.getUserId(),viewPatients.getAccountType(),viewPatients.getFirstName(),viewPatients.getLastName(),viewPatients.getPhoneNumber(),viewPatients.getPassword(),viewPatients.getEmailId(),viewPatients.getGender(),viewPatients.getPhoto(),viewPatients.getDob(),viewPatients.getDate());
		logger.info("DigitalHealthCare:viewpatientsBL  service" +cisResult );
		return cisResult;
	}


}