/**
 * 
 */
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

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


public class DigihealthCareSaveFeedBackDAO extends JdbcDaoSupport {

	/**
	 * @param userId
	 * @param feedBackSet
	 * @param ServiceProvideBy
	 * @param serviceDate
	 * @param feedbackDate
	 * @return
	 */
	public CISResults saveFeedbackInfo(String userId,String feedBackSet,String ServiceProvideBy,String serviceDate,String feedbackDate) {
		Logger logger = Logger.getLogger(DigihealthCareSaveFeedBackDAO.class);
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigihealthCareSaveFeedBackQuery.SQL_SAVEFEEDBACK_INFO,userId,feedBackSet,ServiceProvideBy,serviceDate,feedbackDate);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("save feedback info query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}

	public CISResults saveFeedbackDetails(String userId, String feedbackDate,
			String questionId, String questionName, String questionResponse) {
		
		Logger logger = Logger.getLogger(DigihealthCareSaveFeedBackDAO.class);
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigihealthCareSaveFeedBackQuery.SQL_SAVEFEEDBACK_DETAILS,userId,feedbackDate,questionId,questionName,questionResponse);
			String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("save feedback details query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
	}

}
