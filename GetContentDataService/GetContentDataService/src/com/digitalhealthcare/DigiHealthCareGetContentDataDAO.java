package com.digitalhealthcare;


import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareGetContentDataDAO extends JdbcDaoSupport {

	public CISResults getContentData(String userId,String contentName) {
		DigiHealthCareSaveContent saveContentModel;
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		Logger logger = Logger.getLogger(DigiHealthCareGetContentDataDAO.class);
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		Object[] inputs = new Object[]{contentName};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			saveContentModel=(DigiHealthCareSaveContent)getJdbcTemplate().queryForObject(DigiHealthCareGetContentDataQuery.SQL_GETCONTENTDATA,inputs,new DigiHealthCareSaveContentMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Get content data query time:: " +result);
			//saveContentModel.setUserId(saveContentModel.getUserId());
			saveContentModel.setContentName(saveContentModel.getContentName());
			saveContentModel.setContentText(saveContentModel.getContentText());
			
			cisResults.setResultObject(saveContentModel);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}


}