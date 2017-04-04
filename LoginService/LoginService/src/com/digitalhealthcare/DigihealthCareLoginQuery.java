package com.digitalhealthcare;
/**
 * Login Query
 * 
 * @author Castus Info Solutions
 *
 */
public class DigihealthCareLoginQuery {
	
	public static String SQL_LOGIN = "select App_id,User_id,Account_type,First_name,Last_name,Phone_no,Password,Email_id,Gender,Photo,DOB,Date from Profile_table where User_id=? and Password=? and Account_type=?"; 
    

}
