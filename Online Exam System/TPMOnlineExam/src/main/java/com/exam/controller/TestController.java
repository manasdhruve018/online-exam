package com.exam.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.TestNotFoundException;
import com.exam.model.Test;
import com.exam.service.TestService;


@CrossOrigin
@RestController
@RequestMapping({"/test"})
public class TestController {
	@Autowired
	TestService testService;
	
	@GetMapping(path = {"/{id}"})
	public Test findTestById(@PathVariable("id") int id) throws TestNotFoundException{
	    return testService.findById(id);
	}
	
	@GetMapping(path = {"/get"})
	@ResponseBody
	public Collection<Test> getTests(){
		return testService.findAllTests();
	}
	
	@PostMapping(path = {"/save"})
	public Test createTest(@RequestBody Test test){
		return testService.createTest(test);
	}
	
	@DeleteMapping(path = {"/delete"})
	public void deleteTest(@RequestBody Test test){
		testService.deleteTest(test);
	}
	
	@GetMapping(path= {"/id/{categoryid}/{userid}"})
	@ResponseBody
	public int getTestID(@PathVariable("categoryid") int categoryid,@PathVariable("userid") String userid){
		return testService.getTestID(categoryid,userid);
	}
	
	@GetMapping(path= {"/id/{categoryid}"})
	@ResponseBody
	public int getTestIDTwo(@PathVariable("categoryid") int categoryid){
		return testService.getTestIDTwo(categoryid);
	}
	
	@GetMapping(path= {"/findallbytestid/{testid}"})
	@ResponseBody
	public List<Test> getAllTestsById(@PathVariable("testid") int testid){
		return testService.findAllTestById(testid);
	}
	
}
