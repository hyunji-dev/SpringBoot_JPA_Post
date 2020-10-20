package com.cos.post.domain.user;
/*
 * 2020.10.20-4
 * 선행: UserController.java
 * 후행: PostRepository.java
 */
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
	
}
