/**
 * 
 */
package com.digitalhealthcare;

import java.sql.Date;
import java.util.List;

/**
 * @author Darshan
 *
 */
public class DigihealthCareSaveFeedBack {
	
	public String appId;
	public String userId;
	public String sessionId;
	public String feedbackSet;
	public String serviceProvideBy;
	public String phoneNumber;
	public String emailId;
	public String serviceDate;
	public String firstName;
	public String lastName;
	public List<DigihealthCareSaveFeedBackDetails> saveFeedBackDetails;
	
	
	public DigihealthCareSaveFeedBack() {
    }

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public DigihealthCareSaveFeedBack(String appId, String userId,
			String sessionId, String feedbackSet, String serviceProvideBy,
			String serviceDate,String firstName, String lastName,
			List<DigihealthCareSaveFeedBackDetails> saveFeedBackDetails ) {
		super();
		this.appId = appId;
		this.userId = userId;
		this.sessionId = sessionId;
		this.feedbackSet = feedbackSet;
		this.serviceProvideBy = serviceProvideBy;
		this.serviceDate = serviceDate;
		this.firstName=firstName;
		this.lastName=lastName;
		this.saveFeedBackDetails = saveFeedBackDetails;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getFeedbackSet() {
		return feedbackSet;
	}
	public void setFeedbackSet(String feedbackSet) {
		this.feedbackSet = feedbackSet;
	}
	public String getServiceProvideBy() {
		return serviceProvideBy;
	}
	public void setServiceProvideBy(String serviceProvideBy) {
		this.serviceProvideBy = serviceProvideBy;
	}
	public String getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	public List<DigihealthCareSaveFeedBackDetails> getSaveFeedBackDetails() {
		return saveFeedBackDetails;
	}
	public void setSaveFeedBackDetails(
			List<DigihealthCareSaveFeedBackDetails> saveFeedBackDetails) {
		this.saveFeedBackDetails = saveFeedBackDetails;
	}
	
	

}
