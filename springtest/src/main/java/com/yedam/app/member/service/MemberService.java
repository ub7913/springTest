package com.yedam.app.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yedam.app.member.MemberVO;

public interface MemberService {

	List<MemberVO> selectAll(MemberVO memberVO);

	MemberVO selectOne(MemberVO memberVO);

	void delete(MemberVO memberVO);

	void update(MemberVO memberVO);

	int insert(MemberVO memberVO);

	//메일수신회원수 : select count(id) from member where mailyn='y';
	int getMailynCnt();

	//성별인원수:select gender, count(id) cnt from member group by gender;
	List<HashMap<String, Object>> getGenderCnt();

}