package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

// 버전 1
@Service // IOC container에 등록, new를 하지 않으려고 IOC Container에 등록
@Qualifier(value="ver1")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public void SelectCount() {
		System.out.println("BoardServiceImpl 버전1이 실행됩니다.");		
	}

	@Override
	public ArrayList<BoardDto> selectList() {
		ArrayList<BoardDto> list = boardDao.selectList();
		System.out.println("service list : "+list.size());
		
		return list;
	}

	
}

// class 파일, interface(BoardService) 상속받음.