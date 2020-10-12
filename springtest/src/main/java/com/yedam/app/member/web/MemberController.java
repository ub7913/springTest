package com.yedam.app.member.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.member.MemberVO;
import com.yedam.app.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	//MemberDAO memberDAO; //getBean("memberDAO")
							  //new MemberDAO()해서 가져 오는 것과 같음
	
	@RequestMapping("/memberListAjax")
	@ResponseBody //json string으로 변환
	public List<MemberVO> memberListAjax() {
		return memberService.selectAll(null);
	}
	
	@RequestMapping("/memberSelectAjax")
	@ResponseBody
	public MemberVO memberSelectAjax(MemberVO memberVO) {
		return memberService.selectOne(memberVO);
	}
	
	
	
	@RequestMapping("/memberList")
	public String memberList(Model model, 
							 HttpServletRequest request, 
							 HttpSession session) {
//		model.addAttribute("name", "홍길동"); //request.setAttribute..과 같은것
		
		//회원조회
		model.addAttribute("list", memberService.selectAll(null));
		return "member/memberAll";
	}
	
	//등록페이지
	@RequestMapping(value = "/memberInsert", method=RequestMethod.GET)
	public String memberInsertForm() {
		return "member/memberInsert";
	}
	
	
	//등록처리
	@RequestMapping(value = "/memberInsert", method=RequestMethod.POST)
	public String memberInsert(MemberVO vo) {
		//MemberVO만들고
		//set 담고..
		System.out.println(vo);
		memberService.insert(vo);
		return "redirect:/memberList";//jsp를 찾아 가려면 /member/memberList, controller를 찾아 가려면 redirect:/memberList
	}
	
	@RequestMapping("/memberSelect")
	public String memberSelect(@RequestParam(name = "id", //name = "id" -> 가져올  getParameter의 이름을 의미함 (없으면 파라미터 없다고 에러뜸)
											 required = false, //필수는 id 아님? id는 안넘어와도 에러 안뜸
											 defaultValue = "user1"//if (mid!=null) {mid="user1"}을 의미함
											 ) String mid, 
							   Model model,
							   HttpServletRequest request) { // Model -> request와 같음, 그래서 jsp페이지로 값을 전달 할 수 있음
		//옛날방식
		//String mid = request.getParameter("id"); //위의 변수 @RequestParam String id와 같음
		MemberVO vo = new MemberVO();
		vo.setId(mid);
		
		model.addAttribute("member",memberService.selectOne(vo));
		return "member/memberSelect";
	}
	
	
	//경로명에 변수가 포함(pathVariable)
	//url에 '~?id=user1' 이 아닌 '~/user1'로 url이 되게끔
	@RequestMapping("/userSelectPath/{id}")
	public String userSelectPath(Model model, @PathVariable String id) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		
		model.addAttribute("member",memberService.selectOne(vo));
		return "member/memberSelect";
	}
	
	//파라미터를 map에
	@RequestMapping("/userSelectMap")
	public String userSelectMap(@RequestParam Map map) {
		System.out.println(map);
		return "";
	}
}
