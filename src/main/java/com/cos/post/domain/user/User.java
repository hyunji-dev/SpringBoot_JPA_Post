package com.cos.post.domain.user;
/*
 * 2020.10.20-1
 * 선행: application.yml
 * 후행:Post.java
 * 
 * USER:POST = 1:N
 * 
 * 연관관계 규칙 
 * 		1.F.K의 주인은 N쪽이다
 * 		2.ManyToMany는 항상 새로운 테이블이 필요하다. 왜냐하면 F.K를 둘 곳이 없기 때문
 * 			- 이때 새로운 테이블과의 관계는 OneToMany, OneToMany의 관계
 * 			- 여기서 F.K의 주인은 새로운 테이블이다
 * 무한참조를 방지하려면 jackson이 발생할 때 지연로딩 할 때 @JsonIgnoreProperties에 무시하고 싶은 프로퍼티 이름 넣기
 */

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cos.post.domain.post.Post;
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
public class User {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 데이터베이스 번호증가 전략을 따라가기
	private int id;
	
	@Column(unique = true) // 유니크키
	private String username;
	
	private String password;
	private String email;
	
	// 무한참조가 일어나는 시점: 잭슨이 발동될 때 
	// 테이블 생성 시에는 관계 없고, SELECT할 때만 관계 있음 
	// 나는 연관관계의 주인이 아니야!(나는 F.K를 가진 아이가 아니야) -> DB의 필드를 만들지 않는다
	@JsonIgnoreProperties({"user", "content"}) // 무시하고 싶은(무한참조를 막고 싶은) 변수명 ( -> 무한참조 막기) 
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // POST 오브젝트의 user 변수를 넣어줌
	private List<Post> posts; // 오브젝트면 조인해서 무조건 들고 오고 컬렉션이면 안들고 옴 
}
