package com.exam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	public Category(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoryID",nullable = false)
	private int categoryID;
	
	@Column(name="categoryName")
	private String categoryName;	

	@Column(name="sub_catName")
	private String sub_catName;
	
	@Column(name="topicName")
	private String topicName;

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSub_catName() {
		return sub_catName;
	}

	public void setSub_catName(String sub_catName) {
		this.sub_catName = sub_catName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Category(int categoryID, String categoryName, String sub_catName,
			String topicName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.sub_catName = sub_catName;
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName
				+ ", sub_catName=" + sub_catName + ", topicName=" + topicName + "]";
	}
	
}
