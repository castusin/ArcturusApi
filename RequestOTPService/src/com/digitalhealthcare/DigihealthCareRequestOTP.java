package com.digitalhealthcare;

	public class DigihealthCareRequestOTP {
		
		public String phoneNumber;
		public String medicalId;
		
		
		

		public DigihealthCareRequestOTP(String phoneNumber, String medicalId ) {
			super();
			this.phoneNumber=phoneNumber;
			this.medicalId=medicalId;
		}
		
		public DigihealthCareRequestOTP() {
			// TODO Auto-generated constructor stub
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getMedicalId() {
			return medicalId;
		}

		public void setMedicalId(String medicalId) {
			this.medicalId = medicalId;
		}
		
		
		
		
		

	}
