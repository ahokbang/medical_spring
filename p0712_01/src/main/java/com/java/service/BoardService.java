package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	void SelectCount(); // {} (실행문) 없음.

	// 게시판 전체 가져오기
	ArrayList<BoardDto> selectList();

}

// interface 파일
