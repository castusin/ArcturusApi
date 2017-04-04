package com.digitalhealthcare;




import java.util.Calendar;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;










import com.cis.CISConstants;
import com.cis.CISResults;
import com.digitalhealthcare.DigihealthCareSaveProfile;


public class DigihealthCareForgotPasswordDAO extends JdbcDaoSupport {

	public CISResults forgotPassword(String emailId,String phoneNumber,int otpNumber, String otpdateTime, String deleteInd) {
		DigihealthCareSaveProfile forgotPassword;
		CISResults cisResult=new CISResults();
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			
			getJdbcTemplate().update(DigihealthCareForgotPasswordQuery.SQL_FORGOT_OTP,phoneNumber,emailId,otpNumber,otpdateTime,deleteInd);		
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResult.setErrorMessage("Failed to login to the system");
		}

   		return cisResult;  
	}

	public CISResults validateOTPTime(String contact, String emailId,
			String deleteInd) {
		// TODO Auto-generated method stub
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