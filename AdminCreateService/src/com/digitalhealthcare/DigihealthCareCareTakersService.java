package com.digitalhealthcare;

public class DigihealthCareCareTakersService {
	
	public String phoneNumber;
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public DigihealthCareCareTakersService(String phoneNumber,
			String relation) {
		super();
		this.phoneNumber = phoneNumber;
		
		
	}
	
	public DigihealthCareCareTakersService(){
		
	}
}
