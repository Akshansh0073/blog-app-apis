package com.codewithdurgesh.blog.blog_app_apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdurgesh.blog.blog_app_apis.entities.Category;
import com.codewithdurgesh.blog.blog_app_apis.entities.Post;
import com.codewithdurgesh.blog.blog_app_apis.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByCategory(Category category);
	
	List<Post> findByUser(User user);
	
}
