package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_test_instance")
public class TestInstance {
	public TestInstance(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tinstanceID",nullable=false)
	private int tinstanceID;

	@Column(name="testID")
	private int testID;
	
	@Column(name="userID")
	private int userID;
	
	@Column(name="marksObtained")
	private int marksObtained;
	
	@Column(name="startTime")
	private int startTime;
	
	@Column(name="endTime")
	private int endTime;
	
	@Column(name="attempt")
	private boolean attempt;// 

	public int getTinstanceID() {
		return tinstanceID;
	}

	public void setTinstanceID(int tinstanceID) {
		this.tinstanceID = tinstanceID;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public boolean isAttempt() {
		return attempt;
	}

	public void setAttempt(boolean attempt) {
		this.attempt = attempt;
	}

	public TestInstance(int tinstanceID, int testID, int userID, int marksObtained, int startTime, int endTime,
			boolean attempt) {
		super();
		this.tinstanceID = tinstanceID;
		this.testID = testID;
		this.userID = userID;
		this.marksObtained = marksObtained;
		this.startTime = startTime;
		this.endTime = endTime;
		this.attempt = attempt;
	}

	@Override
	public String toString() {
		return "TestInstance [tinstanceID=" + tinstanceID + ", testID=" + testID + ", userID=" + userID
				+ ", marksObtained=" + marksObtained + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", attempt=" + attempt + "]";
	}

	
}
