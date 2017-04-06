package com.digitalhealthcare;


import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
/**
 * Validates OTP 
 * @author Castus Info Solutions
 *
 */

public class DigihealthCareValidateOTPDAO extends JdbcDaoSupport {
	
	/**
	 * @param phoneNumber
	 * @param emailId
	 * @param otp
	 * @param deleteInd
	 * @return
	 */
	public CISResults validateOTP(String phoneNumber,String emailId,String otp,String deleteInd) {
		DigihealthCareValidateOTP verifyModel;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{phoneNumber,otp,deleteInd};
		Logger logger = Logger.getLogger(DigihealthCareValidateOTPDAO.class);
		try{	
			TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			verifyModel=(DigihealthCareValidateOTP)getJdbcTemplate().queryForObject(DigihealthCareValidateOTPQuery.SQL_VALIDATE_OPT,inputs,new DigihealthCareValidateOTPMapper());
			String serviceEndTime=time.getTimeZone();
			long result=sessionTimeCheck.getServiceTime(serviceStartTime,serviceEndTime);
			 logger.info("validate otp query time:: " +result);
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