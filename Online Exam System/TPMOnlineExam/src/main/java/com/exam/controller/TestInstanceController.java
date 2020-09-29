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

import com.exam.exception.TestInstanceNotFoundException;
import com.exam.model.TestInstance;
import com.exam.service.TestInstanceService;

@CrossOrigin
@RestController
@RequestMapping({"/testinstance"})
public class TestInstanceController {
	@Autowired
	TestInstanceService testInstanceService;
	
	@GetMapping(path = {"/{id}"})
	public TestInstance findTestInstanceById(@PathVariable("id") int id) throws TestInstanceNotFoundException{
	    return testInstanceService.findById(id);
	}
	
	@PostMapping(path = {"/save"})
	public TestInstance createTestInstance(@RequestBody TestInstance testInstance){
		return testInstanceService.createTestInstance(testInstance);
	}
	
	@DeleteMapping(path = {"/delete"})
	public void deleteTestInstance(@RequestBody TestInstance tInstance){
		testInstanceService.deleteTestInstance(tInstance);
	}
}
