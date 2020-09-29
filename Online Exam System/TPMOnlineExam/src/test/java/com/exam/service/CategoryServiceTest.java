package com.exam.service;
import static org.junit.Assert.*;
import org.junit.Test;

import com.exam.logger.CustomLogger;
import com.exam.model.Category;
import com.exam.service.CategoryService;

public class CategoryServiceTest{
	//Unit Test Case
	@Test
	public void checkInsertDelete() throws Exception {
		Category category= new Category();
		
		category.setCategoryID(1);
		category.setCategoryName("technical");
		category.setSub_catName("java");
		category.setTopicName("classes");
		CategoryService categoryService=new CategoryService();
		
		//assertEquals method
		assertEquals(1, categoryService.saveCategory(category));
		CustomLogger.info("Testing save method");
		
		assertEquals(0, categoryService.delete(category));
		CustomLogger.info("Testing delete method");
	}
}
