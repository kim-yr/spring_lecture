package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
	//메소드 이름보다 매핑되는 주소가 중요!	
		System.out.println("home controller 호출");
		return "index";
	}
	@RequestMapping(value="/aaa", method=RequestMethod.GET)
	public String aaa() {
	//메소드 이름보다 매핑되는 주소가 중요!	
		System.out.println("home controller 호출");
		return "index";
	}
}
