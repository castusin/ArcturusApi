package com.digitalhealthcare;



import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class DigiHealthCareAdminProfileUpdate {
	public String appId;
	public String userId;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String password;
	public String emailId;
	public String photo;
	public String accountType;
	public String gender;
	public String dob;
	public Date   date;
	public String sessionId;
	public String sessionTimeStamp;
	public String deviceToken;
	public String status;
	public String deviceType;
	public String deviceId;
	public String dateTime;
	public List<DigihealthCareCareTakersService> careTakerDetails;
	
	

	public String getSessionId() {
		return sessionId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getDeviceToken() {
		return deviceToken;
	}


	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDeviceType() {
		return deviceType;
	}


	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}


	public String getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public String getDateTime() {
		return dateTime;
	}


	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}


	public DigiHealthCareAdminProfileUpdate(String appId, String userId,
			 String firstName, String lastName,
			String phoneNumber, String password, String emailId, String photo,
			String accountType, String gender, String dob, Date date,
			String sessionId, String sessionTimeStamp, String deviceId, String deviceToken, String deviceType, String status, String dateTime) {
		super();
		this.appId = appId;
		this.userId = userId;
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.emailId = emailId;
		this.photo = photo;
		this.accountType = accountType;
		this.gender = gender;
		this.dob = dob;
		this.date = date;
		this.sessionId = sessionId;
		this.sessionTimeStamp = sessionTimeStamp;
		this.deviceId=deviceId;
		this.deviceToken=deviceToken;
		this.deviceType=deviceType;
		this.status=status;
		this.dateTime=dateTime;
	}


	public String getSessionTimeStamp() {
		return sessionTimeStamp;
	}


	public void setSessionTimeStamp(String sessionTimeStamp) {
		this.sessionTimeStamp = sessionTimeStamp;
	}


	/*public DigihealthCareSaveProfile(String appId, String userId,
			 String firstName, String lastName,
			String phoneNumber, String password, String emailId, String photo,
			String accountType, String gender, String dob, Date date,
			String sessionId) {
		super();
		this.appId = appId;
		this.userId = userId;
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.emailId = emailId;
		this.photo = photo;
		this.accountType = accountType;
		this.gender = gender;
		this.dob = dob;
		this.date = date;
		this.sessionId = sessionId;
	}*/


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
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
	
	


	public List<DigihealthCareCareTakersService> getCareTakerDetails() {
		return careTakerDetails;
	}


	public void setCareTakerDetails(
			List<DigihealthCareCareTakersService> careTakerDetails) {
		this.careTakerDetails = careTakerDetails;
	}


	public DigiHealthCareAdminProfileUpdate(){
		
	}

}
