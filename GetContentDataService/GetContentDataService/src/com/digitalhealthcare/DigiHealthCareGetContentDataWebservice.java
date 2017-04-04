package com.digitalhealthcare;


import org.apache.log4j.Logger;

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

public class DigiHealthCareGetContentDataWebservice {

static Logger logger = Logger.getLogger(DigiHealthCareGetContentDataWebservice.class);
	
DigiHealthCareGetContentDataBL getContentDataBL=new DigiHealthCareGetContentDataBL();

	/**
	 * @param userId
	 * @param contentName
	 * @return
	 */
	public CISResults getContentData(String userId,String contentName) {
		 Logger logger = Logger.getLogger(DigiHealthCareGetContentDataWebservice.class);
		 CISResults cisResult = getContentDataBL.getContentData(userId,contentName);
		 logger.info(" DigitalHealthCare:contentDataBL :"+cisResult);
		return cisResult;
	}
}