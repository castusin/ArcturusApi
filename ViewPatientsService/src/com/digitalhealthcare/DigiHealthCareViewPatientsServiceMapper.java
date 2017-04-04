package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class DigiHealthCareViewPatientsServiceMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareViewPatientsService viewPatients = new DigiHealthCareViewPatientsService();
		
		viewPatients.setFirstName(rs.getString("First_name"));
		viewPatients.setLastName(rs.getString("Last_name"));
		viewPatients.setPhoneNumber(rs.getString("Phone_no"));
		viewPatients.setEmailId(rs.getString("Email_id"));
		viewPatients.setGender(rs.getString("Gender"));
		
		
		return viewPatients;
	}

}
