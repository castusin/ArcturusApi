package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;
@SuppressWarnings("rawtypes")
public class DigihealthCareValidateOTPMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigihealthCareValidateOTP verifyModel = new DigihealthCareValidateOTP();
		verifyModel.setPhoneNumber(rs.getString("Registered_Phone_Number"));
	//	verifyModel.setOtp(rs.getString("OTP"));
		verifyModel.setTimeStamp(rs.getString("time_stamp"));
		return verifyModel;
	}
}
