package com.codewithdurgesh.blog.blog_app_apis.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.blog_app_apis.config.AppConstants;
import com.codewithdurgesh.blog.blog_app_apis.entities.Role;
import com.codewithdurgesh.blog.blog_app_apis.entities.User;
import com.codewithdurgesh.blog.blog_app_apis.payload.UserDto;
import com.codewithdurgesh.blog.blog_app_apis.repositories.RolesRepo;
import com.codewithdurgesh.blog.blog_app_apis.repositories.UserRepo;
import com.codewithdurgesh.blog.blog_app_apis.service.UserService;
import com.codewithdurgesh.blog.blog_app_apis.exception.*;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolesRepo rolesRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = userRepo.save(user);
		return this.userToDto(savedUser);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		User user = userRepo.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		User updatedUser = userRepo.save(user);
		
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Long id) {
		
		User user = userRepo.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users = userRepo.findAll();
		List<UserDto> userDtos = users.stream().
				map(user -> userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Long id) {
		
		User user = userRepo.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		userRepo.delete(user);
		
	}
	

	@Override
	public UserDto registerNewUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

		// encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		// roles
		Role role = this.rolesRepo.findById(AppConstants.NORMAL_USER).get();

		user.getRoles().add(role);

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
	}

	    public User dtoToUser (UserDto userDto) {
		//1
		User user = modelMapper.map(userDto, User.class);
		
		//2
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		
		return user;
	}
	
	public UserDto userToDto (User user) {
		
		UserDto userDto = modelMapper.map(user, UserDto.class);
		
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		return userDto;
	}

}
