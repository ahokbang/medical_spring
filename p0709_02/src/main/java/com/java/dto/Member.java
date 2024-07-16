package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 전체 생성자
@NoArgsConstructor // 생성자
@Data // getter, setter
public class Member {

	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;
	private String[] hobbys;	
		
}
