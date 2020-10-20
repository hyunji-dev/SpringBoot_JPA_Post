package com.cos.post.domain.post;
/*
 * 2020.10.20-2
 * 선행: User.java
 * 후행: UserController.java
 * 
 * POST(게시판T)
 */

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cos.post.domain.comment.Comment;
import com.cos.post.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	// User를 통해서 post를 호출할때만 무시됨 (무한참조 방지)
	// post를 select하면 연관관계에 있는 User오브젝트의 posts를 lazy-loading 하지 않기 위해!!
	// post를 select하면 연관관계에 있는 Comment오브젝트의 user와 post를 lazy-loading하지 않기 위해!!
	@JsonIgnoreProperties({"post"})
	// F.K의 주인이 아닌 쪽에서 연관관계를 맺게 되면 F.K가 아니라고 명시할 필요있음 
	@JoinColumn(name="userId") // 필드 이름 지정 // fetch = FetchType.EAGER
	@ManyToOne // DB에 user_id 필드 생성됨
	private User user; // 컬렉션이면 안들고 옴 오브젝트면 조인해서 무조건 들고 오고  
	
	// 게시글 상세보기시에 댓글을 항상 바로 바로 볼것이기 때문에 fetch전략 eager로 변경
	@JsonIgnoreProperties({"user", "post"})
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	private List<Comment> comments;
	
}
