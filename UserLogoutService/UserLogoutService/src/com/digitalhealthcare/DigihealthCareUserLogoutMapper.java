package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
@SuppressWarnings("rawtypes")
public class DigihealthCareUserLogoutMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigihealthCareUserLogout userLogout = new DigihealthCareUserLogout();
		
		userLogout.setUserId(rs.getString("User_id"));
		userLogout.setSessionId(rs.getString("Session_Id"));
		userLogout.setDeleteInd(rs.getString("Delete_ind"));
		
		return userLogout;
	}
}
