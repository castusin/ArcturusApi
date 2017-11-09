/**
 * 
 */
package com.digitalhealthcare;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.CISSessionModel;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

/**
 * Queries database to check if accounts exists for the input phone number. 
 * @author Castus Info Solutions
 *
 */
public class DigitalHealthCareIsAccountExistDAO  extends JdbcDaoSupport{
	/**
	 * @param contactNumber
	 * @return Returns 0 if account exists , 1 if account doesn't exists
	 */
	public CISResults isAccountExists(String contactNumber) {
		Logger logger = Logger.getLogger(DigitalHealthCareIsAccountExistDAO.class);
		DigitalHealthCareIsAccountExistModel verifyPhoneNumber;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{contactNumber};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 verifyPhoneNumber=(DigitalHealthCareIsAccountExistModel)getJdbcTemplate().queryForObject(DigiHealthCareAccountExistQuery.SQL_VALIDATE_ACCOUNT,inputs,new DigitalHealthCareIsAccountExistMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Is account exist validate account query time:: " +result);
			 if(verifyPhoneNumber!=null){
				String password=verifyPhoneNumber.getPassword();
				if(password.contentEquals(""))
				{
					verifyPhoneNumber.setPassword(CISConstants.NO);
				}else
				{
				     verifyPhoneNumber.setPassword(CISConstants.YES);
				     
				}
				cisResults.setResultObject(verifyPhoneNumber);
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
   		return cisResults; 
	}

	

	/**
	 * @param contactNumber
	 * @return
	 */
	public CISResults checkCareTakerDetails(String contactNumber) {
		Logger logger = Logger.getLogger(DigitalHealthCareIsAccountExistDAO.class);
		DigitalHalthCareTakersModel digitalHalthCareTakersModel = new DigitalHalthCareTakersModel() ;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{contactNumber};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
		   	List result= getJdbcTemplate().query(DigiHealthCareAccountExistQuery.SQL_CHECK_CARETAKERS,inputs,new DigitalHealthCareIsCareTakerExistMapper());
		    String serviceEndTime=time.getTimeZone();
		    long results=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Is account exist Check care taker query time:: " +results);	
		   	if(result.size()!=0){
					digitalHalthCareTakersModel.setAccountType(CISConstants.FAMILY_FLAG);
					digitalHalthCareTakersModel.setPassword(CISConstants.NO);
					cisResults.setResultObject(digitalHalthCareTakersModel);
					 
					 
				}else{
					cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
					cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
				}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
   		return cisResults; 
	}



	public CISResults checkPhoneNumberDeviceId(
			String deviceId) {
		Logger logger = Logger.getLogger(DigitalHealthCareIsAccountExistDAO.class);
		DigitalHealthCareUserDeviceModel verifyDevice;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{deviceId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			verifyDevice=(DigitalHealthCareUserDeviceModel)getJdbcTemplate().queryForObject(DigiHealthCareAccountExistQuery.SQL_CHECK_DEVICE_PHONE,inputs,new DigitalHealthCareIsAccountExistDeviceUserIdMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Is account exist check device phonenumber query time:: " +result);
			if(verifyDevice!=null){
				//cisResults.setResultObject(verifyDevice);
				cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResults.setErrorMessage(CISConstants.DEVICE_SET_MESSAGE);
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			
		}
		return cisResults;
	}



	public CISResults checkDeviceId(String userId, String deviceId) {
		// TODO Auto-generated method stub
		DigitalHealthCareUserDeviceModel verifyDevice;
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{userId,deviceId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			verifyDevice=(DigitalHealthCareUserDeviceModel)getJdbcTemplate().queryForObject(DigiHealthCareAccountExistQuery.SQL_CHECK_DEVICEID,inputs,new DigitalHealthCareIsAccountExistDeviceUserIdMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Is account exist check device id query time:: " +result);
			if(verifyDevice!=null){
				//cisResults.setResultObject(verifyDevice);
				
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.DEVICE_SET_MESSAGE);
		}
		return cisResults;
	}



	public CISResults getUserDetails(String userId, String deviceToken, String status, String deviceType, String createDate, String deviceId) {


		Logger logger = Logger.getLogger(DigitalHealthCareIsAccountExistDAO.class);
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{userId,deviceToken,status,deviceType,createDate,deviceId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareAccountExistQuery.SQL_SAVEDEVICEID,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Is account exist deviceId query time:: " +result);
			
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS2);
		}
   		return cisResults; 
	}



	

}
