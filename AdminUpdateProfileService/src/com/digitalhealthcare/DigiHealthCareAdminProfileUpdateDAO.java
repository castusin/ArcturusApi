package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.cis.CISConstants;
import com.cis.CISResults;
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
public class DigiHealthCareAdminProfileUpdateDAO extends JdbcDaoSupport {

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
/*	public CISResults updateProfile(String appId,String userId,String accountType,String firstName,String lastName,String emailId,String gender,String photo,String dob ) {
		DigihealthCareSaveProfile profileUpdate=new DigihealthCareSaveProfile();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{appId,medicalId,accountType,firstName,lastName,emailId,gender,photo,dob,dateFormat.format(cal.getTime()),userId};
		Object[] inputs = new Object[]{appId,accountType,firstName,lastName,emailId,gender,photo,dob,dateFormat.format(cal.getTime()),userId};
		try{
			getJdbcTemplate().update(DigiHealthCareProfileUpdateQuery.SQL_UPDATEPROFILE,inputs);
			
			profileUpdate.setFirstName(firstName);
			profileUpdate.setLastName(lastName);
			
			profileUpdate.setEmailId(emailId);
			profileUpdate.setUserId(userId);
			profileUpdate.setGender(gender);
			
			profileUpdate.setDob(dob);
			cisResults.setResultObject(profileUpdate);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Data Access Error");
		}

   		return cisResults;  
	}*/

	public CISResults updateProfile(String appId, String userId,String accountType, String firstName, String lastName,
			String phoneNumber, String emailId, String gender,String photo, String dob) {
		DigiHealthCareAdminProfileUpdate profileUpdate=new DigiHealthCareAdminProfileUpdate();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{appId,accountType,firstName,lastName,phoneNumber,emailId,gender,photo,dob,dateFormat.format(cal.getTime()),userId};
		try{
		getJdbcTemplate().update(DigiHealthCareAdminProfileUpdateQuery.SQL_ADMINUPDATEPROFILE,inputs);
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

