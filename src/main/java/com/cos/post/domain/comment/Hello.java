package com.cos.post.domain.comment;
/*
 * 2020.10.20 
 * 
 * 테스트용 
 */
import org.springframework.stereotype.Component;

import com.cos.post.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor 
public class Hello {
	
	//@Autowired // 밑의 Hello(UserRepository userRepository)를 이 어노테이션이 대신함
	private final UserRepository userRepository;
	
	
//	public Hello(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
}
