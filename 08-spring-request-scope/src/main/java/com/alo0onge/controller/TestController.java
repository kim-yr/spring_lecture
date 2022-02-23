package com.alo0onge.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.alo0onge.model.DataDto;

@Controller
public class TestController {

	// <a href="주소">링크</a>
	/*
	 * <script>
	 * location.href="주소";
	 * history.go(-1);
	 * history.back();
	 * </script>
	 */

	@GetMapping("/Test01.do")
	public String test01(HttpServletRequest request) {
		request.setAttribute("data01", "나는 data01");
		return "forward:/Sub01.do";
	}

	@GetMapping("/Sub01.do")
	public String sub01(HttpServletRequest request) {
		String result = (String) request.getAttribute("data01");
		System.out.println(result);
		return "sub01";
	}
	
	@GetMapping("/Test02.do")
	public String test02(Model model) {
		model.addAttribute("data02", "나는 data02");
		return "forward:/Sub02.do";
	}

	@GetMapping("/Sub02.do")
	public String sub02(HttpServletRequest request) { //모델일 실어보내도 request로 받음
		String result = (String) request.getAttribute("data01");
		System.out.println(result);
		return "sub02";
	}

	@GetMapping("/Test03.do")
	public ModelAndView test03(ModelAndView mav) {
		mav.addObject("data03", "나는 data03");
		mav.setViewName("forward:/Sub03.do");//데이터를 넘길 주소
		return mav;
	}

	@GetMapping("/Sub03.do")
	public String sub03(HttpServletRequest request) { //모델일 실어보내도 request로 받음
		String result = (String) request.getAttribute("data03");
		System.out.println(result);
		return "sub03";
	}
	
	@GetMapping("/Test04.do")
	public String test04(Model model) {
		DataDto dataDto = new DataDto();
		dataDto.setData01("dataDto data01");
		dataDto.setData02("dataDto data02");
		model.addAttribute("dataDto", dataDto);
		return "forward:/Sub04.do";
	}

	@GetMapping("/Sub04.do")
	public String sub04(HttpServletRequest request) {
		DataDto dataDto = (DataDto) request.getAttribute("dataDto");
		System.out.println(dataDto.toString());
		return "sub04";
	}

	@GetMapping("/Test05.do")
	public String test05(@ModelAttribute("dataDto") DataDto dataDto) {
		dataDto.setData01("modelAttrubute dataDto data01");
		dataDto.setData01("modelAttrubute dataDto data02");
		return "forward:/Sub05.do";
	}

	@GetMapping("/Sub05.do")
	public String sub05(HttpServletRequest request) {
//		public String sub05(DataDto dataDto) {
		DataDto dataDto = (DataDto) request.getAttribute("dataDto");
		System.out.println(dataDto.toString());
		return "sub05";
	}
}