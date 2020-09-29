/**
 * 
 */
package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.UserLogNotFoundException;
import com.exam.logger.CustomLogger;
import com.exam.model.UserLog;
import com.exam.repository.UserLogRepository;

/**
 * @author 
 *
 */

@Service
public class UserLogService {
	@Autowired
	UserLogRepository userLogRepo;
	
	//saving/inserting User Logs into MySQL database
	public UserLog createUserLog(UserLog userLog){
		CustomLogger.info("Saving User Log via JPA repository into MySQL database");
		return userLogRepo.save(userLog);
	}
	
	//searching User Logs based on id
	public UserLog findById(Integer id) throws UserLogNotFoundException {
        return userLogRepo.findById(id).orElseThrow(()-> new UserLogNotFoundException("User Logs " +id + " not found"));
    }
	
	//deleting User Logs
	public void deleteUserLog(UserLog userLog){
		CustomLogger.info("Deleting/Removing User Log via JPA repository into MySQL database");
		userLogRepo.delete(userLog);
	}
	
	public int saveUserLog(UserLog userLog){
		UserLog userlog=userLogRepo.save(userLog);
		if(userlog!=null){
			int x=1;
			return x;
		}
		return 0;	
	}
	
	public int delete(UserLog userLog){
		userLogRepo.delete(userLog);
		return 0;
	}
	
}