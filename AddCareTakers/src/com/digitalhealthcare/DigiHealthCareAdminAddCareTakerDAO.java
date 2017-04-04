/**
 * 
 */
package com.digitalhealthcare;

import com.cis.CISConstants;
import com.cis.CISResults;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * @author Darshan
 *
 */
public class DigiHealthCareAdminAddCareTakerDAO extends JdbcDaoSupport {

	public CISResults addCareTakers(String userId, String phoneNumber) {
		// TODO Auto-generated method stub
		DigiHealthCareAdminAddCareTakerModel addCareTakers=new DigiHealthCareAdminAddCareTakerModel();
		String careTakerNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigiHealthCareAdminAddCareTakerQuery.SQL_ADD_CARETAKER,userId,careTakerNumber);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

 		return cisResults; 
	}

	public CISResults iscareTakerExists(String userId, String phoneNumber) {
		// TODO Auto-generated method stub

		DigiHealthCareAdminAddCareTakerModel verifyPhoneNumber;
		CISResults cisResults=new CISResults();
		String careTakerNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{userId,careTakerNumber};
		try{
			 verifyPhoneNumber=(DigiHealthCareAdminAddCareTakerModel)getJdbcTemplate().queryForObject(DigiHealthCareAdminAddCareTakerQuery.SQL_CHECK_CARETAKER,inputs,new DigitalHealthCareIsCareTakerExistMapper());
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

	public CISResults getFmId(String phoneNumber) {
		// TODO Auto-generated method stub
		DigihealthCareSaveProfile profileData;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String careTakerNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		String accounType="F";
		Object[] inputs = new Object[]{careTakerNumber,accounType};
		try{
			
			profileData=(DigihealthCareSaveProfile)getJdbcTemplate().queryForObject(DigiHealthCareGetProfileDataQuery.SQL_CARETAKER_ID,inputs,new DigiHealthCareSaveProfileMapper());
			if(profileData!=null){		
				cisResults.setResultObject(profileData);
			}
			
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}

   		return cisResults;  
	}

	public CISResults healthCareFamilyMapping(String careTakerUserId,
			String userId) {
		// TODO Auto-generated method stub
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			getJdbcTemplate().update(DigitHealthCareSaveProfileQuery.SQL_FAMILYMAPPING,userId,careTakerUserId);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;
		
	}
	}

	

