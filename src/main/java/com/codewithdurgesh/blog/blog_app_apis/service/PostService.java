package com.codewithdurgesh.blog.blog_app_apis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.blog_app_apis.payload.PostDto;
import com.codewithdurgesh.blog.blog_app_apis.payload.PostResponse;

public interface PostService {

	// create
<<<<<<< HEAD
	PostDto createPost(PostDto postDto, Long userId, Integer categoryId);
=======
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
	
	// update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	// get All posts
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	// get single Post
	PostDto getPostById(Integer postId);
	
	// get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all post by user
<<<<<<< HEAD
	List<PostDto> getPostsByUser(Long userId);
=======
	List<PostDto> getPostsByUser(Integer userId);
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
	
	//search Post
	List<PostDto> searchPost(String keyword);
	
}
