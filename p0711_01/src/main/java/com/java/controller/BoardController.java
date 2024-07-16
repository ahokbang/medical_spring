package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.BoardDto;
import com.java.service.BoardService;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping("/board") // 이거하면 url에 다 /board 안써줘도 돼.

public class BoardController {

//	BoardServiceImpl boardServiceImpl = new BoardServiceImpl(); // 객체선언
//	BoardService boardService = new BoardServiceImpl(); // 다형성

// 위에 처럼 객체선언-다형성 해도 되지만, 유지보수를 위해서 @autowired 사용
	@Autowired
	BoardService boardService; // IOC 컨테이너에서 주입받음.

	@RequestMapping("/board/list")
	public ModelAndView list(BoardDto bdto) {

		ArrayList<BoardDto> list = boardService.selectList();

		// mv
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("board/list");

		return mv;
	} // list

	@RequestMapping("/board/view") // 뷰페이지
//	public ModelAndView view(@RequestParam(defaultValue = "1") int bno) {		
	public ModelAndView view(BoardDto bdto) { // 위에가 너무 길면 이렇게 받아도 돼.

		// 1개, board가 1개만 넘어와. --> dto로 받아. 여러개면 arrayList
		BoardDto boardDto = boardService.selectOne(bdto);

		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto", boardDto);
		mv.setViewName("board/view");
		return mv;
	} // view

	@GetMapping("/board/write") // 글쓰기 화면
	public String write() {
		return "board/write";
	} // write

	@PostMapping("/board/write") // 글쓰기 저장
	public String write(BoardDto bdto, @RequestPart MultipartFile files) {
		// id, btitle, bcontent가 bdto에 있어 + files
//		System.out.println("controller id : " + bdto.getId());
//		System.out.println("controller btitle : " + bdto.getBtitle());
//		System.out.println("controller bcontent : " + bdto.getBcontent());
		System.out.println("controller files : " + files.getOriginalFilename());
		String uFile = "";
		
		// 파일이 존재할 시 
		if(!files.isEmpty()) {
			// 파일 네이밍1 - jsp
			long time = System.currentTimeMillis();
			System.out.println("time : " + time); // 현재시간 번호 부여해서 밀리세컨드로 출력
			
			// 파일 네이밍2 - uuid 방식
	//		UUID uuid = UUID.randomUUID(); // random으로 코드값(숫자) 만들어서 return
	//		System.out.println("uuid : "+uuid);
			
			uFile = String.format("%d_%s", time,files.getOriginalFilename());
			String saveUrl="c:/upload/"; 
			File f = new File(saveUrl+uFile); 
			try {
				files.transferTo(f); 
				} catch (Exception e) {e.printStackTrace();} // 파일업로드			
		} // if
				
		// 변경된 파일이름 저장
		bdto.setBfile(uFile);			 
		
		boardService.insertBoard(bdto);
		return "redirect:/board/list";
	}

	@RequestMapping("/board/delete") // 삭제
	public String delete(BoardDto bdto) {
		System.out.println("controller delete bno : " + bdto.getBno());
		boardService.deleteBoard(bdto);
		return "redirect:/board/list";
	} // delete

	@RequestMapping("/board/update") // 게시글 수정페이지
	public ModelAndView update(BoardDto bdto) {
		BoardDto boardDto = boardService.updateBoard(bdto);

		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto", boardDto);
		mv.setViewName("/board/modify");
		return mv;
	}

	@RequestMapping("/board/doUpdate") // 게시글 수정저장
	public String doUpdate(BoardDto bdto, @RequestPart MultipartFile files) {
		// 수정페이지 저장 : bno, id, btitle, bcontent가 들어와 + files
		
//		System.out.println("controller bno : " + bdto.getBno());
//		System.out.println("controller btitle : " + bdto.getBtitle());

		String uFile = "";
		
		// 파일이 존재할 시 
		if(!files.isEmpty()) {
			// 파일 네이밍1 - jsp
			long time = System.currentTimeMillis();
			System.out.println("time : " + time); // 현재시간 번호 부여해서 밀리세컨드로 출력
			
			uFile = String.format("%d_%s", time,files.getOriginalFilename());
			String saveUrl="c:/upload/"; 
			File f = new File(saveUrl+uFile); 
			try {
				files.transferTo(f); 
				} catch (Exception e) {e.printStackTrace();} // 파일업로드			

			// 게시글 수정 시 파일이 첨부된 상태에서 글만 수정했을 경우 업로드된 파일이 사라지는 것을 방지하기 위해 if 안에 넣어줌.
			// 변경된 파일이름 저장
			bdto.setBfile(uFile);
			
		} // if				
		
		boardService.doUpdateBoard(bdto);

		return "redirect:/board/list";
	}

	@RequestMapping("/board/reply") // 답글 페이지
	public ModelAndView reply(BoardDto bdto) {
		BoardDto boardDto = boardService.selectOne(bdto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto", boardDto);
		mv.setViewName("board/reply");
		return mv;
	}

	@RequestMapping("/board/doReply") // 답글페이지 저장
	public String doReply(BoardDto bdto, @RequestPart MultipartFile files) {
		String uFile = "";		
		// 파일이 존재할 시 
		if(!files.isEmpty()) {
			// 파일 네이밍1 - jsp
			long time = System.currentTimeMillis();
			System.out.println("time : " + time); // 현재시간 번호 부여해서 밀리세컨드로 출력
				
			uFile = String.format("%d_%s", time,files.getOriginalFilename());
			String saveUrl="c:/upload/"; 
			File f = new File(saveUrl+uFile); 
			try {
				files.transferTo(f); 
				} catch (Exception e) {e.printStackTrace();} // 파일업로드			
		} // if				
		// 변경된 파일이름 저장
		bdto.setBfile(uFile);				
		
		boardService.insertReply(bdto);
		return "redirect:/board/list";
	}

}
