package com.cos.post.domain.post;
/*
 * 2020.10.20-2
 * 선행: User.java
 * 후행: 
 * 
 * POST(게시판T)
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 데이터베이스 번호증가 전략을 따라가기
	private int id;
	
	private String title;
	
	@Column(length = 100000)
	private String content;
	
	private int readCount;
	private int userId;
	
}
