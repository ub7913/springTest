package com.yedam.app.board.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.board.BoardVO;

public interface BoardDAO {
	//전체조회
	public List<BoardVO> selectAll(BoardVO boardVO);
	
	//등록
	public void insert(BoardVO boardVO);
	
	//삭제
	public void deleteAll(BoardVO boardVO);
	
	//
	public List<Map<String,Object>> selectMap();
	
	public int selectCnt();
}
