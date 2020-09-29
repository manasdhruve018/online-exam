/**
 * 
 */
package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.model.Category;

/**
 * @author 
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
	
	@Query(value="SELECT * FROM tb_category GROUP BY topic_name",nativeQuery = true)
	List<Category> findUniqueTopicName();
	
	/*@Query(value="SELECT c FROM tb_category c WHERE c.topic_name = ?1 " ,nativeQuery = true)
	List<Category> findCategoryFromTopic(String topicName);*/
	
	@Query(value="SELECT * FROM tb_category WHERE topic_name = ?1 GROUP BY category_name",nativeQuery = true)
	public List<Category> findByTopicName(String topicName);
	
	@Query(value="SELECT * FROM tb_category WHERE category_name = ?1  GROUP BY sub_cat_name",nativeQuery = true)
	public List<Category> findByCategoryName(String categoryName);
	
	@Query(value="SELECT categoryID FROM tb_category WHERE category_name=?1 and sub_cat_name=?2 GROUP BY sub_cat_name",nativeQuery = true)
	public int getCategoryID(String categoryName, String sub_cat_name);
}
