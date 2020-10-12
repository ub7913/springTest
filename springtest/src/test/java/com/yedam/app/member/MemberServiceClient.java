package com.yedam.app.member;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
		                           "classpath:config/datasource-context.xml" })
public class MemberServiceClient {
	@Autowired MemberService service;
	
	@Test
	public void selectTest() {
		MemberVO memberVO = MemberVO.builder().id("ccc").build();
		memberVO = service.selectOne(memberVO);
		assertEquals("1111", memberVO.getPw());
	}
}
