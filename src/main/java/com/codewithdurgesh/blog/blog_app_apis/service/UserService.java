package com.codewithdurgesh.blog.blog_app_apis.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.codewithdurgesh.blog.blog_app_apis.payload.UserDto;


public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUser();
	void deleteUser(Integer id);
	

}
