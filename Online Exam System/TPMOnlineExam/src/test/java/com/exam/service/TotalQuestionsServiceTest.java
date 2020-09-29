package com.exam.service;
import static org.junit.Assert.*;
import org.junit.Test;
import com.exam.logger.CustomLogger;
import com.exam.model.TotalQuestions;


public class TotalQuestionsServiceTest{
	//Unit Test Case
	@Test
	public void checkInsertDelete() throws Exception {
		TotalQuestions tQuestions= new TotalQuestions();
		
		tQuestions.setTotalQueId(1);
		tQuestions.setQuestion("Java is 100% Object Oriented programming language");
		tQuestions.setOptionOne("yes");
		tQuestions.setOptionTwo("no");
		tQuestions.setOptionThree("may be");
		tQuestions.setOptionFour("none");
		tQuestions.setCorrectAnswer("no");
		tQuestions.setDiffLevel("easy");
		tQuestions.setMarks(3);
		
		TotalQuestionsService tQuestionsService=new TotalQuestionsService();
		
		//assertEquals method
		assertEquals(1, tQuestionsService.saveTotalQuestions(tQuestions));
		CustomLogger.info("Testing save method");
		
		assertEquals(0, tQuestionsService.delete(tQuestions));
		CustomLogger.info("Testing delete method");
	}
}
