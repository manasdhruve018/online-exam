package com.exam.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.exam.model.TotalQuestions;
import com.exam.repository.TotalQuestionsRepository;


@Service
public class TotalQuestionsService {

    @Autowired
    TotalQuestionsRepository tQuestionsRepo;
    
    //saving/inserting TotalQuestions into MySQL database
    public TotalQuestions createTotalQuestions(TotalQuestions totalquestions) {
    	
    	return tQuestionsRepo.save(totalquestions);
    }

    public int saveTotalQuestions(TotalQuestions tQuestions){
    	TotalQuestions tQuestionsobj= tQuestionsRepo.save(tQuestions);
		if(tQuestionsobj!=null){
			return 1;
		}
		return 0;
	}
	
	public int delete(TotalQuestions tQuestions){
		
		tQuestionsRepo.delete(tQuestions);
		return 0;
	}
	
	public List<TotalQuestions> findallQuestions(int testId){
		return tQuestionsRepo.findByTestID(testId);
	}
	
}
