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
public class DigitalHealthCareIsCareTakerExistMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareAdminAddCareTakerModel digiHealthCareTakersExist = new DigiHealthCareAdminAddCareTakerModel();	
		digiHealthCareTakersExist.setUserId(rs.getString("Patient_id"));
		digiHealthCareTakersExist.setPhoneNumber(rs.getString("Phone_number"));
		return digiHealthCareTakersExist;
	}
}
