/**
 * 
 */
package com.digitalhealthcare;

/**
 * Model class 
 * @author Castus Info Solutions
 *
 */
public class DigitalHealthCareIsAccountExistModel {
	public String phoneNumber;
	public String userId;
	public String emailId;
	public String firstName;
	public String lastName;
	public String accountType;
	public String password;

	






	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	

	public DigitalHealthCareIsAccountExistModel(String phoneNumber,
			String userId, String emailId, String firstName, String lastName,
			String accountType, String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountType = accountType;
		this.password = password;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public DigitalHealthCareIsAccountExistModel() {
		
	}
}
