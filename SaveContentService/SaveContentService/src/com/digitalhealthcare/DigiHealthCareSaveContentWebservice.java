package com.digitalhealthcare;


import org.apache.log4j.Logger;



import com.cis.CISResults;

public class DigiHealthCareSaveContentWebservice {
	static Logger logger = Logger.getLogger(DigiHealthCareSaveContentWebservice.class);
	DigiHealthCareSaveContentBL saveContentBL=new DigiHealthCareSaveContentBL();

	public CISResults saveContent(String userId,String contentName,String contentType, String contentText, String urlType) {
		
		 CISResults cisResult = saveContentBL.saveContent(userId,contentName,contentType,contentText,urlType);
		 logger.debug(" DigitalHealthCare:save content :"+cisResult);
		return cisResult;
	}

	
}
