/**
 * 
 */
package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.UserTestReportNotFoundException;
import com.exam.logger.CustomLogger;
import com.exam.model.UserTestReport;
import com.exam.repository.UserTestReportRepository;

/**
 * @author 
 *
 */

@Service
public class UserTestReportService {
	@Autowired
	UserTestReportRepository userTestReportRepo;
	
	//saving/inserting into MySQL database
	public UserTestReport createUserTestReport(UserTestReport userTestReport){
		CustomLogger.info("Saving User Test Report via JPA repository into MySQL database");
		return userTestReportRepo.save(userTestReport);
	}
	
	//searching User Test Report based on id
	public UserTestReport findById(Integer id) throws UserTestReportNotFoundException {
        return userTestReportRepo.findById(id).orElseThrow(()-> new UserTestReportNotFoundException("UserTestReport " +id + " not found"));
    }
	
	//deleting User Test Report details from the database
	public void deleteUserTestReport(UserTestReport userTestReport){
		CustomLogger.info("Deleting/Removing User Test Report via JPA repository into MySQL database");
		userTestReportRepo.delete(userTestReport);
	}
}