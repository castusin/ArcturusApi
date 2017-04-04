package com.digitalhealthcare;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCareSaveProfileDAO extends JdbcDaoSupport {


	public CISResults healthCareRegistration(String appId, String userId,String accountType,
			String firstName, String lastName, String  phoneNumber,String password,
			String emailId, String gender,String photo,String dob, String date,String sessionId) {
		
		CISResults cisResults=new CISResults();
		String contact=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigitHealthCareSaveProfileQuery.SQL_GETHOMECAREREGISTRATION,appId,userId,accountType,firstName,lastName,contact,password,emailId,gender,photo,dob,date );
			
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
		// TODO Auto-generated method stub
		DigihealthCareSaveProfile registerPassword;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{password,userId};
		
		try{
			
			getJdbcTemplate().update(DigiHealthCareUpdatePasswordServiceQuery.SQL_UPDATEPASSWORD,inputs);		
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}

	public List<DigitalHalthCareTakersModel> getPatientId(String phoneNumber) {
		// TODO Auto-generated method stub
		List<DigitalHalthCareTakersModel> result = null;
		String contact=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{contact};
		try{
			result = getJdbcTemplate().query(DigiHealthCareAccountExistQuery.SQL_CHECK_CARETAKERS,inputs,new DigitalHealthCareIsCareTakerMapper());
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
  		return result; 
	
	}

	public CISResults healthCareFamilyMapping(String userId, String patientId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigitHealthCareSaveProfileQuery.SQL_FAMILYMAPPING,patientId,userId);
			
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
		try{
			getJdbcTemplate().update(DigitalHealthCareSessionsQuery.SQL_CREATE_DEVICE,famiyUserId,deviceToken,status,deviceType,dateTime,deviceId);
		
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
