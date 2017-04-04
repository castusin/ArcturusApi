package com.digitalhealthcare;

/**
 * User Login Service
 * 
 * @author Castus Info Solutions
 *
 */
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigihealthCareLoginWebservice {

	static Logger logger = Logger.getLogger(DigihealthCareValidateOTPWebservice.class);
	DigihealthCareLoginBL loginPBL=new DigihealthCareLoginBL();

	/**
	 * User login service
	 * @param userId
	 * @param password
	 * @param accountType
	 * @return
	 * @throws Throwable
	 */
	public CISResults login(String userId,String password,String accountType) throws Throwable {
		 CISResults cisResult = loginPBL.login(userId,password,accountType);
		 logger.info(" DigitalHealthCare:loginWS :"+cisResult);
		return cisResult;
	}
}