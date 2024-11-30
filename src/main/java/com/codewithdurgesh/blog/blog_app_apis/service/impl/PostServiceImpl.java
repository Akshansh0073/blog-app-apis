package com.codewithdurgesh.blog.blog_app_apis.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.blog_app_apis.entities.Category;
import com.codewithdurgesh.blog.blog_app_apis.entities.Post;
import com.codewithdurgesh.blog.blog_app_apis.entities.User;
import com.codewithdurgesh.blog.blog_app_apis.exception.ResourceNotFoundException;
import com.codewithdurgesh.blog.blog_app_apis.payload.CategoryDto;
import com.codewithdurgesh.blog.blog_app_apis.payload.PostDto;
import com.codewithdurgesh.blog.blog_app_apis.payload.PostResponse;
import com.codewithdurgesh.blog.blog_app_apis.payload.UserDto;
import com.codewithdurgesh.blog.blog_app_apis.repositories.CategoryRepo;
import com.codewithdurgesh.blog.blog_app_apis.repositories.PostRepo;
import com.codewithdurgesh.blog.blog_app_apis.repositories.UserRepo;
import com.codewithdurgesh.blog.blog_app_apis.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Long userId, Integer categoryId) {

		User user = this.userRepo.findById(userId).
				orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
		
		Category category = this.categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category","Category id",categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
		Post newPost = postRepo.save(post);
		
		return modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		Post post = postRepo.findById(postId).
				orElseThrow(() -> new ResourceNotFoundException("Post","Post id",postId));
		
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle());
		post.setImageName(postDto.getImageName());
		
		Post savedPost = postRepo.save(post);
		
		return modelMapper.map(savedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		
		Post post = postRepo.findById(postId).
				orElseThrow(() -> new ResourceNotFoundException("Post","Post id",postId));
		postRepo.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		
		Sort sort = null;
		
		if(sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}
		
		PageRequest p = PageRequest.of(pageNumber, pageSize, sort);
		Page<Post> pagePost = postRepo.findAll(p);
		List<Post> posts = pagePost.getContent();
		
		List<PostDto> postDtos = posts.stream().
				map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElement(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post = postRepo.findById(postId).
				orElseThrow(() -> new ResourceNotFoundException("Post","Post id",postId));
		PostDto postDto = modelMapper.map(post, PostDto.class);
		return postDto;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category","Category id",categoryId));
		List<Post> posts = postRepo.findByCategory(category);
		List<PostDto> postDtos = posts.stream().
				map(post -> modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Long userId) {
		
		User user = this.userRepo.findById(userId).
				orElseThrow(() -> new ResourceNotFoundException("User","user id",userId));
		List<Post> posts = postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().
				map(post -> modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<Post> posts = postRepo.searchPost("%" +keyword+ "%");
		
		// method 2 
//		List<Post> posts = postRepo.findByTitleContaining(keyword);
		
		List<PostDto> postDtos = posts.stream().
				map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
