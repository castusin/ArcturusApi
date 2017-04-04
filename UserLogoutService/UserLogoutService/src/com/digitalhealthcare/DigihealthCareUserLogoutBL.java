package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;

/**
 * User Logout Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */

public class DigihealthCareUserLogoutBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareUserLogoutDAO userLogoutDAO=(DigihealthCareUserLogoutDAO)ctx.getBean("userLogoutDAO");

	/**
	 * @param userId
	 * @param sessionId
	 * @return
	 */
	public CISResults userLogout(String userId,String sessionId) {
		final Logger logger = Logger.getLogger(DigiHealthCareSaveContentBL.class);
		//HomeCareRegistration homeCareRegistration=new HomeCareRegistration();
		DigihealthCareUserLogout userLogout=new DigihealthCareUserLogout();
		
		String sessionStatus=CISConstants.DELETE_IND_Y;
		CISResults cisResult = userLogoutDAO.userLogout(userId,sessionId,sessionStatus);
		
		
		logger.debug("DigitalHealthCare:save content dao service" +cisResult );
		/* if(OTConstants.YES.equalsIgnoreCase(userType))
         { */
       
        // }
		return cisResult;
	}

}
