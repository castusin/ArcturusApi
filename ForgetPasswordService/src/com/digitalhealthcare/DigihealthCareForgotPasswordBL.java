package com.digitalhealthcare;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;


public class DigihealthCareForgotPasswordBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigihealthCareForgotPasswordDAO forgotPasswordDAO=(DigihealthCareForgotPasswordDAO)ctx.getBean("PasswordDAO");

	public CISResults forgotPassword(String emailId,String phoneNumber) {
		final Logger logger = Logger.getLogger(DigihealthCareForgotPasswordBL.class);
		  EmailCommunication sendMail=new EmailCommunication();
		 String contact = CISConstants.USA_COUNTRY_CODE+phoneNumber;
	     String deleteInd=CISConstants.DELETE_IND;
		 
	      Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	      formatter.setTimeZone(obj);
	      
	      
	      Random random = new Random( System.currentTimeMillis() );
		  int otpNumber= ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
		  
		  CISResults cisResults = forgotPasswordDAO.validateOTPTime(contact,emailId,deleteInd);
			 
		  if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
			  DigihealthCareValidateOTP validate=(DigihealthCareValidateOTP)cisResults.getResultObject();
			  otpNumber=Integer.parseInt(validate.getOtp());
				String message="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
		                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
		                "<head>\n" +
		                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
		                "<title></title>\n" +
		                "</head>\n" +
		                "\n" +
		                "<body>\n" +
		                 "<p>Arcturus Care </b><br />"+
		                 "<p>Your requested OTP is "+otpNumber+
		                 
		                "<br />\n"+
		              
		                "<br />\n"+
		                "  Thanks,<br />\n" +
		                "<br />\n"+
		                " Arcturus Team<br />\n" +

		                "  <br />\n" +

		                "</body>\n" +
		                "</html>";
			String subject = "Arcturus";
			
			 
		     
			try {
				 String result = sendMail.sendMailWithAuth("castusinfo.com", "arcturus@castusinfo.com", "arcturus", "25",emailId, message, subject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			validate.setOtp("");
		  }
		  else
		  {
			  cisResults = forgotPasswordDAO.forgotPassword(emailId,contact,otpNumber,formatter.format(currentdate.getTime()),deleteInd);
			  String message="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
		                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
		                "<head>\n" +
		                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
		                "<title></title>\n" +
		                "</head>\n" +
		                "\n" +
		                "<body>\n" +
		                 "<p>Arcturus Care </b><br />"+
		                 "<p>Your requested OTP is "+otpNumber+
		                 
		                "<br />\n"+
		              
		                "<br />\n"+
		                "  Thanks,<br />\n" +
		                "<br />\n"+
		                " Arcturus Team<br />\n" +

		                "  <br />\n" +

		                "</body>\n" +
		                "</html>";
			String subject = "Arcturus";
			
			 
		     
			try {
				 String result = sendMail.sendMailWithAuth("castusinfo.com", "arcturus@castusinfo.com", "arcturus", "25",emailId, message, subject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		 
		
		logger.info("DigitalHealthCare:ProfileDataBL  service" +cisResults );
		
		
		
		
	
	
	
		
	
	
	return cisResults;
	}


}