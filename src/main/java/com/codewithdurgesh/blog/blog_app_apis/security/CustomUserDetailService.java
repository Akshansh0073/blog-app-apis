package com.codewithdurgesh.blog.blog_app_apis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.blog_app_apis.entities.User;
import com.codewithdurgesh.blog.blog_app_apis.exception.ResourceNotFoundException;
import com.codewithdurgesh.blog.blog_app_apis.repositories.UserRepo;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// load user from databse by username and 
		//Giving email as username and password as password
		User user = userRepo.findByEmail(username).orElseThrow(() ->
		new ResourceNotFoundException("User", "email : " + username,0));
		return user;
	}

}
