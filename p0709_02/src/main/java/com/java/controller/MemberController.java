package com.java.controller;

import java.util.Arrays;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Member;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member") // 이렇게 써두면 @RequestMapping("/member/~~~")에서 /member를 지울 수 있어.
public class MemberController {
	
	@RequestMapping("/member")
	public String member() {		
		return "member/member";
	}
	
	@RequestMapping("/doMember")
//	public ModelAndView doMember(Member member,	HttpServletRequest request) {		
	public ModelAndView doMember(Member member) {		
		
		System.out.println("id : "+member.getId());
		System.out.println("name : "+member.getName());
		System.out.println("gender : "+member.getGender());
		
//		String[] hobbys = request.getParameterValues("hobbys");
//		member.setHobby(Arrays.toString(hobbys));
		System.out.println("hobbys : "+Arrays.toString(member.getHobbys()));
		member.setHobby(Arrays.toString(member.getHobbys()));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", member);
		mv.setViewName("member/doMember");
		
		return mv;
	}	
	
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	// requestParam을 사용하면 HttpServletRequest request 사용하지 않아도 돼.
	@RequestMapping("/doLogin")
	public ModelAndView doLogin(@RequestParam ("id") String id, 
			@RequestParam String pw, // 변수 이름이 똑같으면 생략 가능 
			@RequestParam(defaultValue="1") int pno, // defaultValue : 입력하지 않으면 값을 1로 보내줌.
			HttpServletRequest request) {

		
		ModelAndView mv = new ModelAndView();		
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		mv.addObject("pno", pno);		
		mv.setViewName("member/doLogin");
		
		return mv;
	}

	@RequestMapping("/data")
	public String data() {
		return "member/data";
	}
		
	// requestParam 형태로 데이터를 받아 doData로 전송하시오.
	// stuNo와 국어점수는 int로 받을 것.
	
	@RequestMapping("/doData")
	public ModelAndView doData(@RequestParam(defaultValue = "1") int stuNo,
			@RequestParam String name,
			@RequestParam(defaultValue = "0") int kor,
			String[] hobby) {
		
		ModelAndView mv = new ModelAndView();		
		mv.addObject("stuNo", stuNo);
		mv.addObject("name", name);
		mv.addObject("kor", kor);
		mv.addObject("hobby", Arrays.toString(hobby));		
		
		mv.setViewName("member/doData");
		return mv;
	}
	
	
	
}
