package com.codewithdurgesh.blog.blog_app_apis.service;

import com.codewithdurgesh.blog.blog_app_apis.payload.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto comment, Integer postId);
	void deleteComment(Integer commentId);
}
