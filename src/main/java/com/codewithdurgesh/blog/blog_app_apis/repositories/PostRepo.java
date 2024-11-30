package com.codewithdurgesh.blog.blog_app_apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewithdurgesh.blog.blog_app_apis.entities.Category;
import com.codewithdurgesh.blog.blog_app_apis.entities.Post;
import com.codewithdurgesh.blog.blog_app_apis.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByCategory(Category category);
	
	List<Post> findByUser(User user);
	
	List<Post> findByTitleContaining(String title);
	
	// second method
	@Query("select p from Post p where p.title like :key")
	List<Post> searchPost (@Param("key") String title);
	 
}
