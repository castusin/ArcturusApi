package com.digitalhealthcare;

public class DigiHealthCareViewPatientsServiceQuery {
	
	public static String SQL_VIEWPATIENTS = " select App_id,User_id,Account_type,First_name,Last_name,Phone_no,Password,Email_id,Gender,Photo,DOB,Date from Profile_table where Account_type= ? and Password  <> '' "; 
	
}
