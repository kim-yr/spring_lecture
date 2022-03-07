package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
	@RequestMapping("/List.do")
	public String list() {
		return "index";
	}
}
