package com.codewithdurgesh.blog.blog_app_apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.blog_app_apis.payload.ApiResponse;
import com.codewithdurgesh.blog.blog_app_apis.payload.CategoryDto;
import com.codewithdurgesh.blog.blog_app_apis.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {

		CategoryDto savedCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(savedCategory, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer id) {

		CategoryDto savedCategory = categoryService.updateCategory(categoryDto, id);
		return new ResponseEntity<CategoryDto>(savedCategory, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id) {

		categoryService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted Successfully", true), HttpStatus.OK);
	}

	// get
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer id) {

		CategoryDto category = categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
	}

	// getAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories() {

		List<CategoryDto> categories = categoryService.getCategories();
		return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
	}

}
