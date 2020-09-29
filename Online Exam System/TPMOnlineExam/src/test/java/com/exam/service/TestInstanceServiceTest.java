package com.exam.service;
import static org.junit.Assert.*;
import org.junit.Test;

import com.exam.logger.CustomLogger;
import com.exam.model.TestInstance;

public class TestInstanceServiceTest{
	//Unit Test Case
	@Test
	public void checkInsertDelete() throws Exception {
		TestInstance tInstance= new TestInstance();
		
		tInstance.setTinstanceID(1);
		tInstance.setTestID(100);
		tInstance.setUserID(100);
		tInstance.setMarksObtained(2);
		tInstance.setStartTime(10);
		tInstance.setEndTime(11);
		tInstance.setAttempt(true);
		TestInstanceService tInstanceService=new TestInstanceService();
		
		//assertEquals method
		assertEquals(1, tInstanceService.saveTestInstance(tInstance));
		CustomLogger.info("Testing save method");
		
		assertEquals(0, tInstanceService.delete(tInstance));
		CustomLogger.info("Testing delete method");
	}
}
