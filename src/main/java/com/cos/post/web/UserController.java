package com.cos.post.web;
/*
 * 2020.10.20-3
 * 선행: Post.java
 * 후행: UserRepository.java
 */

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.post.domain.user.User;
import com.cos.post.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor // 생성자 만들 때 꼭 초기화되어야할 게 있으면 그거에 대한 생성자 만들어달라는 어노테이션, final이 붙은 걸 생성자 만들어줌 
@RestController
public class UserController {
	
	private final UserRepository userRepository;
	
	
	@PostMapping("/user")
	public String 회원가입(@RequestBody User user) {
		userRepository.save(user);
		return "ok";
	}
	
	@GetMapping("/user")
	public List<User> 유저목록() {
		return userRepository.findAll(); // Jackson 라이브러리 - getter 실행?
	}
	
	@GetMapping("/user/{id}")
	public User 유저상세(@PathVariable int id) {
		User user = userRepository.findById(id).get();
		return user; // Jackson 라이브러리 - getter 실행?
	}
}
