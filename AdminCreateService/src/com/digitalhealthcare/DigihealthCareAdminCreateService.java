package com.digitalhealthcare;

import java.util.List;

public class DigihealthCareAdminCreateService {
	
	public String patientId;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String emailId;
	public String accountType;
	public String age;
	public String gender;
	public String datetime;
	public List<DigihealthCareCareTakersService> careTakerDetails;
	
	
	public DigihealthCareAdminCreateService() {
    }
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
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


	


	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<DigihealthCareCareTakersService> getCareTakerDetails() {
		return careTakerDetails;
	}

	public void setCareTakerDetails(
			List<DigihealthCareCareTakersService> careTakerDetails) {
		this.careTakerDetails = careTakerDetails;
	}

	public DigihealthCareAdminCreateService(String patientId, String firstName,
			String lastName, String phoneNumber, String emailId,
			String accountType, String age, String gender, String datetime,
			List<DigihealthCareCareTakersService> careTakerDetails) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.accountType = accountType;
		this.age = age;
		this.gender = gender;
		this.datetime = datetime;
		this.careTakerDetails = careTakerDetails;
	}

	
	
}
	
	

