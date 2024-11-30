package com.codewithdurgesh.blog.blog_app_apis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithdurgesh.blog.blog_app_apis.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByEmail (String email);
}
