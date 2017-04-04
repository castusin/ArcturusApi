package com.digitalhealthcare;


import java.sql.Date;

import org.joda.time.DateTime;



public class DigiHealthCareProfileUpdate {
	public String appId;
	public String userId;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String emailId;
	public String photo;
	public String accountType;
	public String gender;
	public String dob;
	public Date date;
	
	
	public DigiHealthCareProfileUpdate(String userId,String firstName, String lastName,String emailId, String appId, String photo, String accountType, String gender, String dob, String phoneNumber, Date date ) {
		super();
		
		this.appId=appId;
		this.userId=userId;
		
		this.emailId=emailId;
		this.lastName=lastName;
		this.firstName=firstName;
		this.photo=photo;
		this.accountType=accountType;
		this.gender=gender;
		this.dob=dob;
		this.phoneNumber=phoneNumber;
		this.date=date;
	}
	
	
	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public DigiHealthCareProfileUpdate(){
		
	}

}
