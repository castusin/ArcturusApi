package com.digitalhealthcare;

public class DigiHealthCareAdminAddCareTakerQuery {
	public static String SQL_ADD_CARETAKER="insert into Patient_phonenumber (Patient_id,Phone_number)"+"values(?,?)";
	public static String SQL_CHECK_CARETAKER = "select Patient_id,Phone_number from Patient_phonenumber where Patient_id=? and Phone_number=? ";

}
