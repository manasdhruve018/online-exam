/**
 * 
 */
package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.QuestionPaperNotFoundException;
import com.exam.logger.CustomLogger;
import com.exam.model.QuestionPaper;
import com.exam.repository.QuestionPaperRepository;

/**
 * @author tpm
 *
 */
@Service
public class QuestionPaperService {
	@Autowired
	QuestionPaperRepository questionPaperRepo;
	
	//saving/inserting Question Paper into MySQL database
	public QuestionPaper createQuestionPaper(QuestionPaper qPaper){
		CustomLogger.info("Saving Question Paper via JPA repository into MySQL database");
		return questionPaperRepo.save(qPaper);
	}
	
	//searching Question Paper based on id
	public QuestionPaper findById(Integer id) throws QuestionPaperNotFoundException {
        return questionPaperRepo.findById(id).orElseThrow(()-> new QuestionPaperNotFoundException("Question Paper " +id + " not found"));
    }
	
	//deleting User Information
	public void deleteQuestionPaper(QuestionPaper qPaper){
		CustomLogger.info("Deleting/Removing Question Paper via JPA repository into MySQL database");
		questionPaperRepo.delete(qPaper);
	}
}
