package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller annotation 달면 Spring Container에 담김
//Spring에는 많은 annotation이 존재, 다외워야 하는 건 아니다

@Controller
public class HomeContrdoller {
    //Spring이 로딩하면서 annotation을 인식시키는 파일이 controller임을 알게 함
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		//business logic 여기에 들어감
		System.out.println("index");
		return "index"; //return되는 home/WEB-INF/views/home .jsp
	}
	
	@GetMapping("/Sub.do")
	public String sub() {
		System.out.println("sub");
		return "rub";
	}
}

