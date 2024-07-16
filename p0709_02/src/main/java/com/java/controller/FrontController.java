package com.java.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FrontController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/boardList")
	public String boardList(@RequestParam(defaultValue="1") int bno, Model model) { // request param으로 데이터 받음. null값이면 error
		System.out.println("bno : "+bno);
		model.addAttribute("bno", bno);				
		return "boardList";
	}
	
	@RequestMapping("/boardList2/{bno}")
	public String boardList2(@PathVariable int bno, Model model) { 
		System.out.println("bno : "+bno);
		model.addAttribute("bno", bno);				
		return "boardList2";
	}
	
	
	
	
	
	

	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("/doForm")
//	public String doForm(HttpServletRequest request) {
	public ModelAndView doForm(HttpServletRequest request) {
		System.out.println("id : "+request.getParameter("id"));
		System.out.println("pw : "+request.getParameter("pw"));
		System.out.println("name : "+request.getParameter("name"));
		System.out.println("phone : "+request.getParameter("phone"));
		System.out.println("gender : "+request.getParameter("gender"));
//		System.out.println("hobby : "+request.getParameterValues("hobby"));
		// hobby는 배열이므로 [Ljava.lang.String;@415b5715 로 출력됨. 아래와 같이 수정 필요
		String[] hobby = request.getParameterValues(("hobby"));
		System.out.println("hobby : "+Arrays.toString(hobby));
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("id", request.getParameter("id"));
		mv.addObject("pw", request.getParameter("pw"));
		mv.addObject("name", request.getParameter("name"));
		mv.addObject("phone", request.getParameter("phone"));
		mv.addObject("gender", request.getParameter("gender"));
		mv.addObject("hobby", Arrays.toString(hobby));		
		mv.setViewName("doForm");
		
//		return "doForm";
		return mv; // return mv는 modelandview이므로 선언부의 public string을 public modelandview로 수정 
	}
	
	
	
}
