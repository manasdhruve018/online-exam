package com.exam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.exam.model.TotalQuestions;
import com.exam.service.TotalQuestionsService;


@CrossOrigin
@RequestMapping({"/allquestions"})
@RestController
public class TotalQuestionsController {
    @Autowired
    TotalQuestionsService questionsService;

    @PostMapping(path = {"/save"})
    public TotalQuestions createQuestion(@RequestBody TotalQuestions tQuestions)
    {
        return questionsService.createTotalQuestions(tQuestions);
    }
    
    @GetMapping(path= {"fetchbytest/{testId}"})
    @ResponseBody
    public List<TotalQuestions> findAllQuestions(@PathVariable("testId") int testId){
    	List<TotalQuestions> answer= questionsService.findallQuestions(testId);
    	System.out.println(answer.get(0).getQuestion());
    	return answer;
    }

}
