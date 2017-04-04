package com.digitalhealthcare;

public class DigiHealthCareGetProfileDataQuery {
	public static String SQL_PROFILEDATA ="select App_Id,User_Id,Account_Type,First_Name,Last_Name,Registered_Phone_Number,eMail_Address,Gender,Photo,DOB,Date from Profile_Table where Registered_Phone_Number=?"; 
	 

}
