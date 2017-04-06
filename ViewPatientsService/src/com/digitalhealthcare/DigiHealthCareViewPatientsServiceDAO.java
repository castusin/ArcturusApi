package com.digitalhealthcare;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.digitalhealthcare.DigihealthCareSaveProfile;


public class DigiHealthCareViewPatientsServiceDAO extends JdbcDaoSupport {


	public CISResults viewPatients(String appId, String userId,String accountType, String firstName, String lastName,String phoneNumber, String password, String emailId, String gender,
			String photo, String dob, Date date) {
		Logger logger = Logger.getLogger(DigiHealthCareViewPatientsServiceDAO.class);
		DigihealthCareSaveProfile viewPatients=new DigihealthCareSaveProfile();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		accountType="P";
		Object[] inputs = new Object[]{accountType};
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			List result=getJdbcTemplate().query(DigiHealthCareViewPatientsServiceQuery.SQL_VIEWPATIENTS,inputs,new DigiHealthCareSaveProfileMapper());
			String serviceEndTime=time.getTimeZone();
			long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("view patients query time:: " +results);
			cisResults.setResultObject(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}


}