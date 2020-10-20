package com.cos.post.web;
/*
 * 2020.10.20-9
 * 선행: CommentRepository.java
 * 후행: 
 */


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.post.domain.comment.Comment;
import com.cos.post.domain.comment.CommentRepository;
import com.cos.post.domain.post.Post;
import com.cos.post.domain.post.PostRepository;
import com.cos.post.domain.user.User;
import com.cos.post.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class CommentController {
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final PostRepository postRepository;
	
	@PostMapping("/post/{postId}/comment")
	public String 댓글쓰기(@RequestBody Comment comment, @PathVariable int postId) {
		User userEntity = userRepository.findById(1).get();
		Post postEntity = postRepository.findById(postId).get();
		
		comment.setUser(userEntity);
		comment.setPost(postEntity);
		commentRepository.save(comment);
		return "ok";
	}
	
}
