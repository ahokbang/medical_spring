package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/board")
public class BoardController {
//	BoardServiceImpl boardServiceImpl = new BoardServiceImpl();
//	BoardServiceImplVer2 boardServiceImplVer2 = new BoardServiceImplVer2();
	
	// 다형성 
//	BoardService boardService = new BoardServiceImpl();
//	BoardService boardService = new BoardServiceImplVer2();
	
	@Autowired
	@Qualifier("ver1") // service가 2개 이상일 때 Qualifier를 통해 우선수위 지정 필요
	BoardService boardService;
	
	@RequestMapping("/list")
	public ModelAndView list() {		
//		boardService.SelectCount();

// 		게시판 전체 가져오기
		ArrayList<BoardDto> list = boardService.selectList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@RequestMapping("/write")
	public String write() {
		
		return "board/write";
	}
}
