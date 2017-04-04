package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.cis.CISResults;

public class DigiHealthCareSaveContentBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareSaveContentDAO saveContentDAO=(DigiHealthCareSaveContentDAO)ctx.getBean("saveContentDAO");

	public CISResults saveContent(String userId,String contentName,String contentType, String contentText, String urlType) {
		final Logger logger = Logger.getLogger(DigiHealthCareSaveContentBL.class);
		//HomeCareRegistration homeCareRegistration=new HomeCareRegistration();
		
		
		CISResults cisResult = saveContentDAO.saveContent(userId,contentName,contentType,contentText,urlType);
		
		
		logger.debug("DigitalHealthCare:save content dao service" +cisResult );
		/* if(OTConstants.YES.equalsIgnoreCase(userType))
         { */
       
        // }
		return cisResult;
	}

}
