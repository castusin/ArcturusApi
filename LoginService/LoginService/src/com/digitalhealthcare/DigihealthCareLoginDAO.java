package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

/**
 * User Login Service : Checks user id and password in the database. generates OTP
 * 
 * @author Castus Info Solutions
 *
 */
public class DigihealthCareLoginDAO extends JdbcDaoSupport {
	
	/**
	 * User Login Service : Checks user id and password in the database
	 * @param userId
	 * @param password
	 * @param accountType
	 * @return 0-Success,1-Error
	 */
	public CISResults login(String userId,String password,String accountType) {
		
		Logger logger = Logger.getLogger(DigihealthCareLoginDAO.class);
		DigihealthCareSaveProfile loginModel;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{userId,password,accountType};
		try{	
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			loginModel=(DigihealthCareSaveProfile)getJdbcTemplate().queryForObject(DigihealthCareLoginQuery.SQL_LOGIN,inputs,new DigiHealthCareSaveProfileMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("login  query time:: " +result);
			if(loginModel!=null){
				cisResults.setResultObject(loginModel);
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants. USER_LOGIN_STATUS);
		}

   		return cisResults;  
	}

	/**
	 * This service inserts OTP into database
	 * @param phoneNumber
	 * @param emailId
	 * @param otpId generated 
	 * @return 0-Sucess,1-Error
	 */
	public CISResults requestOTP(String phoneNumber,String emailId,int otpId) {
		
		Logger logger = Logger.getLogger(DigihealthCareLoginDAO.class);
	//HomeCareRegistration homeCareRegistration=new HomeCareRegistration();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigihealthCareRequestOTPQuery.SQL_REQUEST_OPT,phoneNumber,emailId,otpId,dateFormat.format(cal.getTime()));
			String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("request otp  query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}
		return cisResults;  
	}

	/**
	 * Inserts new session id into database.
	 * @param userId
	 * @param sessionId
	 * @param sessionTime - time when session id is generated
	 * @param deleteInd - N- session id active,Y-session is inactive
	 * @return 0-Sucess,1-Error
	 */
	public CISResults sessionEntry(String userId, String sessionId,String sessionTime,String deleteInd) {
		Logger logger = Logger.getLogger(DigihealthCareLoginDAO.class);
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigitalHealthCareSessionsQuery.SQL_CREATE_SESSION,userId,sessionId,sessionTime,deleteInd);
			String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("create session  query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}
	
	
	public List<DigiHealthCareViewPatientsService> getCareTakerPatientDetails(
			String famiyUserId) {
		Logger logger = Logger.getLogger(DigihealthCareLoginDAO.class);
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
			 logger.info("Get caretaker patient details  query time:: " +results);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
  		return result; 
	}

	
}