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
public class DigitalHealthCareIsAccountExistDeviceUserIdMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigitalHealthCareUserDeviceModel digiHealthCareAccountExistDevice = new DigitalHealthCareUserDeviceModel();	
	   
		digiHealthCareAccountExistDevice.setUserId(rs.getString("User_id"));
		digiHealthCareAccountExistDevice.setDeviceId(rs.getString("Device_id"));
		
		
		return digiHealthCareAccountExistDevice;
	}
}
