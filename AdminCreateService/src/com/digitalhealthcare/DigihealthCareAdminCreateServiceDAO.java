package com.digitalhealthcare;

import com.cis.CISResults;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;


	public class DigihealthCareAdminCreateServiceDAO extends JdbcDaoSupport {

		/*public CISResults addPatients(int patientId, String firstName,String lastName, String phoneNumber, String emailId,String type, String age, String gender, String saveDate) {
			// TODO Auto-generated method stub
			CISResults cisResults=new CISResults();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			try{
				getJdbcTemplate().update(DigihealthCareAdminCreateServiceQuery.SQL_PATIENT_INFO,patientId,firstName,lastName,phoneNumber,emailId,type,age,gender,saveDate);
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			
				cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResults.setErrorMessage("Failed At DataAccess");
			}

	   		return cisResults; 
			
		}*/


	/*	public CISResults saveCareTakerDetails(String patientId, String careTakerphone) {
			
			
			DigihealthCareAdminCreateService savePatient=new DigihealthCareAdminCreateService();
			
		      String phoneNumber=CISConstants.USA_COUNTRY_CODE+careTakerphone;
			CISResults cisResults=new CISResults();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			try{
				getJdbcTemplate().update(DigihealthCareAdminCreateServiceQuery.SQL_CARETAKERS_DETAILS,patientId,phoneNumber);
				
			} catch (DataAccessException e) {
				e.printStackTrace();
				cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResults.setErrorMessage("Failed At DataAccess");
			}

	   		return cisResults; 
		}
*/

		public CISResults addPatients(String appId, String userId,
				String accountType, String firstName, String lastName,
				String phoneNumber,  String password,
				String emailId, String gender, String photo, String dob,
				String saveDate, String sessionId) {
			CISResults cisResults=new CISResults();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			try{
				getJdbcTemplate().update(DigihealthCareAdminCreateServiceQuery.SQL_PATIENT_INFO,appId,userId,accountType,firstName,lastName,phoneNumber,password,emailId,gender,photo,dob,saveDate);
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			
				cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResults.setErrorMessage("Failed At DataAccess");
			}

	   		return cisResults; 
			
		}

		public CISResults isAccountExists(String phoneNumber) {
			// TODO Auto-generated method stub
			DigitalHealthCareIsAccountExistModel verifyPhoneNumber;
			CISResults cisResults=new CISResults();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String accountType="P";
			Object[] inputs = new Object[]{phoneNumber,accountType};
			try{
				 verifyPhoneNumber=(DigitalHealthCareIsAccountExistModel)getJdbcTemplate().queryForObject(DigiHealthCareAdminAddCareTakerQuery.SQL_CHECK_CARETAKER,inputs,new DigitalHealthCareIsCareTakerExistMapper());
				if(verifyPhoneNumber!=null){
					cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
					cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS5);
					//cisResults.setResultObject(verifyPhoneNumber);
				} 
			
				
				
			} catch (DataAccessException e) {
				e.printStackTrace();
				cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
				
			}
	   		return cisResults; 
		}


	}
