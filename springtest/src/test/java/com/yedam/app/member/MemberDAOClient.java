package com.yedam.app.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.mapper.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
		                           "classpath:config/datasource-context.xml" })//context파일 두개를 읽어 오게 할 수 있음
public class MemberDAOClient {

	@Autowired MemberDAO memberDAO;
	
	@Test@Ignore
	public void selectTest() {
		MemberVO memberVO = MemberVO.builder().id("ccc").build();
		memberVO = memberDAO.selectOne(memberVO);
		assertEquals("1111", memberVO.getPw());//패스워드가 일치하는지 조회
	}
	
	@Test
	//@Ignore // 한 클래스 안에서 test어노테이션이 있으면 다 실행 되는데, ignore이 있으면 이 test는 무시 되고 실행됨
	public void insertTest() {
		MemberVO memberVO = MemberVO.builder().id("pppp")
											  .pw("333")
											  .hobby("game")
											  .reason("...").build();
		memberDAO.insert(memberVO);
		//memberVO = dao.selectOne(memberVO);
		//assertNotNull(memberVO);//notnull이 아닌지 조회 후 실행??
	}
	
	@Test@Ignore
	public void deleteTest() {
		MemberVO memberVO = MemberVO.builder().id("vvvv").build();
		memberDAO.delete(memberVO);	
	}
	
	@Test@Ignore
	public void selectAllTest() {
		memberDAO.selectAll(null);
	}
}
