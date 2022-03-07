package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/List.do")
	public String list() {
		return "board/list";
	}

	@GetMapping("/Update.do")
	public String update() {
		return "board/update";
	}

	@GetMapping("/Delete.do")
	public String delete() {
		return "board/delete";
	}

	@GetMapping("/Reply_write.do")
	public String reply_write() {
		return "board/reply_write";
	}

	@GetMapping("/Write.do")
	public String write() {
		return "board/write";
	}

	@GetMapping("/Search_list.do")
	public String search_list() {
		return "board/search_list";
	}

	@GetMapping("/View.do")
	public String view() {
		return "board/view";
	}

}
