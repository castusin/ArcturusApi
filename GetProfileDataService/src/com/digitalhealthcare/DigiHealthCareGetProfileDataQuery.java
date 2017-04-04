package com.digitalhealthcare;

public class DigiHealthCareGetProfileDataQuery {
	public static String SQL_PROFILEDATA ="select App_id,User_id,Account_type,First_name,Last_name,Phone_no,Email_id,Gender,DOB,Photo,Date from Profile_table where User_id=?";
	public static String SQL_CARETAKER_ID ="select App_id,User_id,Account_type,First_name,Last_name,Phone_no,Email_id,Gender,DOB,Photo,Date from Profile_table where Phone_no=? and Account_type =?"; 
	 

}
