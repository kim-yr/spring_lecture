package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	// /board/List.do
	// list.jsp(board/list.jsp), write, delete, update
	
	@RequestMapping(value="/List.do", method=RequestMethod.GET)
	public String list() {
		return "board/list";
	}
	@RequestMapping(value="/Write.do", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	@RequestMapping(value="/Delete.do", method=RequestMethod.GET)
	public String delete() {
		return "board/delete";
	}
	@RequestMapping(value="/Update.do", method=RequestMethod.GET)
	public String update() {
		System.out.println("update");
		return "board/update";
	}
}
