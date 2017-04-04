package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;




import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCareSaveContentDAO extends JdbcDaoSupport {
	
	public CISResults saveContent(String userId,String contentName,String contentType, String contentText, String urlType) {
		DigiHealthCareSaveContent saveContentModel=new DigiHealthCareSaveContent();
		CISResults cisResults=new CISResults();
		/* String uniqueiD = UUID.randomUUID().toString();
			String uniqueID=DigestUtils.sha1Hex(uniqueiD);
			String upToNCharacters = uniqueID.substring(0, Math.min(uniqueID.length(), 4));
			//String otpId="O"+upToNCharacters; 
			String userID="U"+upToNCharacters; */
			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{userId,medicoId,patientName,password,phoneNumber,emailId,otp};
		try{
			
			getJdbcTemplate().update(DigiHealthCareSaveContentQuery.SQL_SAVECONTENT,userId,contentName,contentType,contentText,urlType,dateFormat.format(cal.getTime()));
			
			saveContentModel.setUserId(userId);
			saveContentModel.setContentName(contentName);
			saveContentModel.setContentType(contentType);
			saveContentModel.setContentText(contentText);
			saveContentModel.setUrlType(urlType);
			
			
			cisResults.setResultObject(saveContentModel);
			
				
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to login to the system");
		}

   		return cisResults;  
	}


}
