package com.cos.post.domain.post;
/*
 * 2020.10.20-5
 * 선행: UserRepository.java
 * 후행: PostController.java
 * 
 */
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Integer>{

}
