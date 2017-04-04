package com.digitalhealthcare;

public class DigiHealthCareGetContentDataQuery {
	
	public static String SQL_GETCONTENTDATA ="select User_id,Content_name,Content_type,Content_Text,URL_type,Create_Date from Content_table where  Content_name=?"; 


}
