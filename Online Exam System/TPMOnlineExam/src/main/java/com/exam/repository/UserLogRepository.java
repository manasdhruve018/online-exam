/**
 * 
 */
package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.UserLog;

/**
 * @author 
 *
 */
@Repository
public interface UserLogRepository extends JpaRepository<UserLog,Integer>{
	
}
