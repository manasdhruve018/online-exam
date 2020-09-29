package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_test")
public class Test {
	public Test(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="testID",nullable=false)
	private int testID;
	
	@Column(name="userID")
	private String userID;
	
	@Column(name="categoryID")
	private int categoryID;
	
	@Column(name="duration")
    private int duration;
	
	@Column(name="total_questions")
	private int totalQuestions;
	
	@Column(name="passMarks")
	private int passMarks;
	
	@Column(name="difficulty")
	private int difficulty; //low=0,medium=1,pro=2
	/*public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}*/

	/**
	 * @param testID
	 * @param userID
	 * @param categoryID
	 * @param duration
	 * @param totalQuestions
	 * @param passMarks
	 * @param difficulty
	 */
	public Test(int testID, String userID, int categoryID, int duration, int totalQuestions, int passMarks,
			int difficulty) {
		super();
		this.testID = testID;
		this.userID = userID;
		this.categoryID = categoryID;
		this.duration = duration;
		this.totalQuestions = totalQuestions;
		this.passMarks = passMarks;
		this.difficulty = difficulty;
	}

	/**
	 * @return the testID
	 */
	public int getTestID() {
		return testID;
	}

	/**
	 * @param testID the testID to set
	 */
	public void setTestID(int testID) {
		this.testID = testID;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the categoryID
	 */
	public int getCategoryID() {
		return categoryID;
	}

	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the totalQuestions
	 */
	public int getTotalQuestions() {
		return totalQuestions;
	}

	/**
	 * @param totalQuestions the totalQuestions to set
	 */
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	/**
	 * @return the passMarks
	 */
	public int getPassMarks() {
		return passMarks;
	}

	/**
	 * @param passMarks the passMarks to set
	 */
	public void setPassMarks(int passMarks) {
		this.passMarks = passMarks;
	}

	/**
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	
	
}