package com.yedam.app.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yedam.app.member.MemberVO;

public interface MemberDAO {
	//전체조회
	List<MemberVO> selectAll(MemberVO memberVO);
	//단건조회
	MemberVO selectOne(MemberVO memberVO);
	//삭제
	void delete(MemberVO memberVO);
	//수정
	void update(MemberVO memberVO);
	//등록
	int insert(MemberVO memberVO);

}