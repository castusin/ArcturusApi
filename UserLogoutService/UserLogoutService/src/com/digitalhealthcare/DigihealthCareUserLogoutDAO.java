package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

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
		Logger logger = Logger.getLogger(DigihealthCareUserLogoutDAO.class);
		
		Object[] inputs = new Object[]{sessionStatus,userId,sessionId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigihealthCareUserLogoutQuery.SQL_USERLOGOUT,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceStartTime,serviceEndTime);
			 logger.info("user logout query time:: " +result);
						
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}

	



}
