package com.yedam.app.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.member.MemberVO;

//@Repository
public class MemberMyBatisDAO implements MemberDAO {
	
	@Autowired SqlSessionTemplate sqlsession;

	@Override
	public List<MemberVO> selectAll(MemberVO memberVO) {
		System.out.println("mybatis selectall");
		return sqlsession.selectList("memberDAO.selectAll");//member_mapper에 있는 namespace와 id를 변수로 넣으면 됨
	}

	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		return sqlsession.selectOne("memberDAO.selectOne", memberVO);
	}

	@Override
	public void delete(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	
}
