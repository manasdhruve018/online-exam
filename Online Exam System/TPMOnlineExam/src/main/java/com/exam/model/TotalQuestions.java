package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_totalquestions")
public class TotalQuestions {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false,name="total_que_id")
	private int totalQueId;

    @Column(nullable=false , name="testid")
	private int testID;
    
    @Column(nullable=false , length=2000,name="question")
	private String question;
	
	@Column(nullable=false , length=1000,name="option_one")
	private String optionOne;
	
	@Column(nullable=false , length=1000,name="option_two")
	private String optionTwo;
	
	@Column(nullable=false , length=1000,name="option_three")
	private String optionThree;
	
	@Column(nullable=false , length=1000,name="option_four")
	private String optionFour;
	
	@Column(length=1000,name="correct_answer")
	private String correctAnswer;
	
	@Column(nullable=false , length=30,name="diff_level")
	private String diffLevel;
	
	@Column(nullable=false,name="marks")
	private int marks;
	
	public TotalQuestions() {
		
	}

	/**
	 * @return the totalQueId
	 */
	public int getTotalQueId() {
		return totalQueId;
	}

	/**
	 * @param totalQueId the totalQueId to set
	 */
	public void setTotalQueId(int totalQueId) {
		this.totalQueId = totalQueId;
	}

	
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the optionOne
	 */
	public String getOptionOne() {
		return optionOne;
	}

	/**
	 * @param optionOne the optionOne to set
	 */
	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}

	/**
	 * @return the optionTwo
	 */
	public String getOptionTwo() {
		return optionTwo;
	}

	/**
	 * @param optionTwo the optionTwo to set
	 */
	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}

	/**
	 * @return the optionThree
	 */
	public String getOptionThree() {
		return optionThree;
	}

	/**
	 * @param optionThree the optionThree to set
	 */
	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}

	/**
	 * @return the optionFour
	 */
	public String getOptionFour() {
		return optionFour;
	}

	/**
	 * @param optionFour the optionFour to set
	 */
	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}

	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	/**
	 * @return the diffLevel
	 */
	public String getDiffLevel() {
		return diffLevel;
	}

	/**
	 * @param diffLevel the diffLevel to set
	 */
	public void setDiffLevel(String diffLevel) {
		this.diffLevel = diffLevel;
	}

	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
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

	public TotalQuestions(int totalQueId, int testID, String question, String optionOne, String optionTwo,
			String optionThree, String optionFour, String correctAnswer, String diffLevel, int marks) {
		super();
		this.totalQueId = totalQueId;
		this.testID = testID;
		this.question = question;
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
		this.correctAnswer = correctAnswer;
		this.diffLevel = diffLevel;
		this.marks = marks;
	}	
	
}
