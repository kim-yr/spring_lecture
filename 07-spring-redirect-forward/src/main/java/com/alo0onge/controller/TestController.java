package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	// <a href="주소">링크</a>
	/**
	 * <script>
	 * location.href="주소";
	 * history.go(-1);
	 * history.back();
	 * </script>
	 */

	@GetMapping("/Test01.do")
	public String test01() {
		return "redirect:/Sub01.do";
	}

	@GetMapping("/Sub01.do")
	public String sub01() {
		return "sub01";
	}

	@GetMapping("/Test02.do")
	public String test02() {
		return "forward:/Sub02.do";
	}

	@GetMapping("/Sub02.do")
	public String sub02() {
		return "sub02";
	}

	@GetMapping("/Test03.do")
	public String test03() {
		return "redirect:/Sub03.do";
	}

	@GetMapping("/Sub03.do")
	public String sub03() {
		return "sub03";
	}

	@GetMapping("/Test04.do")
	public String test04() {
		return "forward:/Sub04.do";
	}

	@GetMapping("/Sub04.do")
	public String sub04() {
		return "sub04";
	}
}