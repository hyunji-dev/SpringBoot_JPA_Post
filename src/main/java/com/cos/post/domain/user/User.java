package com.cos.post.domain.user;
/*
 * 2020.10.20-1
 * 선행: application.yml
 * 후행:Post.java
 * 
 * 연관관계에 대해 이해하기 
 * 		: USER와 POST(게시글T)는 1:N의 관계 
 * 		N쪽이 F.K의 주인이 된다
 * 
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
public class User {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 데이터베이스 번호증가 전략을 따라가기
	private int id;
	
	@Column(unique = true) // 유니크키
	private String username;
	
	private String password;
	private String email;
	private String role; // 권한
}
