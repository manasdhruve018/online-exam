package com.exam.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.model.TestInfo;




@Repository
public interface TestInfoRepository extends JpaRepository<TestInfo,Integer>{

	@Modifying
	@Transactional
	@Query(value="UPDATE tb_testinfo  SET marks=:marks , answer= :answer WHERE que_id=:que_id",nativeQuery = true)
	int changeMarkEntry(@Param("marks") int marks ,@Param("answer") String answer,@Param("que_id") int que_id);
}
