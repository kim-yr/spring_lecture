package com.alo0onge.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@GetMapping("/Test01.do")
	public String test01() {
		return "test01";
	}
	@GetMapping("/Test02.do")
	public String test02(HttpServletRequest request) {
		request.setAttribute("msg", "hello Spring");
		return "test02";
	}
	
	@GetMapping("/Test03.do")
	public String test03(Model model) {
		//request에 데이터 담겨있음
		//data를 jsp에 넘겨야 한다면 ==> Model / HttpServletRequest 사용하면 된다
		model.addAttribute("msg", "hello Spring");
		model.addAttribute("data", 1004);
		return "test03";
	}
	@GetMapping("/Test04.do")
	public ModelAndView test04(ModelAndView mav) {
		//request에 데이터 담겨있음
		mav.addObject("msg", "hello Spring");
		mav.addObject("data", 1005);
		mav.setViewName("test04");
		return mav;
	}
}
