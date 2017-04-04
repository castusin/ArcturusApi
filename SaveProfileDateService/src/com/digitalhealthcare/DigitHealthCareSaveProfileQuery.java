package com.digitalhealthcare;

public class DigitHealthCareSaveProfileQuery {	
	public static String SQL_GETHOMECAREREGISTRATION="insert into Profile_table (App_id,User_id,Account_type,First_name,Last_name,Phone_no,Password,Email_id,Gender,Photo,DOB,Date)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)"; 	
	public static String SQL_DELETEOTP="DELETE FROM Request_OTP WHERE Registered_Phone_Number=?";
	public static String SQL_FAMILYMAPPING="insert into Patient_fm (Patient_userid,Fm_id)"+"values(?,?)"; 	
}
