package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder                // 부분생성자
@AllArgsConstructor     // 전체생성자
@NoArgsConstructor      // 기본생성자
@Data                   // getter, setter 만들어주는 annotation


public class Member {

	private String id;
	private String pw;
	private String name;
	private String phone;
	
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public Member(String id, String pw, String name) {
			this.id = id;
			this.pw = pw;	
			this.name = name;
	}
	public Member(String id) {
		this.id = id;
	}
	

		
}
