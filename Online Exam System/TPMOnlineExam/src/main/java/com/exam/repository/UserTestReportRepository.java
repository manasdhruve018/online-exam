/**
 * 
 */
package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.UserTestReport;

/**
 * @author 
 *
 */
@Repository
public interface UserTestReportRepository extends JpaRepository<UserTestReport,Integer>{
	
}	
