package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareGetProfileDataMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DigihealthCareSaveProfile profileModel = new DigihealthCareSaveProfile();
		
		profileModel.setAppId(rs.getString("App_id"));
		profileModel.setUserId(rs.getString("User_id"));
		profileModel.setAccountType(rs.getString("Account_type"));
		profileModel.setFirstName(rs.getString("First_name"));
		profileModel.setLastName(rs.getString("Last_name"));
		profileModel.setPhoneNumber(rs.getString("Phone_no"));
		//profileModel.setPassword(rs.getString("Password"));
		profileModel.setEmailId(rs.getString("Email_id"));
		profileModel.setPhoto(rs.getString("Gender"));
		profileModel.setDate(rs.getDate("Date"));
		profileModel.setDob(rs.getString("DOB"));
		return profileModel;
	}
}