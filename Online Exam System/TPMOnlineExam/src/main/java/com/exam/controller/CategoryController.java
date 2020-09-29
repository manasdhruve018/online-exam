package com.exam.controller;

import java.util.Collection;
import java.util.List;

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

import com.exam.exception.CategoryNotFoundException;
import com.exam.model.Category;
import com.exam.service.CategoryService;
/**
 * @author manasd
 *
 */
@CrossOrigin
@RestController
@RequestMapping({"/category"})
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(path = {"/{id}"})
	public Category findCategoryById(@PathVariable("id") int id) throws CategoryNotFoundException{
	    return categoryService.findById(id);
	}
	
	@PostMapping(path = {"/save"})
	public Category createCategory(@RequestBody Category category){
		return categoryService.createCategory(category);
	}
	
	@DeleteMapping(path = {"/delete"})
	public void deleteCategory(@RequestBody Category category){
		categoryService.deleteCategory(category);
	}
	
	@GetMapping(path = {"/get"})
	@ResponseBody
	public Collection<Category> getCategories(){
		return categoryService.findAllCategories();
	}
	
	@GetMapping(path= {"/topics/topic_name"})
	@ResponseBody
	public List<Category> getAllDistinctTopicName(){
		return categoryService.findAllUniqueTopicName();
	}
	
	@GetMapping(path= {"/course/{category_name}"})
	@ResponseBody
	public List<Category> getCategoryFromTopic(@PathVariable("category_name") String topicName){
		return categoryService.findCategoryFromTopic(topicName);
	}
	
	@GetMapping(path= {"/subcategory/{subcategory}"})
	@ResponseBody
	public List<Category> getSubCategoryFromCategory(@PathVariable("subcategory") String subcategory){
		return categoryService.findSubCategoryFromCategoryName(subcategory);
	}
	
	@GetMapping(path= {"/id/{category}/{subcategory}"})
	@ResponseBody
	public int getCategoryID(@PathVariable("category") String category,@PathVariable("subcategory") String subcategory){
		return categoryService.getCategoryID(category,subcategory);
	}
	
}
	

