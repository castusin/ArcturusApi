/**
 * 
 */
package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Darshan
 *
 */
@SuppressWarnings("rawtypes")
public class DigihealthCareGetOTPMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigihealthCareValidateOTP verifyModel = new DigihealthCareValidateOTP();
		verifyModel.setPhoneNumber(rs.getString("Registered_Phone_Number"));
		//verifyModel.setEmailId(rs.getString("EmailId"));
		verifyModel.setOtp(rs.getString("OTP"));
		verifyModel.setTimeStamp(rs.getString("time_stamp"));
		return verifyModel;
	} 

}
