package com.digitalhealthcare;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareSaveProfileDAO extends JdbcDaoSupport {


	public CISResults healthCareRegistration(String appId, String userId,String accountType,
			String firstName, String lastName, String  phoneNumber,String password,
			String emailId, String gender,String photo,String dob, String date,String sessionId) {
		Logger logger = Logger.getLogger(DigiHealthCareSaveProfileDAO.class);
		CISResults cisResults=new CISResults();
		String contact=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigitHealthCareSaveProfileQuery.SQL_GETHOMECAREREGISTRATION,appId,userId,accountType,firstName,lastName,contact,password,emailId,gender,photo,dob,date );
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("save profile data query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}

	public CISResults healthCareUpdateProfile(String appId, String userId,
			String accountType, String firstName, String lastName,
			String phoneNumber, String password, String emailId, String gender,
			String photo, String dob, String format, String sessionId) {
		Logger logger = Logger.getLogger(DigiHealthCareSaveProfileDAO.class);
		DigihealthCareSaveProfile registerPassword;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{password,userId};
		
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigiHealthCareUpdatePasswordServiceQuery.SQL_UPDATEPASSWORD,inputs);		
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("save profile data query time:: " +result);
			 logger.info("update passeord query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}

	public List<DigitalHalthCareTakersModel> getPatientId(String phoneNumber) {
		Logger logger = Logger.getLogger(DigiHealthCareSaveProfileDAO.class);
		List<DigitalHalthCareTakersModel> result = null;
		String contact=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{contact};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			result = getJdbcTemplate().query(DigiHealthCareAccountExistQuery.SQL_CHECK_CARETAKERS,inputs,new DigitalHealthCareIsCareTakerMapper());
			 String serviceEndTime=time.getTimeZone();
			 long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("check care takers query time:: " +results);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
  		return result; 
	
	}

	public CISResults healthCareFamilyMapping(String userId, String patientId) {
		Logger logger = Logger.getLogger(DigiHealthCareSaveProfileDAO.class);
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigitHealthCareSaveProfileQuery.SQL_FAMILYMAPPING,patientId,userId);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("family mapping query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}

	public CISResults deviceEntry(String famiyUserId,String deviceId, String deviceType,
			String deviceToken, String status, String dateTime) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareSaveProfileDAO.class);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigitalHealthCareSessionsQuery.SQL_CREATE_DEVICE,famiyUserId,deviceToken,status,deviceType,dateTime,deviceId);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("create device query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}

	
	
	public List<DigiHealthCareViewPatientsService> getCareTakerPatientDetails(
			String famiyUserId) {
		Logger logger = Logger.getLogger(DigiHealthCareSaveProfileDAO.class);
		List<DigiHealthCareViewPatientsService> result = null;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{famiyUserId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			result = getJdbcTemplate().query(DigiHealthCareAccountExistQuery.SQL_GET_CARETAKER_PATIENTDETAILS,inputs,new DigiHealthCareViewPatientsServiceMapper());
			 String serviceEndTime=time.getTimeZone();
			 long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("get care taker patient details query time:: " +results);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
  		return result; 
	}

	
	
	
	
	
	
	
}
