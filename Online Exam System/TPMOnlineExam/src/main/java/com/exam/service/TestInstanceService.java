/**
 * 
 */
package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.TestInstanceNotFoundException;
import com.exam.logger.CustomLogger;
import com.exam.model.TestInstance;
import com.exam.repository.TestInstanceRepository;


/**
 * @author 
 *
 */
@Service
public class TestInstanceService {
	@Autowired
	TestInstanceRepository testInstanceRepo;
	
	//saving/inserting into MySQL database
	public TestInstance createTestInstance(TestInstance testInstance){
		CustomLogger.info("Saving Test Instance via JPA repository into MySQL database");
		return testInstanceRepo.save(testInstance);
	}
	
	//searching Test Instance based on id
	public TestInstance findById(Integer id) throws TestInstanceNotFoundException {
        return testInstanceRepo.findById(id).orElseThrow(()-> new TestInstanceNotFoundException("Test Instance " +id + " not found"));
    }
	
	//deleting Test Instance
	public void deleteTestInstance(TestInstance tInstance){
		CustomLogger.info("Deleting/Removing Test Instance via JPA repository into MySQL database");
		testInstanceRepo.delete(tInstance);
	}
	
	public int saveTestInstance(TestInstance tInstance){
		TestInstance tInstanceobj= testInstanceRepo.save(tInstance);
		if(tInstanceobj!=null){
			return 1;
		}
		return 0;
	}
	
	public int delete(TestInstance tInstance){
		testInstanceRepo.delete(tInstance);
		return 0;
	}
}
