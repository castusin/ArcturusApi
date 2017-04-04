/**
 * 
 */
package com.digitalhealthcare;

/**
 * @author Darshan
 *
 */
public class DigihealthCareSaveFeedBackDetails {
	
	public String questionId;
	public String questionName;
	public String answer;
	
	public DigihealthCareSaveFeedBackDetails(String questionId,
			String questionName, String answer) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.answer = answer;
	}
	
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public DigihealthCareSaveFeedBackDetails() {
    }

}
