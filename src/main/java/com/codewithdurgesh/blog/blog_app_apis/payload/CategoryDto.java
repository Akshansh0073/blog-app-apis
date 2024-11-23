package com.codewithdurgesh.blog.blog_app_apis.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {

	private Integer categoryId;
	
	@NotBlank
	@Size(min = 4, message="title contains at least 4 letters")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message="Description must contain at least 10 letters")
	private String categoryDescription;
	
	
	public CategoryDto() {
		super();
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
}
