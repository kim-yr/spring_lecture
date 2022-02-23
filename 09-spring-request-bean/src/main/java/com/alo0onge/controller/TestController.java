package com.alo0onge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alo0onge.model.DataDto;

@Controller
public class TestController {

	// 자동 주입, ServletAppContext에서 컴포넌트 스캔 작성 후 사용 가능
	@Autowired
	DataDto dataDto;

	@GetMapping("/Test01.do")
	public String test01() {
		dataDto.setData01("나는 자동 주입된 dataDto의 속성 중 하나인 data01입니다.");
		dataDto.setData02("나는 자동 주입된 dataDto의 속성 중 하나인 data02입니다.");
		return "forward:/Sub01.do";
	}

	@GetMapping("/Sub01.do")
	public String sub01(Model model) {
//		dataDto.setData01("나는 자동 주입된 dataDto의 속성 중 하나인 data01입니다.");
//		dataDto.setData02("나는 자동 주입된 dataDto의 속성 중 하나인 data02입니다.");
		model.addAttribute("dataDto", dataDto);
		return "sub01";
	}
}