package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user_log")
public class UserLog {
	public UserLog(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="logID",nullable=false)
	private int logId;
	
	@Column(name="userID")
	private int userID;
	
	@Column(name="action")
	private String action;
	
	@Column(name="time")
	private int time;

	@Override
	public String toString() {
		return "UserLog [logId=" + logId + ", userID=" + userID + ", action=" + action + ", time=" + time + "]";
	}

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public UserLog(int logId, int userID, String action, int time) {
		super();
		this.logId = logId;
		this.userID = userID;
		this.action = action;
		this.time = time;
	}

	
}
