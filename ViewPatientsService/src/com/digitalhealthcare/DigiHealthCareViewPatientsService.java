package com.digitalhealthcare;

import java.sql.Date;

public class DigiHealthCareViewPatientsService {
	
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String accountType;
	public String emailId;
	public String gender;
	

	



	public DigiHealthCareViewPatientsService(String firstName, String lastName,
			String phoneNumber, String accountType, String emailId,
			String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.accountType = accountType;
		this.emailId = emailId;
		this.gender = gender;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
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

	public String getPatientName() {
		return firstName;
	}
	public void setPatientName(String patientName) {
		this.firstName = patientName;
	}
	
	

	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public DigiHealthCareViewPatientsService(){
		
	}

}
