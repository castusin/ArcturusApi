package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;



public class DigihealthCareRequestOTPDAO extends JdbcDaoSupport{
	
	public CISResults requestOTP(String phoneNumber,String emailId,int otpId,String otpdateTime,String deleteInd) {
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigihealthCareRequestOTPQuery.SQL_REQUEST_OPT,phoneNumber,emailId,otpId,otpdateTime,deleteInd);		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to access db");
		}
   		return cisResults;  
   	}

	public CISResults validateOTPTime(String contact, String emailId,
			String deleteInd) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		DigihealthCareValidateOTP verifyModel;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{contact,emailId,deleteInd};
		try{	
			verifyModel=(DigihealthCareValidateOTP)getJdbcTemplate().queryForObject(DigihealthCareValidateOTPQuery.SQL_GET_OTP,inputs,new DigihealthCareGetOTPMapper());
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
