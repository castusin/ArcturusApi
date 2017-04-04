/**
 * 
 */
package com.digitalhealthcare;

/**
 * @author Darshan
 *
 */
public class DigitalHalthCareTakersModel {
	public String patientId;
	public String phoneNumber;
	public String accountType;
	public String password;
	
	
	
	
	
	
	
	
	


	public DigitalHalthCareTakersModel(String patientId, String phoneNumber,
			String accountType, String password) {
		super();
		this.patientId = patientId;
		this.phoneNumber = phoneNumber;
		this.accountType = accountType;
		this.password = password;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

public DigitalHalthCareTakersModel() {
		
	}
	
	
	
	
}
