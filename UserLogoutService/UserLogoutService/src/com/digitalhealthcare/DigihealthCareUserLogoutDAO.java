package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

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

public class DigihealthCareUserLogoutDAO extends JdbcDaoSupport {
	
	/**
	 * @param userId
	 * @param sessionId
	 * @param sessionStatus
	 * @return
	 */
	public CISResults userLogout(String userId,String sessionId, String sessionStatus) {
		DigihealthCareUserLogout userLogout=new DigihealthCareUserLogout();
		CISResults cisResults=new CISResults();
		
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		
		Object[] inputs = new Object[]{sessionStatus,userId,sessionId};
		try{
			
			getJdbcTemplate().update(DigihealthCareUserLogoutQuery.SQL_USERLOGOUT,inputs);
			
		
			
				
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}

	



}
/*Object[] input = new Object[]{userId,sessionId};


try{
	
	userLogout=(DigihealthCareUserLogout)getJdbcTemplate().queryForObject(DigihealthCareUserLogoutQuery.SQL_GETDELETEIND,input, new DigihealthCareUserLogoutMapper());
	
	userLogout.setDeleteInd(userLogout.getDeleteInd());
	
	if(sessionId==deleteInd){
		cisResults.setResponseCode(CISConstants.DELETE_IND_Y);
		}
	userLogout.setUserId(userId);
	userLogout.setSessionId(sessionId);
	
	cisResults.setResultObject(userLogout);
		
} catch (DataAccessException e) {
	e.printStackTrace();

	cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
	cisResults.setErrorMessage("Failed to login to the system");
}*/