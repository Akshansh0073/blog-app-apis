package com.codewithdurgesh.blog.blog_app_apis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithdurgesh.blog.blog_app_apis.entities.User;

@Repository
<<<<<<< HEAD
public interface UserRepo extends JpaRepository<User, Long>{
=======
public interface UserRepo extends JpaRepository<User, Integer>{
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8

	Optional<User> findByEmail (String email);
}
