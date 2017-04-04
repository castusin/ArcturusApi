package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigihealthCareRequestOTPMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigihealthCareRequestOTP requestOTP = new DigihealthCareRequestOTP();
		requestOTP.setPhoneNumber(rs.getString("Registered_Phone_Number"));
		return requestOTP;
	}

}
