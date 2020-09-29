/**
 * 
 */
package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.QuestionInstanceNotFoundException;
import com.exam.logger.CustomLogger;
import com.exam.model.QuestionInstance;
import com.exam.repository.QuestionInstanceRepository;

/**
 * @author 
 *
 */
@Service
public class QuestionInstanceService {
	@Autowired
	QuestionInstanceRepository qInstanceRepo;
	
	//saving/inserting Question Instance into the database
	public QuestionInstance createQuestionInstance(QuestionInstance qInstance){
		CustomLogger.info("Saving Question Instance via JPA repository into MySQL database");
		return qInstanceRepo.save(qInstance);
	}
	
	//searching Question Instance based on id
	public QuestionInstance findById(Integer id) throws QuestionInstanceNotFoundException {
        return qInstanceRepo.findById(id).orElseThrow(()-> new QuestionInstanceNotFoundException("Question Instance " +id + " not found"));
    }
	
	//deleting Question Instance from database
	public void deleteQuestionInstance(QuestionInstance questionInstance){
		CustomLogger.info("Deleting/Removing Question Instance via JPA repository into MySQL database");
		qInstanceRepo.delete(questionInstance);
	}
}
