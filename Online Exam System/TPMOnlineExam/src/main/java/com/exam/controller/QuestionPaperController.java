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

import com.exam.exception.QuestionPaperNotFoundException;
import com.exam.model.QuestionPaper;
import com.exam.service.QuestionPaperService;

@CrossOrigin
@RestController
@RequestMapping({"/questionpaper"})
public class QuestionPaperController {
	@Autowired
	QuestionPaperService questionPaperService;
	
	@GetMapping(path = {"/{id}"})
	public QuestionPaper findQuestionPaperById(@PathVariable("id") int id) throws QuestionPaperNotFoundException{
	    return questionPaperService.findById(id);
	}
	
	@PostMapping(path = {"/save"})
	public QuestionPaper createQuestionPaper(@RequestBody QuestionPaper questionPaper){
		return questionPaperService.createQuestionPaper(questionPaper);
	}
	
	@DeleteMapping(path = {"/delete"})
	public void deleteQuestionPaper(@RequestBody QuestionPaper qPaper){
		questionPaperService.deleteQuestionPaper(qPaper);
	}
}
