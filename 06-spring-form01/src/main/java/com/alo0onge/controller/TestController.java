package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alo0onge.model.MemberDto;

@Controller
public class TestController {

	@GetMapping("/Test01.do")
	public String test01(@ModelAttribute MemberDto memberDto) {
		memberDto.setNo(17);
		memberDto.setId("alo0onge");
		memberDto.setName("기매렁");
		memberDto.setPassword("1234");
		return "test01";
	}

	@GetMapping("/Test02.do")
	public String test02(MemberDto memberDto) {
		memberDto.setNo(25);
		memberDto.setId("tuna");
		memberDto.setName("강동원");
		memberDto.setPassword("8282");
		return "test02";
	}

	@GetMapping("/Test03.do")
	public String test03(@ModelAttribute("myMember") MemberDto memberDto) {
		memberDto.setNo(25);
		memberDto.setId("tuna");
		memberDto.setName("강동원");
		memberDto.setPassword("8282");
		return "test03";
	}
	//모델에 데이터 싣는 방식을 많이 선호 함
	@GetMapping("/Test04.do")
	public String test04(Model model) {
		MemberDto memberDto = new MemberDto();
		memberDto.setNo(30);
		memberDto.setId("captain marvel");
		memberDto.setName("브리라순자");
		memberDto.setPassword("1111");
		model.addAttribute("memberDto", memberDto);
		return "test04";
	}
}
