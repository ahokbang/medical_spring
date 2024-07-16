package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.EmpDto;

@Mapper
public interface EmpDao {
	
	// 사원테이블 모두 가져오기
	ArrayList<EmpDto> selectAll(); 
	
}
