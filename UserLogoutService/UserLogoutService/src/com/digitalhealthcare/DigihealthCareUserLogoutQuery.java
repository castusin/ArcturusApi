package com.digitalhealthcare;

public class DigihealthCareUserLogoutQuery {
	
	public static String SQL_USERLOGOUT="UPDATE Session_data  set Delete_ind =? where User_id=? and Session_id=?" ;
	
}
