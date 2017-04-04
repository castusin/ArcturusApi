package com.digitalhealthcare;


import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;




import com.cis.CISConstants;
import com.cis.CISResults;
import com.digitalhealthcare.DigihealthCareSaveProfile;

/**
 * Get Profile  Service
 * 
 * @author Castus Info Solutions
 *
 */
public class DigiHealthCareGetProfileDataDAO extends JdbcDaoSupport {

	/**
	 * @param userId
	 * @return
	 */
	public CISResults getProfileData(String userId) {
		DigihealthCareSaveProfile profileData;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		Object[] inputs = new Object[]{userId};
		try{
			
			profileData=(DigihealthCareSaveProfile)getJdbcTemplate().queryForObject(DigiHealthCareGetProfileDataQuery.SQL_PROFILEDATA,inputs,new DigiHealthCareSaveProfileMapper());
			profileData.setUserId(profileData.getUserId());
			profileData.setFirstName(profileData.getFirstName());
			profileData.setLastName(profileData.getLastName());
			profileData.setEmailId(profileData.getEmailId());	
			profileData.setPhoneNumber(profileData.getPhoneNumber());
			
			cisResults.setResultObject(profileData);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}

   		return cisResults;  
	}


}