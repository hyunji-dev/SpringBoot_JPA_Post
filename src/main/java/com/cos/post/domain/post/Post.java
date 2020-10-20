package com.cos.post.domain.post;
/*
 * 2020.10.20-2
 * 선행: User.java
 * 후행: UserController.java
 * 
 * POST(게시판T)
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.post.domain.user.User;

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
	
	// User를 통해서 post를 호출할때만 무시됨 
	@JoinColumn(name="userId") // 필드 이름 지정 // fetch = FetchType.EAGER
	@ManyToOne // DB에 user_id 필드 생성됨
	private User user; // 컬렉션이면 안들고 옴 오브젝트면 조인해서 무조건 들고 오고  
	
}
