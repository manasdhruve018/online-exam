/**
 * 
 */
package com.exam.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.TestNotFoundException;

import com.exam.model.Test;
import com.exam.repository.TestRepository;

/**
 * @author manasd
 *
 */
@Service
public class TestService {
	@Autowired
	TestRepository testRepo;
	
	//saving/inserting Test into MySQL database
	public Test createTest(Test test){
		
		return testRepo.save(test);
	}
	
	//searching Test based on id
	public Test findById(Integer id) throws TestNotFoundException {
        return testRepo.findById(id).orElseThrow(()-> new TestNotFoundException("Test " +id + " not found"));
    }
	
	//retrieve Tests
	public Collection<Test> findAllTests(){
		return testRepo.findAll().stream().collect(Collectors.toList());
	}
	
	//deleting Test from database
	public void deleteTest(Test test){
		
		testRepo.delete(test);
	}
	
	public int getTestID(int categoryID, String userID){
		return testRepo.getTestID(categoryID, userID);
	}
	
	public int getTestIDTwo(int categoryID){
		return testRepo.getTestIDTwo(categoryID);
	}
	
	public List<Test> findAllTestById(int testId){
		return testRepo.findByTestId(testId);
	}
}
