/**
 * 
 */
package com.digitalhealthcare;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
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
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigihealthCareSaveFeedBackQuery.SQL_SAVEFEEDBACK_INFO,userId,feedBackSet,ServiceProvideBy,serviceDate,feedbackDate);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
		
	}

	public CISResults saveFeedbackDetails(String userId, String feedbackDate,
			String questionId, String questionName, String questionResponse) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigihealthCareSaveFeedBackQuery.SQL_SAVEFEEDBACK_DETAILS,userId,feedbackDate,questionId,questionName,questionResponse);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults; 
	}

}
