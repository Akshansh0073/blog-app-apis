package com.codewithdurgesh.blog.blog_app_apis.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.codewithdurgesh.blog.blog_app_apis.payload.UserDto;


public interface UserService {
	
	UserDto registerNewUser(UserDto user);
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Long id);
	
	UserDto getUserById(Long id);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Long id);
	

}
