package com.codewithdurgesh.blog.blog_app_apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.blog_app_apis.payload.ApiResponse;
import com.codewithdurgesh.blog.blog_app_apis.payload.CommentDto;
import com.codewithdurgesh.blog.blog_app_apis.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment
	(@RequestBody CommentDto commentDto,@PathVariable Integer postId){
		
		CommentDto newCommentDto = commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(newCommentDto,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> createComment
	(@PathVariable Integer commentId){
		
		commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment successfully deleted", true),HttpStatus.OK);
	}
}
