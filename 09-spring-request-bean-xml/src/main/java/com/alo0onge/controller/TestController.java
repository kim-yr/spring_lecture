package com.alo0onge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alo0onge.model.BoardDto;
import com.alo0onge.model.DataDto;
import com.alo0onge.model.DataDto02;
import com.alo0onge.model.MemberDto;

@Controller
public class TestController {

	// 자동 주입, ServletAppContext에서 컴포넌트 스캔 작성+해당 클래스에 어노테이션(@Component) 작성 후 사용 가능
//	@Autowired(required=false) //해당 클래스에 @Component 안쓸거라면 이렇게 작성
	@Autowired
	DataDto dataDto;
	@Autowired //주입 받을 때마다 작성 해야 함
	MemberDto memberDto;
	@Autowired
	DataDto02 dataDto02;
	@Autowired
	BoardDto boardDto;

	@GetMapping("/Test01.do")
	public String test01() {
		dataDto.setData01("나는 자동 주입된 dataDto의 속성 중 하나인 data01입니다.");
		dataDto.setData02("나는 자동 주입된 dataDto의 속성 중 하나인 data02입니다.");
		
		dataDto02.setData0201("나는 직접 생성된 dataDto02의 속성 중 하나인 data0201");
		dataDto02.setData0202("나는 직접 생성된 dataDto02의 속성 중 하나인 data0202");
		return "forward:/Sub01.do";
	}

	@GetMapping("/Sub01.do")
	public String sub01(Model model) {
		model.addAttribute("dataDto", dataDto);
		model.addAttribute("dataDto02", dataDto02);
		return "sub01";
	}
	
	@GetMapping("/Test02.do")
	public String test02() {
		memberDto.setNo(1);
		memberDto.setName("강동원");
		memberDto.setAge(25);
		return "forward:/Sub02.do";
	}
	@GetMapping("/Sub02.do")
	public String sub02(Model model) {
		model.addAttribute("memberDto", memberDto);
		return "sub02";
	}
	@GetMapping("/Test03.do")
	public String test03() {
		boardDto.setNo(17);
		boardDto.setSubject("위ㅡ는 ㅙ==왜 이ㅗ졸려");
		boardDto.setRegDate("20220223");
		boardDto.setHit(30);
		return "forward:/Sub03.do";
	}
	@GetMapping("/Sub03.do")
	public String sub03(Model model) {
		model.addAttribute("boardDto", boardDto);
		return "sub03";
	}
}