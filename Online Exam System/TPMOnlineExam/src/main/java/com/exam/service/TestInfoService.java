package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.TestInfo;
import com.exam.repository.TestInfoRepository;

@Service
public class TestInfoService {

	@Autowired
	TestInfoRepository testRepository;
	
	public TestInfo createTestInfo(TestInfo testInfo) {
    	
    	return testRepository.save(testInfo);
    }
	
	public int updateMarks(int marks,String answer,int totalqueId) {
		return testRepository.changeMarkEntry(marks,answer,totalqueId);
	}
}
