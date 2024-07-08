package com.java.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FrontController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/member") // 회원가입 폼
	public String member() {
		return "member";
	}
		
	@RequestMapping("/doMember") // 회원가입 저장
	ModelAndView doMember(HttpServletRequest request) {
		String[] hobby = request.getParameterValues("hobby");
		String hobbies =""; // game, golf, run, swim, book
		for(int i=0; i<hobby.length; i++) {
			if(i==0) hobbies += ""+hobby[i];
			else hobbies += ","+hobby[i];					
		}
				
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("id", request.getParameter("id"));
		mv.addObject("pw", request.getParameter("pw"));
		mv.addObject("name", request.getParameter("name"));
		mv.addObject("phone", request.getParameter("phone"));
		mv.addObject("gender", request.getParameter("gender"));
//		mv.addObject("hobby", Arrays.toString(hobby));
		mv.addObject("hobby", hobbies);
		
		mv.setViewName("/doMember"); // 파일이름
		return mv;
	}
	
	@RequestMapping("/memUpdate") // 회원정보수정
	public ModelAndView memUpdate(HttpServletRequest request) {
		String[] hobby = request.getParameterValues("hobby");
		String hobbies =""; // game, golf, run, swim, book
		for(int i=0; i<hobby.length; i++) {
			if(i==0) hobbies += ""+hobby[i];
			else hobbies += ","+hobby[i];					
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", request.getParameter("id"));
		mv.addObject("pw", request.getParameter("pw"));
		mv.addObject("name", request.getParameter("name"));
		mv.addObject("phone", request.getParameter("phone"));
		mv.addObject("gender", request.getParameter("gender"));
		mv.addObject("hobby", hobbies);
		
		return mv;
	}
	
	
	
	
	
}
