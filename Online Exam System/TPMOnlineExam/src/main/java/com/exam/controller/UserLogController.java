package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.UserLogNotFoundException;
import com.exam.model.UserLog;
import com.exam.service.UserLogService;
/**
 * @author tpm
 *
 */
@CrossOrigin
@RestController
@RequestMapping({"/userlog"})
public class UserLogController {
	@Autowired
	UserLogService userLogService;
	
	@GetMapping(path = {"/{id}"})
	public UserLog findUserLogById(@PathVariable("id") int id) throws UserLogNotFoundException{
	    return userLogService.findById(id);
	}
	
	@PostMapping(path = {"/save"})
	public UserLog createUserLog(@RequestBody UserLog userLog){
		return userLogService.createUserLog(userLog);
	}
	
	@DeleteMapping(path = {"/delete"})
	public void deleteUserLog(@RequestBody UserLog userLog){
		userLogService.deleteUserLog(userLog);
	}
}
