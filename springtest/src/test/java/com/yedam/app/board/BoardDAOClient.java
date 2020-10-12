package com.yedam.app.board;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/*-context.xml" })
public class BoardDAOClient {
	@Autowired BoardDAO boardDAO;
	
	@Test@Ignore
	public void cntTest() {
		System.out.println(
				boardDAO.selectCnt());
	}
	
	@Test@Ignore
	public void selectMapTest() {
		System.out.println(
				boardDAO.selectMap());
	}
	
	
	@Test
	public void selectAllTest() {
		BoardVO vo = BoardVO.builder()
//							.poster("bikash")
//							.boardSubject("goood")
							.first(5)
							.last(10)
							.build();
		List<BoardVO> list = boardDAO.selectAll(vo);
		for (BoardVO board : list) {
			System.out.println(board.getBoardNo() + " : " +
							   board.getBoardSubject() + " : " +
							   board.getPoster() + " : " +
							   board.getLastpost());
		}
		//System.out.println(boardDAO.selectAll(vo));
	}
	
	@Test@Ignore
	public void insertTest() {
		BoardVO vo = BoardVO.builder().poster("user1")
									  .boardSubject("myBatis select Key test")
									  .contents("test")
									  .views("20")
									  .filename("koala.jpg")
									  .build();
		boardDAO.insert(vo);
		System.out.println("글번호 : " + vo.getBoardNo());
		
	}
	
	@Test@Ignore
	public void deleteAllTest() {
		List<String> list = Arrays.asList(new String[] {"6","13","14"});
		BoardVO vo = BoardVO.builder()
				.nos(list)
				.build();
		boardDAO.deleteAll(vo);
	}
}
