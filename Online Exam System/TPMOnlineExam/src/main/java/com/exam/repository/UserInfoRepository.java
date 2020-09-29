/**
 * 
 */
package com.exam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.model.UserInfo;

/**
 * @author tpm
 *
 */

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>{
	
	@Query(value="SELECT user_name FROM tb_user_info",nativeQuery = true)
	List<String> findAllUserNames();
	
	@Query(value="SELECT user_name FROM tb_user_info WHERE password=?1 and user_type=?2 ",nativeQuery = true)
	Optional<String> findUserForLogin(String password,String userType);
	
	@Query(value="SELECT * FROM tb_user_info WHERE user_name=?1",nativeQuery = true)
	UserInfo findByUserName(String userId);
}
