package com.java.service;

import java.util.ArrayList;

import com.java.dto.DepDto;

public interface DepService {

	// 부서테이블 모두 가져오기
	ArrayList<DepDto> selectAll();

}
