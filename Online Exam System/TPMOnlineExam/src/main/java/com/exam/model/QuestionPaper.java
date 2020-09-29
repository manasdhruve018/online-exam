package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_question_paper")
public class QuestionPaper {
	public QuestionPaper(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="questionID",nullable=false)
	private int questionID;
	
	@Column(name="topicID")
	private int topicID;
	
	@Column(name="testID")
	private int testID;
	
	@Column(name="question")
	private String question;
	
	@Column(name="optionone")
	private String optionone;
	
	@Column(name="optiontwo")
	private String optiontwo;
	
	@Column(name="optionthree")
	private String optionthree;
	
	@Column(name="optionfour")
	private String optionfour;
	
	@Column(name="answer")
	private String answer;
	
	@Column(name="marks")
	private int marks;

	/*
	 * public int getQuestionId() { return questionId; } public void
	 * setQuestionId(int questionId) { this.questionId = questionId; }
	 */
	

	public String getQuestion() {
		return question;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getTopicID() {
		return topicID;
	}

	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getOptionone() {
		return optionone;
	}

	public void setOptionone(String optionone) {
		this.optionone = optionone;
	}

	public String getOptiontwo() {
		return optiontwo;
	}

	public void setOptiontwo(String optiontwo) {
		this.optiontwo = optiontwo;
	}

	public String getOptionthree() {
		return optionthree;
	}

	public void setOptionthree(String optionthree) {
		this.optionthree = optionthree;
	}

	public String getOptionfour() {
		return optionfour;
	}

	public void setOptionfour(String optionfour) {
		this.optionfour = optionfour;
	}

	@Override
	public String toString() {
		return "QuestionPaper [questionID=" + questionID + ", topicID=" + topicID + ", testID=" + testID + ", question="
				+ question + ", optionone=" + optionone + ", optiontwo=" + optiontwo + ", optionthree=" + optionthree
				+ ", optionfour=" + optionfour + ", answer=" + answer + ", marks=" + marks + "]";
	}

	public QuestionPaper(int questionID, int topicID, int testID, String question, String optionone, String optiontwo,
			String optionthree, String optionfour, String answer, int marks) {
		super();
		this.questionID = questionID;
		this.topicID = topicID;
		this.testID = testID;
		this.question = question;
		this.optionone = optionone;
		this.optiontwo = optiontwo;
		this.optionthree = optionthree;
		this.optionfour = optionfour;
		this.answer = answer;
		this.marks = marks;
	}
	
}
