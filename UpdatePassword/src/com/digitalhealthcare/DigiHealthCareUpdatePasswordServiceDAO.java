package com.digitalhealthcare;


import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.digitalhealthcare.DigihealthCareSaveProfile;


public class DigiHealthCareUpdatePasswordServiceDAO extends JdbcDaoSupport {

	public CISResults updatePassword(String userId,String password) {
		
		CISResults cisResult=new CISResults();
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{password,userId};
		
		try{
			
			getJdbcTemplate().update(DigiHealthCareUpdatePasswordServiceQuery.SQL_UPDATEPASSWORD,inputs);		
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResult.setErrorMessage("Failed to login to the system");
		}

   		return cisResult;  
	}

	


}