package com.yedam.app.member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//셋,겟을 만들어주는 어노테이션
//@Builder//생성자 갯수에 따라 다 만들어 주는 어노테이션
//@NoArgsConstructor
public class MemberVO {
	private String id;
	private String pw;
	private String gender;
	private String job;
	private String reason;
	private String mailyn;
	private String hobby;
	private String regdate;
	
	
}
