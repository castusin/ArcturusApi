/**
 * 
 */
package com.digitalhealthcare;

import org.apache.log4j.Logger;

import com.cis.CISResults;
/**
 * Save Feedback service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */


public class DigihealthCareSaveFeedBackWebservice {

	/**
	 * @param saveFeedback
	 * @return
	 */
	public CISResults saveFeedback(DigihealthCareSaveFeedBack saveFeedback) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(DigihealthCareSaveFeedBackWebservice.class);
		DigihealthCareSaveFeedBackBL saveFeedBackBl = new DigihealthCareSaveFeedBackBL();
		CISResults cisResult = saveFeedBackBl.saveFeedback(saveFeedback);	
		 logger.info("Digital HealthCare Save Feedback Webservice:: " +cisResult );
		 return cisResult;
	}

}
