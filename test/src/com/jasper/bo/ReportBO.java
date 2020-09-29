package com.jasper.bo;

import java.util.ArrayList;
import java.util.List;

public class ReportBO 
{
	
	public ReportBO(String testName, String testType, String userName, String userEmail, String testTime,
			String testStatus, String firstName, String lastName, String dob, String gender, String contactNo,
			String country, String strengths, String weaknesses, String testDate, String logs) 
	{
		super();
		this.testName = testName;
		this.testType = testType;
		this.userName = userName;
		this.userEmail = userEmail;
		this.testTime = testTime;
		this.testStatus = testStatus;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.contactNo = contactNo;
		this.country = country;
		this.strengths = strengths;
		this.weaknesses = weaknesses;
		this.testDate = testDate;
		this.logs = logs;
	}
	
	public static ReportBO getDefaultBO()
	{
		List<String> chart1Name = new ArrayList<String>();
		chart1Name.add("Core Java");
		chart1Name.add("Standard");
		List<Integer> chart1Marks = new ArrayList<Integer>();
		chart1Marks.add(80);
		chart1Marks.add(40);
		return new ReportBO("Core Java","Easy","jamesg","james@java.com","Oct 19, 2018 06:37:28 PM IST"
				,"Normal","James","Gosling","01/01/1960","Male","123456789","USA","OOPS",
				"Threading","Oct 19, 2018","18.00 PM - Logged In");
	}
	
	private String testName;
	private String testType;
	private String userName;
	private String userEmail;
	private String testTime;
	private String testStatus;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String contactNo;
	private String country;
	private String strengths;
	private String weaknesses;
	private String testDate;
	private String logs;
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStrengths() {
		return strengths;
	}
	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}
	public String getWeaknesses() {
		return weaknesses;
	}
	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getLogs() {
		return logs;
	}
	public void setLogs(String logs) {
		this.logs = logs;
	}
	
}
