package com.digitalhealthcare;


import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;




import COM.CIS.CISConstants;
import COM.CIS.CISResults;
import COM.DIGIHEALTHCARE.DigihealthCareSaveProfile;


public class DigiHealthCareGetProfileDataDAO extends JdbcDaoSupport {

	public CISResults getProfileData(String phoneNumber) {
		DigihealthCareSaveProfile profileData;
		CISResults otResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		
		otResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		Object[] inputs = new Object[]{phoneNumber};
		try{
			
			profileData=(DigihealthCareSaveProfile)getJdbcTemplate().queryForObject(DigiHealthCareGetProfileDataQuery.SQL_PROFILEDATA,inputs,new DigiHealthCareSaveContentMapper());
			profileData.setUserId(profileData.getUserId());
			profileData.setFirstName(profileData.getFirstName());
			profileData.setLastName(profileData.getLastName());
			profileData.setEmailId(profileData.getEmailId());	
			profileData.setPhoneNumber(profileData.getPhoneNumber());
			
			
			otResults.setResultObject(profileData);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			otResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			otResults.setErrorMessage("Failed to login to the system");
		}

   		return otResults;  
	}


}