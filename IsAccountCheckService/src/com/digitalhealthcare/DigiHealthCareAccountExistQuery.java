/**
 * 
 */
package com.digitalhealthcare;

/**
 * Query to check if account already exists 
 * @author Castus Info Solutions
 *
 */
public class DigiHealthCareAccountExistQuery {
	public static String SQL_VALIDATE_ACCOUNT = "select Phone_no,User_id,Email_id,First_name,Last_name,Account_type,Password from Profile_table where Phone_no=?";
	public static String SQL_VALIDATE_PATIENT_ACCOUNT = "select Phone_no,User_id,Email_id,First_name,Last_name,Account_type,Password from Profile_table where Phone_no=? and Account_type=?";
	public static String SQL_CHECK_CARETAKERS = "select Patient_id,Phone_number from Patient_phonenumber where Phone_number=? ";
	public static String SQL_GET_CARETAKER_PATIENTDETAILS = " SELECT A.Patient_userid, A.Fm_id, B.User_id, B.Account_type, B.First_name, B.Last_name, B.Phone_no, B.Email_id, B.Gender FROM Patient_fm A JOIN Profile_table B ON A.Patient_userid = B.User_Id WHERE A.Fm_id = ? ";
	public static String SQL_CHECK_DEVICE_PHONE = "SELECT User_id,Device_id from User_Devices where Device_id=? "; 
	public static String SQL_CHECK_DEVICEID = " SELECT User_id,Device_id from User_Devices where User_id=? and Device_id=? "; 


}
