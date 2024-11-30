package com.codewithdurgesh.blog.blog_app_apis.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.blog_app_apis.entities.Category;
import com.codewithdurgesh.blog.blog_app_apis.exception.ResourceNotFoundException;
import com.codewithdurgesh.blog.blog_app_apis.payload.CategoryDto;
import com.codewithdurgesh.blog.blog_app_apis.repositories.CategoryRepo;
import com.codewithdurgesh.blog.blog_app_apis.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category = dtoToCategory(categoryDto);
		Category savedCategory = categoryRepo.save(category);
		
		return categoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category category = categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category","Category id",categoryId));
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		Category updatedCategory = categoryRepo.save(category);
		
		return categoryToDto(updatedCategory);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category","Category id",categoryId));
		categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category","Category id",categoryId));
		
		return categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> categoryDtos = categories.stream().
				map((category) -> categoryToDto(category)).collect(Collectors.toList());
		
		return categoryDtos;
	}
	
	public CategoryDto categoryToDto(Category category) {
		
		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		
		Category category = modelMapper.map(categoryDto, Category.class);
		return category;
	}

}
