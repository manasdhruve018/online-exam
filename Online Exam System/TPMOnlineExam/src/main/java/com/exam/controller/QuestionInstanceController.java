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


import com.exam.exception.QuestionInstanceNotFoundException;
import com.exam.model.QuestionInstance;
import com.exam.service.QuestionInstanceService;


@CrossOrigin
@RestController
@RequestMapping({"/questioninstance"})
public class QuestionInstanceController {
	@Autowired
	QuestionInstanceService questionInstanceService;
	
	@GetMapping(path = {"/{id}"})
	public QuestionInstance findQuestionInstanceById(@PathVariable("id") int id) throws QuestionInstanceNotFoundException{
	    return questionInstanceService.findById(id);
	}
	
	@PostMapping(path = {"/save"})
	public QuestionInstance createQuestionInstance(@RequestBody QuestionInstance questionInstance){
		return questionInstanceService.createQuestionInstance(questionInstance);
	}
	
	@DeleteMapping(path = {"/delete"})
	public void deleteQuestionInstance(@RequestBody QuestionInstance questionInstance){
		questionInstanceService.deleteQuestionInstance(questionInstance);
	}
}
