package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
/**
 * Save Feedback service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */

public class DigihealthCareSaveFeedBackBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml");
	DigihealthCareSaveFeedBackDAO feedBackDAO=(DigihealthCareSaveFeedBackDAO)ctx.getBean("feedBackDAO");

	/**
	 * @param saveFeedback
	 * @return
	 */
	public CISResults saveFeedback(DigihealthCareSaveFeedBack saveFeedback) {
		// TODO Auto-generated method stub
		EmailCommunication sendMail=new EmailCommunication();
		  SMSCommunication smsCommunicaiton=new SMSCommunication();
		  Calendar currentdate = Calendar.getInstance();
	      DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	      TimeZone obj = TimeZone.getTimeZone("CST");
	      formatter.setTimeZone(obj);
	      String feedbackDate=formatter.format(currentdate.getTime());
	      String emailId=saveFeedback.getEmailId();
	      String firsName=saveFeedback.getFirstName();
	      String lastName=saveFeedback.getLastName();
	      String QuestionId="";
	      String QuestionName="";
	      String QuestionResponse="";
	      String emailString="";
	      String contact = saveFeedback.getPhoneNumber();
	      String phoneNumber=CISConstants.USA_COUNTRY_CODE+contact;
		  CISResults cisResult = feedBackDAO.saveFeedbackInfo(saveFeedback.getUserId(),saveFeedback.getFeedbackSet(),saveFeedback.getServiceProvideBy(),saveFeedback.getServiceDate(),feedbackDate);
		  ArrayList<Object> feedBackDetails =new ArrayList<Object>();
		  DigihealthCareSaveFeedBack saveFeedbackModel=new DigihealthCareSaveFeedBack();
		  
		  for (int x=0; x<saveFeedback.getSaveFeedBackDetails().size(); x++)
		  {
			          QuestionId = saveFeedback.getSaveFeedBackDetails().get(x).questionId;
					  QuestionName= saveFeedback.getSaveFeedBackDetails().get(x).questionName;
					  QuestionResponse = saveFeedback.getSaveFeedBackDetails().get(x).answer;
					  emailString = emailString+"<p> "+QuestionName+"</b><br />"+
				                 "\n"+
				                 "<p> "+QuestionResponse+"</b><br />";
				                
				      cisResult = feedBackDAO.saveFeedbackDetails(saveFeedback.getUserId(),feedbackDate,QuestionId,QuestionName,QuestionResponse);
		   
		  }
		 		  
	        	String message="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
		                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
		                "<head>\n" +
		                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
		                "<title></title>\n" +
		                "</head>\n" +
		                "\n" +
		                "<body>\n" +
		                 "<p>Arcturus Care </b><br />"+
		                 "<p>Please find feedback details provided by "+firsName+""+lastName+
		                emailString+
		                 
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
					cisResult=smsCommunicaiton.sendMessage(phoneNumber,firsName,lastName);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	         
			 try {
				 String result = sendMail.sendMailWithAuth("castusinfo.com", "arcturus@mathgator.com", "arcturus1@3", "25",emailId, message, subject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return cisResult;
		
	}

}