package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/member/List.do")
	public String list() {
		return "member/list";
	}

	@GetMapping("/member/Login.do")
	public String login() {
		return "member/login";
	}

	@GetMapping("/member/Logout.do")
	public String logout() {
		return "member/logout";
	}

	@GetMapping("/member/Join.do")
	public String join() {
		return "member/join";
	}

	@GetMapping("/member/Info.do")
	public String info() {
		return "member/info";
	}

}
