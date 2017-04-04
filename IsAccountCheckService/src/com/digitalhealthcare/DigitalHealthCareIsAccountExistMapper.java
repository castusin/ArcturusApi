/**
 * 
 */
package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This class maps database table names to Model
 * @author Castus Info Solutions
 *
 */
@SuppressWarnings("rawtypes")
public class DigitalHealthCareIsAccountExistMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigitalHealthCareIsAccountExistModel digiHealthCareAccountExist = new DigitalHealthCareIsAccountExistModel();	
		digiHealthCareAccountExist.setPhoneNumber(rs.getString("Phone_no"));
		digiHealthCareAccountExist.setUserId(rs.getString("User_id"));
		digiHealthCareAccountExist.setEmailId(rs.getString("Email_id"));
		digiHealthCareAccountExist.setFirstName(rs.getString("First_name"));
		digiHealthCareAccountExist.setLastName(rs.getString("Last_name"));
		digiHealthCareAccountExist.setAccountType(rs.getString("Account_type"));
		digiHealthCareAccountExist.setPassword(rs.getString("Password"));
		
		return digiHealthCareAccountExist;
	}
}
