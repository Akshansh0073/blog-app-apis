package com.codewithdurgesh.blog.blog_app_apis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.blog_app_apis.payload.PostDto;
import com.codewithdurgesh.blog.blog_app_apis.payload.PostResponse;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Long userId, Integer categoryId);
	
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
	List<PostDto> getPostsByUser(Long userId);
	
	//search Post
	List<PostDto> searchPost(String keyword);
	
}
