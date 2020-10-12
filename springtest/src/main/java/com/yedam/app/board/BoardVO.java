package com.yedam.app.board;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor //인수가 없는 생성자 
@AllArgsConstructor //모든 인수가 있는 생성자  //둘다 있어야 생성자 모두를 사용 가능
public class BoardVO {
	private String boardNo;
	private String poster;
	private String boardSubject;
	private String contents;
	private String lastpost;
	private String views;
	private String filename;
	private String sortCol; 		//정렬순서
	private List<String> nos;		//일반 String[]가능
	private int first;
	private int last;
}
