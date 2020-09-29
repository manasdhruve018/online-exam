/**
 * 
 */
package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.TestInstance;


/**
 * @author 
 *
 */
public interface TestInstanceRepository extends JpaRepository<TestInstance,Integer>{
	
}
