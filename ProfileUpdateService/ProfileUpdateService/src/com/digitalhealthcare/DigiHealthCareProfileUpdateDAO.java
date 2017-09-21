package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
/**
 * Rest Controller : Profile Update Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
public class DigiHealthCareProfileUpdateDAO extends JdbcDaoSupport {

	/**
	 * @param appId
	 * @param userId
	 * @param medicalId
	 * @param accountType
	 * @param firstName
	 * @param lastName
	 * @param emailId
	 * @param gender
	 * @param photo
	 * @param dob
	 * @return
	 */


	public CISResults updateProfile(String appId, String phoneNumber,
			String userId, String accountType, String firstName,
			String lastName, String emailId, String gender, String photo,
			String dob, String address, String landmark, String city,
			String state, String county, String zipcode, float lattitude,
			float longitude) {
		DigihealthCareSaveProfile profileUpdate=new DigihealthCareSaveProfile();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		Logger logger = Logger.getLogger(DigiHealthCareProfileUpdateDAO.class);
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{appId,accountType,firstName,lastName,emailId,gender,photo,dob,dateFormat.format(cal.getTime()),address,landmark,city,state,county,zipcode,lattitude,longitude,userId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
		getJdbcTemplate().update(DigiHealthCareProfileUpdateQuery.SQL_UPDATEPROFILE,inputs);
		 String serviceEndTime=time.getTimeZone();
		 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 logger.info("update profile query time:: " +result);
			profileUpdate.setFirstName(firstName);
			profileUpdate.setLastName(lastName);
			profileUpdate.setAppId(appId);
			profileUpdate.setAccountType(accountType);
			profileUpdate.setPhoneNumber(phoneNumber);
			profileUpdate.setEmailId(emailId);
			profileUpdate.setUserId(userId);
			profileUpdate.setGender(gender);
			profileUpdate.setPhoto(photo);
			profileUpdate.setDob(dob);
			cisResults.setResultObject(profileUpdate);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Data Access Error");
		}

   		return cisResults;  
	}

	

	
}

