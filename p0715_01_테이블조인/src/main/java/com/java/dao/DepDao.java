package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.DepDto;

@Mapper
public interface DepDao {
	
	// 부서테이블 모두 가져오기
	ArrayList<DepDto> selectAll();
	
}
