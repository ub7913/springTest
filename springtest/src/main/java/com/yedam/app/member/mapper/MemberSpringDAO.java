package com.yedam.app.member.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yedam.app.member.MemberVO;

//@Component
public class MemberSpringDAO implements MemberDAO {

	@Autowired JdbcTemplate template;
	
	final static String INSERT_MEMBER = "INSERT INTO MEMBER (ID, PW, GENDER, JOB, REASON, MAILYN, HOBBY, REGDATE) "
			+ "VALUES (?,?,?,?,?,?,?,SYSDATE)";
	final static String DELETE_MEMBER = "DELETE MEMBER WHERE ID = ?";
	final static String SELECT_MEMBER = "SELECT * FROM MEMBER WHERE ID = ?";
	final static String SELECT_ALL_MEMBER = "SELECT * FROM MEMBER";
	
	@Override
	public int insert(MemberVO memberVO) {
		Object[] args = {memberVO.getId(), memberVO.getPw(), memberVO.getGender(), memberVO.getJob(),
						 memberVO.getReason(), memberVO.getMailyn(), memberVO.getHobby()};
		//template.update(INSERT_MEMBER, args);
		return template.update(INSERT_MEMBER, args);
	}
		
	@Override
	public void delete(MemberVO memberVO) {
		String member_id = memberVO.getId();
		template.update(DELETE_MEMBER, member_id);//insert, update, delete를 할 수 있게 해주는게 update()이다
	}
	
	
	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		Object[] args = {memberVO.getId()};
		return template.queryForObject(SELECT_MEMBER, args, new MemberRowMapper());
	}
	
	
	@Override
	public ArrayList<MemberVO> selectAll(MemberVO memberVO) {
		return (ArrayList<MemberVO>) template.query(SELECT_ALL_MEMBER, new MemberRowMapper());
	}



	@Override
	public void update(MemberVO memberVO) {
		
	}


	@Override
	public int getMailynCnt() {
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getGenderCnt() {
		return null;
	}
	
	class MemberRowMapper implements RowMapper<MemberVO> { //MemberSpringDAO에서 내부 클래스를 만든것

		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO resultVO = new MemberVO();
			resultVO.setId(rs.getString("ID"));
			resultVO.setPw(rs.getString("pw"));
			resultVO.setGender(rs.getString("GENDER"));
			resultVO.setJob(rs.getString("JOB"));
			resultVO.setReason(rs.getString("REASON"));
			resultVO.setMailyn(rs.getString("MAILYN"));
			resultVO.setHobby(rs.getString("HOBBY"));
			resultVO.setRegdate(rs.getString("REGDATE"));
			return resultVO;
		}
		
	}
	
}
