package com.codewithdurgesh.blog.blog_app_apis.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.codewithdurgesh.blog.blog_app_apis.payload.UserDto;


public interface UserService {
	
	UserDto registerNewUser(UserDto user);
	
	UserDto createUser(UserDto user);
	
<<<<<<< HEAD
	UserDto updateUser(UserDto user, Long id);
	
	UserDto getUserById(Long id);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Long id);
=======
	UserDto updateUser(UserDto user, Integer id);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer id);
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
	

}
