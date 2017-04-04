package com.digitalhealthcare;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;

public class DigiHealthCareAdminAddCareTakerBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml");
	DigiHealthCareAdminAddCareTakerDAO adminCareTakerDAO=(DigiHealthCareAdminAddCareTakerDAO)ctx.getBean("addCaretaker");

	
	

	public CISResults addCareTakers(String userId, String phoneNumber) {
		// TODO Auto-generated method stub
		
		 CISResults cisResult = adminCareTakerDAO.iscareTakerExists(userId,phoneNumber);
		    
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  { 
		    cisResult = adminCareTakerDAO.addCareTakers(userId,phoneNumber);
		    cisResult = adminCareTakerDAO.getFmId(phoneNumber);
		    if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			  {   
		        DigihealthCareSaveProfile digicareTakerId=(DigihealthCareSaveProfile)cisResult.getResultObject();
		        String careTakerId=digicareTakerId.getUserId();
		        cisResult = adminCareTakerDAO.healthCareFamilyMapping(careTakerId,userId);
			  }
		    if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
			  {
		    	cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		    	
			  }
		    
		  }
		 
		 
		 
		return cisResult;
	}

}
