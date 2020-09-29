package com.exam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_question_instance")
public class QuestionInstance implements Serializable{
	public QuestionInstance(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tinstanceID",nullable=false)
	private int tinstanceID;
	
	@Column(name="userID")
	private int userID;
	
	@Column(name="testID")
	private int testID;
	
	@Column(name="questionID")
	private int questionID;
	
	@Column(name="isAppeared")
	private boolean isAppeared;
	
	@Column(name="selectedOption")
	private String selectedOption;
	
	@Column(name="marksObtained")
	private int marksObtained;

	public int getTinstanceID() {
		return tinstanceID;
	}

	public void setTinstanceID(int tinstanceID) {
		this.tinstanceID = tinstanceID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public boolean isAppeared() {
		return isAppeared;
	}

	public void setAppeared(boolean isAppeared) {
		this.isAppeared = isAppeared;
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public QuestionInstance(int tinstanceID, int userID, int testID, int questionID, boolean isAppeared,
			String selectedOption, int marksObtained) {
		super();
		this.tinstanceID = tinstanceID;
		this.userID = userID;
		this.testID = testID;
		this.questionID = questionID;
		this.isAppeared = isAppeared;
		this.selectedOption = selectedOption;
		this.marksObtained = marksObtained;
	}

	@Override
	public String toString() {
		return "QuestionInstance [tinstanceID=" + tinstanceID + ", userID=" + userID + ", testID=" + testID
				+ ", questionID=" + questionID + ", isAppeared=" + isAppeared + ", selectedOption=" + selectedOption
				+ ", marksObtained=" + marksObtained + "]";
	}
	
	
}
