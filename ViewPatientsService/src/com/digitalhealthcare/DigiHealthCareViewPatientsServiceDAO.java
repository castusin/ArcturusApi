package com.digitalhealthcare;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.digitalhealthcare.DigihealthCareSaveProfile;


public class DigiHealthCareViewPatientsServiceDAO extends JdbcDaoSupport {


	public CISResults viewPatients(String appId, String userId,String accountType, String firstName, String lastName,String phoneNumber, String password, String emailId, String gender,
			String photo, String dob, Date date) {
		// TODO Auto-generated method stub
		DigihealthCareSaveProfile viewPatients=new DigihealthCareSaveProfile();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		accountType="P";
		Object[] inputs = new Object[]{accountType};
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			
			List result=getJdbcTemplate().query(DigiHealthCareViewPatientsServiceQuery.SQL_VIEWPATIENTS,inputs,new DigiHealthCareSaveProfileMapper());
			
			cisResults.setResultObject(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}


}