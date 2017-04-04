package com.digitalhealthcare;


import org.apache.log4j.Logger;


import com.cis.CISResults;

public class DigiHealthCareAdminProfileUpdateWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareProfileUpdateWebservice.class);
	DigiHealthCareAdminProfileUpdateBL profileUpdateBL=new DigiHealthCareAdminProfileUpdateBL();

	
	public CISResults updateProfile(DigiHealthCareAdminProfileUpdate adminUpdateProfile) {
		
		 CISResults cisResult = null;
		try {
			cisResult = profileUpdateBL.updateProfile(adminUpdateProfile);
			 logger.info(" DigitalHealthCare:Request OTP :"+cisResult);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cisResult;
	}


}
