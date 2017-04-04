package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
@SuppressWarnings("rawtypes")
public class DigitalHealthCareIsCareTakerMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigitalHalthCareTakersModel digiHealthCareTakersExist = new DigitalHalthCareTakersModel();	
		digiHealthCareTakersExist.setPatientId(rs.getString("Patient_id"));
		digiHealthCareTakersExist.setPhoneNumber(rs.getString("Phone_number"));
		return digiHealthCareTakersExist;
	}
}
