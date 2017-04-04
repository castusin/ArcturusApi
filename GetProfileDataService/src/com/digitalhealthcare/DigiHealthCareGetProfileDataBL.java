package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;
/**
 * Get Profile  Service
 * 
 * @author Castus Info Solutions
 *
 */

public class DigiHealthCareGetProfileDataBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareGetProfileDataDAO profileDAO=(DigiHealthCareGetProfileDataDAO)ctx.getBean("profileDAO");

	/**
	 * @param userId
	 * @return
	 */
	public CISResults getProfileData(String userId) {
		final Logger logger = Logger.getLogger(DigiHealthCareGetProfileDataBL.class);
		 
		CISResults cisResult = profileDAO.getProfileData(userId);
		logger.info("DigitalHealthCare:ProfileDataBL  service" +cisResult );
		return cisResult;
	}


}