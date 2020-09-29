package com.exam.service;
import static org.junit.Assert.*;
import org.junit.Test;

import com.exam.logger.CustomLogger;
import com.exam.model.UserLog;
import com.exam.service.UserLogService;

public class UserLogServiceTest {
	
	//Unit Test Case
	@Test
	public void checkInsertDelete() throws Exception {
		UserLog userLog =new UserLog();
		userLog.setUserID(101);
		userLog.setAction("started");
		userLog.setLogId(1);
		userLog.setTime(10);
		
		UserLogService userLogService =new UserLogService();
		
		//assertEquals method
		assertEquals(1, userLogService.saveUserLog(userLog));
		CustomLogger.info("Testing save method");
		
		assertEquals(0, userLogService.delete(userLog));
		CustomLogger.info("Testing delete method");
	}
}
