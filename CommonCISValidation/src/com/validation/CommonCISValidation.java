package com.validation;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.CISSessionWebservice;
import com.digitalhealthcare.DigiHealthCareAdminProfileUpdate;
import com.digitalhealthcare.DigiHealthCareSaveContent;
import com.digitalhealthcare.DigihealthCareSaveFeedBack;
import com.digitalhealthcare.DigihealthCareSaveProfile;
import com.digitalhealthcare.DigihealthCareValidateOTP;
import com.digitalhealthcare.DigitalHealtCareIsAccountExistBL;
import com.digitalhealthcare.DigitalHealthCareIsAccountExistDAO;


public class CommonCISValidation {
	
	
	public CISResults  ProfileValidation(DigihealthCareSaveProfile registration,HttpServletRequest request) {
		
		CISResults cisResult=new CISResults();
		ArrayList<String> registrationValues= new ArrayList<String>();
		registrationValues.add(registration.getAppId());
		registrationValues.add(registration.getUserId());
		registrationValues.add(registration.getAccountType());
		registrationValues.add(registration.getFirstName());
		registrationValues.add(registration.getLastName());
		registrationValues.add(registration.getPhoneNumber());
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        
		//Validate Headers AUTHROIZATION
	    if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	    {
	    	cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	    }else
	    {
	    	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	    }
	    
	    
	 // Validate Null Values in Profile Data
	    if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
	    
		 for (String checkvalues : registrationValues) {
	            if  (checkvalues==null || checkvalues.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          } 
		 }    
		 
	    
	    
	    
	    
		 //Validate Email Format validation
		 
	    
	    if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  { 
			 String emailCheck = CISConstants.EMAIL_REGEX;
		     Boolean checkValue = registration.getEmailId().matches(emailCheck);
			 if(Boolean.FALSE.equals(checkValue))
			  {
				 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			  }
		   } 
		 cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		 return cisResult;
	}
	

public CISResults  viewPatientsValidation(HttpServletRequest request,DigihealthCareSaveProfile viewPatients) {
		
		CISResults cisResult=new CISResults();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
             //Validate Headers AUTHROIZATION
        if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
              {
  	               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
              }else
              {
  	               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
               }
     // Validate Null Values in Profile Data
		/* for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	            }   */
		  
		/* if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		        {
			        String emailCheck = CISConstants.EMAIL_REGEX;
		            Boolean checkValue = emailId.matches(emailCheck);
			        if(Boolean.FALSE.equals(checkValue))
			          {
				         cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			          }
			     }*/
		 
		return cisResult;
	}
	
public CISResults  addPatientValidation(DigihealthCareSaveProfile savePatient,HttpServletRequest request) {
		
	CISResults cisResult=new CISResults();
	ArrayList<String> registrationValues= new ArrayList<String>();
	registrationValues.add(savePatient.getAppId());
	registrationValues.add(savePatient.getUserId());
	registrationValues.add(savePatient.getAccountType());
	registrationValues.add(savePatient.getFirstName());
	registrationValues.add(savePatient.getLastName());
	registrationValues.add(savePatient.getPhoneNumber());
	cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
        
	//Validate Headers AUTHROIZATION
    if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
    {
    	cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
    }else
    {
    	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
    }
    
    
 // Validate Null Values in Profile Data
    if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	 {
    
	 for (String checkvalues : registrationValues) {
            if  (checkvalues==null || checkvalues.equals(""))
            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
          } 
	 }    
	 
	 //Validate Email Format validation
	 
    
    if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
	  { 
		 String emailCheck = CISConstants.EMAIL_REGEX;
	     Boolean checkValue = savePatient.getEmailId().matches(emailCheck);
		 if(Boolean.FALSE.equals(checkValue))
		  {
			 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		  }
	   } 
	 cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	 return cisResult;
}

	
	public CISResults  requestOTPValidation(String phoneNumber,String emailId,HttpServletRequest request) {
		CISResults cisResult=new CISResults();
		DigitalHealtCareIsAccountExistBL isAccountExistBL = new DigitalHealtCareIsAccountExistBL();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(phoneNumber);
		emptyValidatonArray.add(emailId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
             //Validate Headers AUTHROIZATION
        if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
              {
  	               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
              }else
              {
  	               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
               }
     // Validate Null Values in Profile Data
		 for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	            }   
		  
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		        {
			        String emailCheck = CISConstants.EMAIL_REGEX;
		            Boolean checkValue = emailId.matches(emailCheck);
			        if(Boolean.FALSE.equals(checkValue))
			          {
				         cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			          }
			     }
		 
		 
		return cisResult;
	}
	
	public CISResults  validateOTPValidation(String phoneNumber,String emailId,String otp,HttpServletRequest request) {
		CISResults cisResult=new CISResults();
		DigihealthCareValidateOTP validateOTP=new DigihealthCareValidateOTP();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(phoneNumber);
		emptyValidatonArray.add(emailId);
		emptyValidatonArray.add(otp);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
        //Validate Headers AUTHROIZATION
   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
         {
	               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
         }else
         {
	               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
          }
       // Validate Null Values in Profile Data
		 for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }   
		 System.out.println(cisResult.getResponseCode()); 
		 if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
			 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		     Boolean b = emailId.matches(EMAIL_REGEX);
		     System.out.println("is e-mail: "+emailId+" :Valid = " + b);
			 if(Boolean.FALSE.equals(b))
			 {
				 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			 }
		 }
		 
		return cisResult;
	}
	
	public CISResults  loginValidation(String userId,String password,String accountType,HttpServletRequest request) {
		CISResults cisResult=new CISResults();
		DigitalHealtCareIsAccountExistBL isAccountExistBL = new DigitalHealtCareIsAccountExistBL();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		emptyValidatonArray.add(password);
		emptyValidatonArray.add(accountType);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
        //Validate Headers AUTHROIZATION
   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
         {
	               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
         }else
         {
	               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
          }
    // Validate Null Values in Profile Data
		 for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }   
		
			 
		return cisResult;
	}
	
	
	public CISResults  updatePasswordValidation(HttpServletRequest request,String userId,String password) {
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		
		
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		// Validate Null Values in Profile Data
		 for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }   
		 
		//Validate Session Time
		 /* if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			 {
		       cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
		  
			 }*/
		
		
		return cisResult;
	}
	
	public CISResults  forgotPasswordValidation(HttpServletRequest request,String emailId,String phoneNumber) {
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(emailId);
		emptyValidatonArray.add(phoneNumber);
		
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		// Validate Null Values in Profile Data
		 for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }   
		 
		
		return cisResult;
	}
	
	
	public CISResults  saveContentValidation(String contentName,String contentText) {
		CISResults cisResult=new CISResults();
		DigiHealthCareSaveContent saveContent=new DigiHealthCareSaveContent();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(contentName);
		emptyValidatonArray.add(contentText);
		
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		// Validate Null Profile Data
		 for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }   
		 System.out.println(cisResult.getResponseCode()); 
		
		return cisResult;
	}
	
	
	/**
	 * @param phoneNumber
	 * @param request
	 * @param deviceId
	 * @return
	 */
	public CISResults accountExistValidaiton(String phoneNumber,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();


		
		
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(phoneNumber);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
       
		//Validate Headers AUTHROIZATION
   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
         {
	               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
         }else
         {
	               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
          }
    
   // Validate Null Values 
   
		 for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          } 
		
		 
		 
		return cisResult;
	}



	public CISResults checkSessionValidations(String userId, String sessionId,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		emptyValidatonArray.add(sessionId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	     if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	      // Validate Null Values 
	     
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		
				//Validate Session Time
			  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
				 {
			       cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
			      
				 }
			 
			 
		return cisResult;
	}



	public CISResults getProfileValidation(String userId, String sessionId,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		emptyValidatonArray.add(sessionId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
	   
	   //Validate Session Time
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	        cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
	   
		  }
	   
	   
		
		return cisResult;
	}


	public CISResults userLogOut(String userId, String sessionId,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		emptyValidatonArray.add(sessionId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		// Validate Null Values 
		 for (String st : emptyValidatonArray) {
	            if  (st==null || st.equals(""))
	            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          } 
		
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
		
		return cisResult;
	}



	public CISResults updateProfileValidation(
			DigihealthCareSaveProfile updateProfile,
			HttpServletRequest request, String userId, String sessionId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		emptyValidatonArray.add(sessionId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	       //Validate Headers AUTHROIZATION
	  if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	        {
		              cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	        }else
	        {
		              cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	         }
	  
	  
	       // Validate Null Values 
	  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
	  
			for (String st : emptyValidatonArray) {
		           if  (st==null || st.equals(""))
		           	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		         } 
		 }
	  //Validate Session Time
	  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
	       cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
	  
		 }
	  
	  
		
		return cisResult;
	}



	public CISResults saveFeedbackValidation(
			DigihealthCareSaveFeedBack saveFeedback,
			HttpServletRequest request, String userId, String sessionId) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		CISSessionWebservice cisSessionTime = new CISSessionWebservice();
		ArrayList<String> feedbackValues= new ArrayList<String>();
		feedbackValues.add(saveFeedback.getAppId());
		feedbackValues.add(saveFeedback.getUserId());
		feedbackValues.add(saveFeedback.getSessionId());
		feedbackValues.add(saveFeedback.getFeedbackSet());
		feedbackValues.add(saveFeedback.getServiceProvideBy());
		feedbackValues.add(saveFeedback.getPhoneNumber());
		feedbackValues.add(saveFeedback.getEmailId());
		feedbackValues.add(saveFeedback.getServiceDate());
		feedbackValues.add(saveFeedback.getFirstName());
		feedbackValues.add(saveFeedback.getLastName());
		
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	         //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	   {
	   	cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	   }else
	   {
	   	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	   }
	// Validate Null Values in Profile Data
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
		for (String checkvalues : feedbackValues) {
	           if  (checkvalues==null || checkvalues.equals(""))
	           	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	         } 
		 }
		     //Validate Email Format validation
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 { 
			String emailCheck = CISConstants.EMAIL_REGEX;
		    Boolean checkValue = saveFeedback.getEmailId().matches(emailCheck);
			if(Boolean.FALSE.equals(checkValue))
			 {
				cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
			 }
		  } 
		//Validate Session Time
		  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			 {
		       cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
		  
			 }
		  
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		return cisResult;
	}

	public CISResults  getContentValidation(String userId,String sessionId) {
	CISResults cisResult=new CISResults();
	CISSessionWebservice cisSessionTime = new CISSessionWebservice();
	ArrayList<String> emptyValidatonArray= new ArrayList<String>();
	emptyValidatonArray.add(userId);
	
	
	cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	// Validate Null Values in Profile Data
	 for (String st : emptyValidatonArray) {
            if  (st==null || st.equals(""))
            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
          }   
	 
	//Validate Session Time
	  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
	       cisResult  = cisSessionTime.getSessionDetails(userId,sessionId);
	  
		 }
	
	
	return cisResult;
}

	public CISResults adminGetProfileValidation(String userId,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
	   
	  
	   
		
		return cisResult;
	}

	public CISResults adminUpdateProfileValidation(
			DigiHealthCareAdminProfileUpdate adminUpdateProfile,
			HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	       //Validate Headers AUTHROIZATION
	  if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	        {
		              cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	        }else
	        {
		              cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	         }
	  
	  
	       // Validate Null Values 
	  if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
	  
			for (String st : emptyValidatonArray) {
		           if  (st==null || st.equals(""))
		           	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		         } 
		 }
	 
	  
		
		return cisResult;
	}

	public CISResults addCareTakers(HttpServletRequest request,String userId, String phoneNumber) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		emptyValidatonArray.add(userId);
		emptyValidatonArray.add(phoneNumber);
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
		return cisResult;
	}


	
	
	
	
	
	
	


	
}
