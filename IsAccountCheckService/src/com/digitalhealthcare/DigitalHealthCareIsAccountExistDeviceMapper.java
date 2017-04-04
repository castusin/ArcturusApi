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
public class DigitalHealthCareIsAccountExistDeviceMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigitalHealthCareUserDeviceModel digiHealthCareAccountExistDevice = new DigitalHealthCareUserDeviceModel();	
	    digiHealthCareAccountExistDevice.setPhoneNumber(rs.getString("Phone_no"));
		//digiHealthCareAccountExistDevice.setUserId(rs.getString("User_id"));
		digiHealthCareAccountExistDevice.setDeviceId(rs.getString("Device_id"));
		//digiHealthCareAccountExistDevice.setDeviceType(rs.getString("Device_Type"));
		
		return digiHealthCareAccountExistDevice;
	}
}
