package com.exam.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user_test_report")
public class UserTestReport {
	public UserTestReport(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reportID",nullable=false)
	private int reportId;
	
	@Column(name="userID")
	private int userID;
	
	@Column(name="tinstanceID")
	private int tinstanceID;
	
	@Column(name="report")
	private File report;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getTinstanceID() {
		return tinstanceID;
	}

	public void setTinstanceID(int tinstanceID) {
		this.tinstanceID = tinstanceID;
	}

	public File getReport() {
		return report;
	}

	public void setReport(File report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "UserTestReport [reportId=" + reportId + ", userID=" + userID + ", tinstanceID=" + tinstanceID
				+ ", report=" + report + "]";
	}

	public UserTestReport(int reportId, int userID, int tinstanceID, File report) {
		super();
		this.reportId = reportId;
		this.userID = userID;
		this.tinstanceID = tinstanceID;
		this.report = report;
	}
	
}