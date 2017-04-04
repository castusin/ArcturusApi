package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



@SuppressWarnings("rawtypes")
public class DigiHealthCareSaveContentMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareSaveContent saveContentModel = new DigiHealthCareSaveContent();
		
		saveContentModel.setUserId(rs.getString("User_id"));
		saveContentModel.setContentName(rs.getString("Content_name"));
		saveContentModel.setContentType(rs.getString("Content_type"));
		saveContentModel.setContentText(rs.getString("Content_Text"));
		saveContentModel.setUrlType(rs.getString("URL_type"));
		saveContentModel.setDate(rs.getDate("Create_Date"));
		return saveContentModel;
	}

}