/**
 * 
 */
package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.model.Test;

/**
 * @author 
 *
 */
@Repository
public interface TestRepository extends JpaRepository<Test,Integer>{
	@Query(value="SELECT testid FROM tb_test WHERE categoryid=?1 and userid=?2" ,nativeQuery = true)
	public int getTestID(int categoryID, String userID);
	
	@Query(value="SELECT testid FROM tb_test WHERE categoryid=?1" ,nativeQuery = true)
	public int getTestIDTwo(int categoryID);
	
	@Query(value="SELECT * FROM tb_test WHERE testid=?1" ,nativeQuery = true)
	public List<Test> findByTestId(int id);
}	
