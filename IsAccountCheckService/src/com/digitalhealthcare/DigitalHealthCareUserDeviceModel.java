/**
 * 
 */
package com.digitalhealthcare;

/**
 * @author Darshan
 *
 */
public class DigitalHealthCareUserDeviceModel {
	public String phoneNumber;
	public String userId;
	public String deviceToken;
	public String deviceType;
	public String deviceId;
	
	
	
	
	
	
	
	public DigitalHealthCareUserDeviceModel(String phoneNumber, String userId,
			String deviceToken, String deviceType, String deviceId) {
		super();
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.deviceToken = deviceToken;
		this.deviceType = deviceType;
		this.deviceId = deviceId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
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
	
public DigitalHealthCareUserDeviceModel() {
		
	}
	

}
