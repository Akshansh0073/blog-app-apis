package com.codewithdurgesh.blog.blog_app_apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.codewithdurgesh.blog.blog_app_apis.payload.ApiResponse;
import com.codewithdurgesh.blog.blog_app_apis.payload.UserDto;
import com.codewithdurgesh.blog.blog_app_apis.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto savedUserDto = userService.createUser(userDto);
		return new ResponseEntity<UserDto>(savedUserDto, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
<<<<<<< HEAD
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long userId) {
=======
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8

		UserDto updatedUser = userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
<<<<<<< HEAD
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
=======
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8

		userService.deleteUser(userId);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {

		List<UserDto> allUser = userService.getAllUser();
		return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
<<<<<<< HEAD
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId) {
=======
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8

		UserDto userDto = userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}

}
