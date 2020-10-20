package com.cos.post.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 2020.10.20-8
 * 선행: Comment.java
 * 후행: CommentController.java
 */


public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
