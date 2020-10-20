package com.cos.post.web;
/*
 * 2020.10.20-6
 * 선행: PostRepository.java
 * 후행: Comment.java 
 */

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.post.domain.post.Post;
import com.cos.post.domain.post.PostRepository;
import com.cos.post.domain.user.User;
import com.cos.post.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostController {
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	@PostMapping("/post")
	public String 글쓰기(@RequestBody Post post) {
		User userEntity = userRepository.findById(1).get();
		
		post.setReadCount(0);
		post.setUser(userEntity); // 오브젝트를 넣음 
		postRepository.save(post);
		return "ok";
	}
	
	@GetMapping("/post")
	public List<Post> 글목록() {
		return postRepository.findAll();
	}
	
	@GetMapping("/post/{id}")
	public Post 글상세(@PathVariable int id) {
		Post post = postRepository.findById(id).get();
		System.out.println("post만 있음---------------");
		post.getUser().getEmail();
		System.out.println("---------Lazy Loading(지연로딩) 실행 ");
		return post; // Jackson 라이브러리 - getter 실행?
	}
}
