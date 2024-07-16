package com.java.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Students;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StuController {
	
	@RequestMapping("/students/students")
	public String students() {
		return "students/students";
	}
		
//	doStudents.jsp 데이터를 보여지도록 하시오.	
	@RequestMapping("/students/doStudents")
	public ModelAndView doStudents(Students stu) { // <- students에는 기본생성자의 값 5개만 넣어줌. 즉 total, avg, rank, gender, hobby는 없음. 1. 객체로 받는 방법
//  public ModelAndView doStudents(String stuNo, String name, int kor, .. ) // 이렇게 할 수 있지만, 이 값을 작성하지 않으면 error 발생, 2. 변수로 받는 방법
//  public ModelAndView doStudents(HttpServletRequest request) 3. request로 받는 방법 
		// Students stu = new Students(stuNo, name, kor, eng, math); // 이거 쓰면 stu.Total, setAvg, stu.setHobby 안 적어도 돼. 
		
		// System.out.println("total : "+students.getTotal()); // 기본생성자에는 없는 값으로 아래와 같이 작성해주어야 함.
		stu.setTotal(stu.getKor()+stu.getEng()+stu.getMath());
		// System.out.println("avg : "+students.getAvg()); // 기본생성자에는 없는 값으로 아래와 같이 작성해주어야 함.
		stu.setAvg(stu.getTotal()/3.0);
//		System.out.println("rank : "+s.getRank());
//		System.out.println("gender : "+s.getGender());
//		System.out.println("hobbys : "+Arrays.toString(students.)
		stu.setHobby(Arrays.toString(stu.getHobbys()));

//		Students s = new Students(stu.getStuNo(), stu.getName(), stu.getKor(), stu.getEng(), stu.getMath());
		
		System.out.println("stuNo : "+stu.getStuNo());
		System.out.println("name : "+stu.getName());
		System.out.println("kor : "+stu.getKor());
		System.out.println("eng : "+stu.getEng());
		System.out.println("math : "+stu.getMath());
		System.out.println("avg : "+stu.getAvg());
		System.out.println("gender : "+stu.getGender());
		System.out.println("hobbys : "+Arrays.toString(stu.getHobbys()));
		
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("stu", stu); // 앞의 "stu"를 받는 것임. 뒤의 stu가 아님
		mv.setViewName("students/doStudents"); 		
		return mv;
	}
	
	@RequestMapping("/students/stuUpdate")
	public ModelAndView stuUpdate(Students stu) {
		ModelAndView mv = new ModelAndView();		
		mv.addObject("stu",stu);	
		// System.out.println("stu gender : "+stu.getGender());
		mv.setViewName("students/stuUpdate");		
		return mv;
	}
	
	
	
}
