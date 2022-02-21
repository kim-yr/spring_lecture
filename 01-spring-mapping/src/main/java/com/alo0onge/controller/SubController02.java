package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sub") //중복되는 주소 위로 빼서 적어줄 수 있음
public class SubController02 {
	@RequestMapping(value="/Sub03.do", method=RequestMethod.GET)
	public String sub01() {
		System.out.println("sub03 호출");
		return "sub02/sub03"; //jsp호출 부분은 위로 빼는 거 아님!
	}
	@RequestMapping(value="/Sub04.do", method=RequestMethod.GET)
	public String sub02() {
		System.out.println("sub04 호출");
		return "sub02/sub04";
	}
}
