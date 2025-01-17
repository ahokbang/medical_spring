package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override // 게시판 가져오기 - 리스트, 검색포함
	public Map<String,Object> selectList(int page, String category, String searchWord) {

		// ---------------------------- 하단 넘버링 ----------------------------
		int countPerPage = 10; 		// 1 페이지당 게시글 수
		int bottomPerNum = 10;		// 하단 넘버링 개수
		int countAll= boardDao.selectCount(category, searchWord); // 게시글 총 개수
		System.out.println("service selectList countAll : "+countAll);
		// 최대페이지    
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1; 
		int endPage = (startPage+bottomPerNum)-1;
//		System.out.println("service selectList maxPage : "+maxPage);
//		System.out.println("service selectList endPage : "+endPage);
		
		// 마지막넘버링이 최대페이지 숫자보다 크면 ==> : 글이 114개 있고, 게시글을 10개씩 보여주고 하단 넘버링이 10개 씩 보여질 때,최대페이지는 12이므로 마지막 넘버링을 20으로 하지 않고 12까지만 표시한다는 의미
		if (endPage>maxPage) endPage = maxPage;
//		System.out.println("service selectList endPage : "+endPage);
		
		// 게시글 페이지에서 가져올 게시글 번호
		int startRow = (page-1)*countPerPage+1; // 게시글에 있는 첫번째 글 번호
		int endRow = startRow+countPerPage-1; // 게시글에 있는 마지막 글 번호
		// ---------------------------- 하단 넘버링 ----------------------------
		
		//mybatis연결해서 list 가져오기 - 게시글, 검색 포함
		ArrayList<BoardDto> list = boardDao.selectList(startRow, endRow, category, searchWord );
		
		Map<String,Object> map = new HashMap<>(); // 다형성
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		map.put("page", page);
		map.put("category", category);
		map.put("searchWord", searchWord);
		
		return map; // 리턴해야 할 데이터 개수가 2개 이상 --> map 사용 
	}//selectList

	@Override // 게시글 1개 가져오기
	public Map<String, Object> selectOne(BoardDto bdto) {
		boardDao.updateBhit(bdto); //조회수 1증가
		BoardDto boardDto = boardDao.selectOne(bdto);
		BoardDto prevDto = boardDao.selectOnePrev(bdto);
		BoardDto nextDto = boardDao.selectOneNext(bdto);
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		return map;
	}

	@Override // 게시글 저장
	public void insertBoard(BoardDto bdto) {
		boardDao.insertBoard(bdto);
		
	}

	@Override // 게시글 삭제
	public void deleteBoard(BoardDto bdto) {
		boardDao.deleteBoard(bdto);
		
	}

	@Override // 게시글 수정페이지
	public BoardDto updateBoard(BoardDto bdto) {
		BoardDto boardDto = boardDao.selectOne(bdto);
		
		return boardDto;
	}

	@Override  //게시글 수정저장
	public void doUpdateBoard(BoardDto bdto) {
		boardDao.updateBoard(bdto);
		
	}

	@Override //답글페이지 저장
	public void insertReply(BoardDto bdto) {
		boardDao.updateBstep(bdto); // 부모보다 큰 step을 1씩 증가
		boardDao.insertReply(bdto);
		
	}
	
	

}
