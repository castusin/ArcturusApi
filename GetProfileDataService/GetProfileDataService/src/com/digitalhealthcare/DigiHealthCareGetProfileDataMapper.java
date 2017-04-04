/*package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigiHealthCareGetProfileDataMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DigiHealthCareGetProfileData profileModel = new DigiHealthCareGetProfileData();
		
		profileModel.setUserId(rs.getString("User_Id"));
		profileModel.setMedicaId(rs.getString("Medical_Id"));
		profileModel.setFirstName(rs.getString("First_Name"));
		profileModel.setLastName(rs.getString("Last_Name"));
		profileModel.setPhoneNumber(rs.getString("Registered_Phone_Number"));
		profileModel.setEmailId(rs.getString("eMail_Address"));
		//profileModel.setPhoto(rs.getString("Photo"));
		//profileModel.setDate(rs.getDate("Date"));
		
		return profileModel;
	}
}*/