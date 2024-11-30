package com.codewithdurgesh.blog.blog_app_apis.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.blog_app_apis.entities.Comment;
import com.codewithdurgesh.blog.blog_app_apis.entities.Post;
import com.codewithdurgesh.blog.blog_app_apis.exception.ResourceNotFoundException;
import com.codewithdurgesh.blog.blog_app_apis.payload.CommentDto;
import com.codewithdurgesh.blog.blog_app_apis.repositories.CommentRepo;
import com.codewithdurgesh.blog.blog_app_apis.repositories.PostRepo;
import com.codewithdurgesh.blog.blog_app_apis.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = postRepo.findById(postId).
				orElseThrow(() -> new ResourceNotFoundException("Post","Post id",postId));
		
		Comment comment = modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = commentRepo.save(comment);
		
		return modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {


		Comment comment = commentRepo.findById(commentId).
				orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment id", commentId));
		
		commentRepo.delete(comment);
	}

}
