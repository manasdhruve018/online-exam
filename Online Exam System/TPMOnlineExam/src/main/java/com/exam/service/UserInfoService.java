/**
 * 
 */
package com.exam.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.exam.exception.UserInfoNotFoundException;
import com.exam.logger.CustomLogger;
import com.exam.model.UserInfo;
import com.exam.repository.UserInfoRepository;

/**
 * @author manasd
 *
 */


@Service("userService")
public class UserInfoService{
	@Autowired
	UserInfoRepository userInfoRepo;

	//saving/inserting User Information into MySQL database
	public UserInfo createUser(UserInfo user){
		CustomLogger.info("Saving User Info via JPA repository into MySQL database");
		return userInfoRepo.save(user);
	}
	
	//searching User Information based on id
	public UserInfo findById(Integer id) throws UserInfoNotFoundException {
        return userInfoRepo.findById(id).orElseThrow(()-> new UserInfoNotFoundException("User Info " +id + " not found"));
    }
	
	//deleting User Information
	public void deleteUser(UserInfo user){
		CustomLogger.info("Deleting/Removing User Info via JPA repository into MySQL database");
		userInfoRepo.delete(user);
	}
	
	//retrieve all Users information
	public Collection<UserInfo> findAllUsers(){
		return userInfoRepo.findAll().stream().collect(Collectors.toList());
	}
	
	public List<String> findEmail(){
		return userInfoRepo.findAllUserNames();
	}
	
	//method to find unique User Name
	public Boolean isUniqueUserName(String username) {
		Boolean status=false;
		for(String users : userInfoRepo.findAllUserNames()) {
			if(users.equals(username)) {
				status= true;
			}
		}
		return status;
	}
	
	//Authenticate User during login (via DES Encryption security)
	public Boolean authenticateUser(Optional<String> userName,String password,String userType) {
		Boolean status=false;
		Optional<String> user=userInfoRepo.findUserForLogin(password, userType);
		if(user==null || !user.isPresent()){
			return status;
		}
		if(user.equals(userName)) {
			status= true;
		}
		return status;
	}
}