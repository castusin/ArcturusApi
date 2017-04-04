package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * Get Content Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
public class DigiHealthCareGetContentDataBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareGetContentDataDAO getContentDataDAO=(DigiHealthCareGetContentDataDAO)ctx.getBean("getContentDAO");

	/**
	 * @param userId
	 * @param contentName
	 * @return
	 */
	public CISResults getContentData(String userId,String contentName) {
		final Logger logger = Logger.getLogger(DigiHealthCareGetContentDataBL.class);
		 
		CISResults cisResult = getContentDataDAO.getContentData(userId,contentName);
		logger.info("DigitalHealthCare:contentData dao service" +cisResult );
		return cisResult;
	}


}