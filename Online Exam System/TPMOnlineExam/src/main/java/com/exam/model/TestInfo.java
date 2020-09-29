package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_testinfo")
public class TestInfo {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable=false,name="testinfo_id" )
		private int testInfoId;
		
		@Column(name="user_name")
		private String userName;
		
		@Column(name="test_id")
		private int testId;
		
		@Column(name="que_id")
		private int questionId;
		
		@Column(name="answer")
		private String answer;
		
		@Column(name="marks")
		private int marks;

		/**
		 * @param testInfoId
		 * @param userName
		 * @param testId
		 * @param questionId
		 * @param answer
		 * @param ma
		 */
		public TestInfo(int testInfoId, String userName, int testId, int questionId, String answer, int marks) {
			super();
			this.testInfoId = testInfoId;
			this.userName = userName;
			this.testId = testId;
			this.questionId = questionId;
			this.answer = answer;
			this.marks = marks;
		}
		
		public TestInfo() {
			
		}

		/**
		 * @return the testInfoId
		 */
		public int getTestInfoId() {
			return testInfoId;
		}

		/**
		 * @param testInfoId the testInfoId to set
		 */
		public void setTestInfoId(int testInfoId) {
			this.testInfoId = testInfoId;
		}

		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}

		/**
		 * @return the testId
		 */
		public int getTestId() {
			return testId;
		}

		/**
		 * @param testId the testId to set
		 */
		public void setTestId(int testId) {
			this.testId = testId;
		}

		/**
		 * @return the questionId
		 */
		public int getQuestionId() {
			return questionId;
		}

		/**
		 * @param questionId the questionId to set
		 */
		public void setQuestionId(int questionId) {
			this.questionId = questionId;
		}

		/**
		 * @return the answer
		 */
		public String getAnswer() {
			return answer;
		}

		/**
		 * @param answer the answer to set
		 */
		public void setAnswer(String answer) {
			this.answer = answer;
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
		
		
		
		

}
