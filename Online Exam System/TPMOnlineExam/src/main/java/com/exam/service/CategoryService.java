/**
 * 
 */
package com.exam.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exception.CategoryNotFoundException;
import com.exam.logger.CustomLogger;
import com.exam.model.Category;
import com.exam.repository.CategoryRepository;

/**
 * @author 
 *
 */

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepo;
	
	//saving Category
	public Category createCategory(Category category){
		CustomLogger.info("Saving Category via JPA repository into MySQL database");
		return categoryRepo.save(category);
	}
	
	//searching Category based on id
	public Category findById(Integer id) throws CategoryNotFoundException {
        return categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category " +id + " not found"));
    }
	
	//deleting Category from database
	public void deleteCategory(Category category){
		CustomLogger.info("Deleting/Removing Category via JPA repository into MySQL database");
		categoryRepo.delete(category);
	}
	
	//retrieve Categories
	public Collection<Category> findAllCategories(){
		return categoryRepo.findAll().stream().collect(Collectors.toList());
	}
	
	//finding unique topic name
	public List<Category> findAllUniqueTopicName(){
		return categoryRepo.findUniqueTopicName();
	}
	
	//finding categories related to dynamic topic name
	public List<Category> findCategoryFromTopic(String topicName){
		return categoryRepo.findByTopicName(topicName);
	}
	
	//finding sub categories related to dynamic category name
	public List<Category> findSubCategoryFromCategoryName(String categoryName){
		return categoryRepo.findByCategoryName(categoryName);
	}
	
	public int getCategoryID(String categoryName, String sub_cat_name){
		return categoryRepo.getCategoryID(categoryName, sub_cat_name);
	}
	
	public int saveCategory(Category category){
		Category categoryobj= categoryRepo.save(category);
		if(categoryobj!=null){
			return 1;
		}
		return 0;
	}
	
	public int delete(Category category){
		categoryRepo.delete(category);
		return 0;
	}
}