package com.digitalhealthcare;

public class DigihealthCareUserLogout {
	
	public String userId;
	public String sessionId;
	public String deleteInd;
	public DigihealthCareUserLogout(String userId, String sessionId, String deleteInd) {
		super();
		
		
		this.userId=userId;
		this.sessionId=sessionId;
		this.deleteInd=deleteInd;
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

	public String getDeleteInd() {
		return deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public DigihealthCareUserLogout(){
		
	}

}
