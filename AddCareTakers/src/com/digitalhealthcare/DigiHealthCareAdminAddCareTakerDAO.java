/**
 * 
 */
package com.digitalhealthcare;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * @author Darshan
 *
 */
public class DigiHealthCareAdminAddCareTakerDAO extends JdbcDaoSupport {

	public CISResults addCareTakers(String userId, String phoneNumber) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(DigiHealthCareAdminAddCareTakerDAO.class);
		DigiHealthCareAdminAddCareTakerModel addCareTakers=new DigiHealthCareAdminAddCareTakerModel();
		String careTakerNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareAdminAddCareTakerQuery.SQL_ADD_CARETAKER,userId,careTakerNumber);
			 String serviceEndTime=time.getTimeZone();
			long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Add care taker query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

 		return cisResults; 
	}

	public CISResults iscareTakerExists(String userId, String phoneNumber) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(DigihealthCareAdminCreateServiceBL.class);
		DigiHealthCareAdminAddCareTakerModel verifyPhoneNumber;
		CISResults cisResults=new CISResults();
		String careTakerNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{userId,careTakerNumber};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 verifyPhoneNumber=(DigiHealthCareAdminAddCareTakerModel)getJdbcTemplate().queryForObject(DigiHealthCareAdminAddCareTakerQuery.SQL_CHECK_CARETAKER,inputs,new DigitalHealthCareIsCareTakerExistMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("check care taker query time:: " +result);
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
		
		
		Logger logger = Logger.getLogger(DigihealthCareAdminCreateServiceBL.class);
		DigihealthCareSaveProfile profileData;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String careTakerNumber=CISConstants.USA_COUNTRY_CODE+phoneNumber;
		String accounType="F";
		Object[] inputs = new Object[]{careTakerNumber,accounType};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			profileData=(DigihealthCareSaveProfile)getJdbcTemplate().queryForObject(DigiHealthCareGetProfileDataQuery.SQL_CARETAKER_ID,inputs,new DigiHealthCareSaveProfileMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("check care taker id query time:: " +result);
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
		Logger logger = Logger.getLogger(DigihealthCareAdminCreateServiceBL.class);
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			getJdbcTemplate().update(DigitHealthCareSaveProfileQuery.SQL_FAMILYMAPPING,userId,careTakerUserId);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("family maping query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;
		
	}
	}

	

