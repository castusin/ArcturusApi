package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;

public class DigihealthCareAdminCreateServiceBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml");
	DigihealthCareAdminCreateServiceDAO adminCreateServiceDAO=(DigihealthCareAdminCreateServiceDAO)ctx.getBean("savePatient");


	public CISResults addPatients(DigihealthCareSaveProfile savePatient) {
	
		  Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone("CST");
	      formatter.setTimeZone(obj);
	      String saveDate=formatter.format(currentdate.getTime());
	      String careTakerphone="";
	      String sessionId = UUID.randomUUID().toString();
	     /* String sessionId = UUID.randomUUID().toString();
		  String deleteInd=CISConstants.DELETE_IND;
		  String userId=DigestUtils.sha1Hex(sessionId);*/
	      /*Random rnd = new Random();
	      int userId = 100000 + rnd.nextInt(900000);*/
	      String userId=DigestUtils.sha1Hex(sessionId);
	      String upToNCharacters = userId.substring(0, Math.min(userId.length(), 8));
	      userId=upToNCharacters;
	      String contact = savePatient.getPhoneNumber();
	      String phoneNumber=CISConstants.USA_COUNTRY_CODE+contact;
		
	      CISResults cisResult = adminCreateServiceDAO.isAccountExists(phoneNumber);
	      if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	         cisResult = adminCreateServiceDAO.addPatients(savePatient.getAppId(),userId,savePatient.getAccountType(),savePatient.getFirstName(),savePatient.getLastName(),phoneNumber,savePatient.getPassword(),savePatient.getEmailId(),savePatient.getGender(),savePatient.getPhoto(),savePatient.getDob(),saveDate,sessionId);
		  }
		
		return cisResult;
		
	}

}
