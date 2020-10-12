package com.yedam.app.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.mapper.MemberDAO;
import com.yedam.app.member.service.MemberService;

@Service //컨테이너에 빈 등록
public class MemberServiceImpl implements MemberService {

	@Autowired MemberDAO memberDAO;
	//@Autowired BoardDAO boardDAO;
	//@Autowired NoticeDAO noticeDAO;
	
	@Override
	public List<MemberVO> selectAll(MemberVO memberVO) {
		return memberDAO.selectAll(memberVO);
	}

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		return memberDAO.selectOne(memberVO);
	}

	@Override
	public void delete(MemberVO memberVO) {
		//boardDAO.delete(memberVO);
		//noticeDAO.delete(memberVO);  //회원이 탈퇴할때 게시글 등을 다 삭제 하기 위해서 이렇게 쓸수 있다.
		memberDAO.delete(memberVO);
	}

	@Override
	public void update(MemberVO memberVO) {
		memberDAO.update(memberVO);
	}

	@Override
	public int insert(MemberVO memberVO) {
		return memberDAO.insert(memberVO);
	}

	@Override
	public int getMailynCnt() {
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getGenderCnt() {
		return null;
	}
	
	
}
