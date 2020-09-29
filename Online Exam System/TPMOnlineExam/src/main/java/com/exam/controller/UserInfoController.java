package com.exam.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.UserInfoNotFoundException;
import com.exam.logger.CustomLogger;
import com.exam.model.UserInfo;
import com.exam.service.PasswordService;
import com.exam.service.UserInfoService;

@CrossOrigin
@RestController
@RequestMapping({"/userinfo"})
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	
	@GetMapping(path = {"/{id}"})
	public UserInfo findUserInfoById(@PathVariable("id") int id) throws UserInfoNotFoundException{
	    return userInfoService.findById(id);
	}
	
	@PostMapping(path = {"/save"})
	public UserInfo createUserInfo(@RequestBody UserInfo user) throws Exception{
		user.setPassword(new PasswordService().encrypt(user.getPassword()));
		CustomLogger.info(user.getPassword());
		return userInfoService.createUser(user);
	}
	
	@DeleteMapping(path = {"/delete"})
	public void deleteUserInfo(@RequestBody UserInfo user){
		userInfoService.deleteUser(user);
	}
	
	@GetMapping(path = {"/get"})
	@ResponseBody
	public Collection<UserInfo> getUsers(){
		return userInfoService.findAllUsers();
	}
	
	@GetMapping(path= {"/uniqueuser/{username}"})
	@ResponseBody
	public Boolean isUniqueUser(@PathVariable("username") String username) {
		return userInfoService.isUniqueUserName(username);
	}
	
	@GetMapping(path= {"/uniqueuser1"})
	@ResponseBody
	public List<String> isUniqueUser1() {
		return userInfoService.findEmail();
	}
	
	@GetMapping(path= {"/userloggedin/{username}/{password}/{usertype}"})
	@ResponseBody
	public Boolean isAuthenticated(@PathVariable("username") Optional<String> userName,@PathVariable("password") String password,@PathVariable("usertype") String userType) throws Exception 
	{
		password = new PasswordService().encrypt(password);
		return userInfoService.authenticateUser(userName, password, userType);
	}
	
}
