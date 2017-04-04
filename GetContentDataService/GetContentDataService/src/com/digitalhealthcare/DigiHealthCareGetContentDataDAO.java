package com.digitalhealthcare;


import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCareGetContentDataDAO extends JdbcDaoSupport {

	public CISResults getContentData(String userId,String contentName) {
		DigiHealthCareSaveContent saveContentModel;
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		Object[] inputs = new Object[]{contentName};
		try{
			
			saveContentModel=(DigiHealthCareSaveContent)getJdbcTemplate().queryForObject(DigiHealthCareGetContentDataQuery.SQL_GETCONTENTDATA,inputs,new DigiHealthCareSaveContentMapper());
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