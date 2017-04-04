package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareProfileUpdateMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareProfileUpdate profileUpdate = new DigiHealthCareProfileUpdate();
		profileUpdate.setAppId(rs.getString("App_Id"));
		profileUpdate.setUserId(rs.getString("User_Id"));
		profileUpdate.setAccountType(rs.getString("Account_Type"));
		profileUpdate.setFirstName(rs.getString("First_Name"));
		profileUpdate.setLastName(rs.getString("Last_Name"));
		profileUpdate.setPhoneNumber(rs.getString("Registered_Phone_Number"));
		profileUpdate.setEmailId(rs.getString("eMail_Address"));
		profileUpdate.setGender(rs.getString("Gender"));
		profileUpdate.setPhoto(rs.getString("Photo"));
		profileUpdate.setDob(rs.getString("DOB"));
		profileUpdate.setDate(rs.getDate("Date"));
		
		return profileUpdate;
	}

}
