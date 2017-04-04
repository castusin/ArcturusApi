/**
 * 
 */
package com.digitalhealthcare;

/**
 * @author Darshan
 *
 */
public class DigihealthCareSaveFeedBackQuery {
	
	public static String SQL_SAVEFEEDBACK_INFO="insert into Feedback_info (User_id,Feedback_id,Service_Provided_By,Service_date,Feedback_date)"+"values(?,?,?,?,?)"; 	

	public static String SQL_SAVEFEEDBACK_DETAILS="insert into Feedback_det (User_id,Feedback_Date,Question_Id,Question_Name,Response)"+"values(?,?,?,?,?)"; 	

}
