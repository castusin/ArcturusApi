package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;


public class DigiHealthCareUpdatePasswordServiceBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	
	DigiHealthCareUpdatePasswordServiceDAO updatePasswordServiceDAO=(DigiHealthCareUpdatePasswordServiceDAO)ctx.getBean("UpdatePasswordDAO");

	public CISResults updatePassword(String userId,String password) {
		final Logger logger = Logger.getLogger(DigihealthCareForgotPasswordBL.class);
		  
		CISResults cisResult = updatePasswordServiceDAO.updatePassword(userId,password);
		logger.info("DigitalHealthCare:ProfileDataBL  service" +cisResult );
		
		return cisResult;
	}


}