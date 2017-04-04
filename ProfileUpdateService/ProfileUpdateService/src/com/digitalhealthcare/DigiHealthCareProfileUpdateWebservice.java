package com.digitalhealthcare;


import org.apache.log4j.Logger;


import com.cis.CISResults;
/**
 * Profile Update Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
public class DigiHealthCareProfileUpdateWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareProfileUpdateWebservice.class);
	DigiHealthCareProfileUpdateBL profileUpdateBL=new DigiHealthCareProfileUpdateBL();

	/**
	 * @param updateProfile
	 * @return
	 */
	public CISResults updateProfile(DigihealthCareSaveProfile updateProfile) {
		
		 CISResults cisResult = null;
		try {
			cisResult = profileUpdateBL.updateProfile(updateProfile);
			 logger.info(" DigitalHealthCare:Request OTP :"+cisResult);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cisResult;
	}


}
