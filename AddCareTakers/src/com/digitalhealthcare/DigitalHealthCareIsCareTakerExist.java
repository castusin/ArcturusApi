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
public class DigitalHealthCareIsCareTakerExist implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareAdminAddCareTakerModel digiHealthCareAccountExist = new DigiHealthCareAdminAddCareTakerModel();	
		digiHealthCareAccountExist.setUserId(rs.getString("User_id"));
		digiHealthCareAccountExist.setPhoneNumber(rs.getString("Phone_no"));
		return digiHealthCareAccountExist;
	}
}
