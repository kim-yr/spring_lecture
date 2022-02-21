package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	//@PostMapping("/List.do") //이렇게 쓴다고 둘 다 적용되진 않음, board처럼 requestMapping하고 배열로 받아야 함
	@GetMapping("/List.do")
	public String list() {
		return "member/list";
	}
	@GetMapping("/Join.do")
	public String join() {
		return "member/join";
	}
	@GetMapping("/Withdraw.do")
	public String withdraw() {
		return "member/withdraw";
	}
	@GetMapping("/Mypage.do")
	public String mypage() {
		return "member/mypage";
	}
}
