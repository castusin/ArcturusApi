package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareSaveProfileMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigihealthCareSaveProfile homeCareRegistration = new DigihealthCareSaveProfile();
		homeCareRegistration.setAppId(rs.getString("App_id"));
		homeCareRegistration.setUserId(rs.getString("User_id"));
		
		homeCareRegistration.setAccountType(rs.getString("Account_type"));
		homeCareRegistration.setFirstName(rs.getString("First_name"));
	    homeCareRegistration.setLastName(rs.getString("Last_name"));
		homeCareRegistration.setPhoneNumber(rs.getString("Phone_no"));
		
		homeCareRegistration.setEmailId(rs.getString("Email_id"));
		homeCareRegistration.setGender(rs.getString("Gender"));
		homeCareRegistration.setPhoto(rs.getString("Photo"));
		homeCareRegistration.setDob(rs.getString("DOB"));
		homeCareRegistration.setDate(rs.getDate("Date"));
		
		return homeCareRegistration;
	}

}
