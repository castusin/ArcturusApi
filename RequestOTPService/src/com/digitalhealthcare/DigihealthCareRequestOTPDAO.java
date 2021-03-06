package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;



public class DigihealthCareRequestOTPDAO extends JdbcDaoSupport{
	
	public CISResults requestOTP(String phoneNumber,String emailId,int otpId,String otpdateTime,String deleteInd) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigihealthCareRequestOTPDAO.class);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigihealthCareRequestOTPQuery.SQL_REQUEST_OPT,phoneNumber,emailId,otpId,otpdateTime,deleteInd);		
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("request otp query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to access db");
		}
   		return cisResults;  
   	}

	public CISResults validateOTPTime(String contact, String emailId,
			String deleteInd) {
		Logger logger = Logger.getLogger(DigihealthCareRequestOTPDAO.class);
		CISResults cisResults=new CISResults();
		DigihealthCareValidateOTP verifyModel;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{contact,emailId,deleteInd};
		try{	
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			verifyModel=(DigihealthCareValidateOTP)getJdbcTemplate().queryForObject(DigihealthCareValidateOTPQuery.SQL_GET_OTP,inputs,new DigihealthCareGetOTPMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("get otp query time:: " +result);
			if(verifyModel!=null){		
				cisResults.setResultObject(verifyModel);
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS4);
		}
		
		return cisResults;
	}
}
