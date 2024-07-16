package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper // IOC container에 등록 
public interface BoardDao {
	
	// 게시판 전체 가져오기
	ArrayList<BoardDto> selectList();

	
}
