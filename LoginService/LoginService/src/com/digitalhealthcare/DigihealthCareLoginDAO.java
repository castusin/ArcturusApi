package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;

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
		DigihealthCareSaveProfile loginModel;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{userId,password,accountType};
		try{	
			loginModel=(DigihealthCareSaveProfile)getJdbcTemplate().queryForObject(DigihealthCareLoginQuery.SQL_LOGIN,inputs,new DigiHealthCareSaveProfileMapper());
			
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
	//HomeCareRegistration homeCareRegistration=new HomeCareRegistration();
		CISResults cisResults=new CISResults();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigihealthCareRequestOTPQuery.SQL_REQUEST_OPT,phoneNumber,emailId,otpId,dateFormat.format(cal.getTime()));
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
		// TODO Auto-generated method stub
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigitalHealthCareSessionsQuery.SQL_CREATE_SESSION,userId,sessionId,sessionTime,deleteInd);
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}
	
	
	public List<DigiHealthCareViewPatientsService> getCareTakerPatientDetails(
			String famiyUserId) {
		// TODO Auto-generated method stub
		List<DigiHealthCareViewPatientsService> result = null;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{famiyUserId};
		try{
			result = getJdbcTemplate().query(DigiHealthCareAccountExistQuery.SQL_GET_CARETAKER_PATIENTDETAILS,inputs,new DigiHealthCareViewPatientsServiceMapper());
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
  		return result; 
	}

	
}