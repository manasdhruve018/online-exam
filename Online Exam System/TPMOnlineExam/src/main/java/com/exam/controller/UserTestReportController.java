package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.UserTestReportNotFoundException;
import com.exam.model.UserTestReport;
import com.exam.service.UserTestReportService;

@CrossOrigin
@RestController
@RequestMapping({"/usertestreport"})
public class UserTestReportController {
	@Autowired
	UserTestReportService userTestReportService;
	
	@GetMapping(path = {"/{id}"})
	public UserTestReport findUserTestReportById(@PathVariable("id") int id) throws UserTestReportNotFoundException{
	    return userTestReportService.findById(id);
	}
	
	@PostMapping(path = {"/save"})
	public UserTestReport createUserTestReport(@RequestBody UserTestReport userTestReport){
		return userTestReportService.createUserTestReport(userTestReport);
	}
	
	@DeleteMapping(path = {"/delete"})
	public void deleteUserTestReport(@RequestBody UserTestReport userTestReport){
		userTestReportService.deleteUserTestReport(userTestReport);
	}
}
