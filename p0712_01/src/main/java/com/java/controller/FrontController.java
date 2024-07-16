package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // IOC container에 등록
public class FrontController {
	
	@RequestMapping("/index")
	public String index() {		
		return "index";
	}
}
