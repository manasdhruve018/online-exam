package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.exam.model.TestInfo;
import com.exam.service.TestInfoService;


@CrossOrigin
@RestController
@RequestMapping({"/testinfo"})
public class TestInfoController {

	@Autowired
	TestInfoService testService;
	
	@PostMapping(path = {"/save"})
	public TestInfo createTestInfo(@RequestBody TestInfo test){
		return testService.createTestInfo(test);
	}
	
	@PutMapping(path= {"/updatemarks/{marks}/{answer}/{totalqueid}"})
	public int updateMarkOfQuestion(@PathVariable("marks") int marks,@PathVariable("answer") String answer,@PathVariable("totalqueid") int totalqueid) {
		return testService.updateMarks(marks,answer,totalqueid);
	}
}
