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
	@Autowired // 주입 받을 때마다 작성 해야 함
	MemberDto memberDto;
	@Autowired
	DataDto02 dataDto02;// 직접등록한 클래스 주입
	@Autowired
	BoardDto boardDto;

	@GetMapping("/Test01.do")
	public String test01() {
		dataDto.setData01("나는 자동 주입된 dataDto의 속성 중 하나인 data01입니다.");
		dataDto.setData02("나는 자동 주입된 dataDto의 속성 중 하나인 data02입니다.");
		
		dataDto02.setData03("나는 자동 주입된 dataDto02의 속성 중 하나인 data03입니다.");
		dataDto02.setData04("나는 자동 주입된 dataDto02의 속성 중 하나인 data04입니다.");
		
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
		boardDto.setNo(5);
		boardDto.setSubject("강동원 정말 잘생김");
		boardDto.setRegDate("2022-02-23");
		boardDto.setHit(1000);
		return "forward:/Sub03.do";
	}

	@GetMapping("/Sub03.do")
	public String sub03(Model model) {
		model.addAttribute("boardDto", boardDto);
		return "sub03";
	}
}