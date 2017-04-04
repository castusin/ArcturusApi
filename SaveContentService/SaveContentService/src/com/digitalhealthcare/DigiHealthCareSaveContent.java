package com.digitalhealthcare;


import java.sql.Date;

public class DigiHealthCareSaveContent {
	
	public String userId;
	public String contentName;
	public String contentText;
	public Date date;
	public String contentType;
	public String urlType;
	
	public DigiHealthCareSaveContent( String contentName, String contentText, Date date, String userId, String contentType, String urlType ) {
		super();
		
		
		this.userId=userId;
		this.contentName=contentName;
		this.contentText=contentText;
		this.date=date;
		this.contentType=contentType;
		this.urlType=urlType;
		
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DigiHealthCareSaveContent() {
		// TODO Auto-generated constructor stub
	}

	

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
