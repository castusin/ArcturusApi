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
public class DigiHealthCareGetPlanDetailsMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	DigihealthCareSavePlanDetailsModel planModel = new DigihealthCareSavePlanDetailsModel();
	     planModel.setAptId(rs.getInt("Apt_id"));
	     planModel.setUserId(rs.getString("User_id"));
	     planModel.setAptPersonId(rs.getInt("Apt_person_id"));
	     planModel.setAptDate(rs.getTimestamp("Date_time"));
		 planModel.setType(rs.getString("Type"));
		 planModel.setAppWith(rs.getString("Apt_with"));
		return planModel;
	}
}
