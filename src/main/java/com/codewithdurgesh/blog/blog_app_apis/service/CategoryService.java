package com.codewithdurgesh.blog.blog_app_apis.service;

import java.util.List;

import com.codewithdurgesh.blog.blog_app_apis.payload.CategoryDto;

public interface CategoryService {

	 CategoryDto createCategory (CategoryDto categoryDto);
	 
	 CategoryDto updateCategory (CategoryDto categoryDto,Integer categoryId);
	 
	 void deleteCategory (Integer categoryId);
	 
	 CategoryDto getCategoryById (Integer categoryId);
	 
	 List<CategoryDto> getCategories();
	 
}
