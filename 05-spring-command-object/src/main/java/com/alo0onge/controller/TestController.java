package com.alo0onge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alo0onge.model.BoardDto;
import com.alo0onge.model.DataDto;
import com.alo0onge.model.MemberDto;

@Controller
public class TestController {
	@PostMapping("/Test01.do")
//	public String test01(@ModelAttribute DataDto dataDto) {
	public String test01(DataDto data) { // test01.jsp에서 함수 이름이 아니라 자료형(데이터타입)의 첫글자 소문자 형을 받음!!
		System.out.println("data01===" + data.getData01());
		System.out.println("data01===" + data.getData02());
		return "test01";
	}

	@PostMapping("/MemberTest.do")
	public String memberTest(MemberDto data) {
		System.out.println("no===" + data.getNo());
		System.out.println("id===" + data.getId());
		System.out.println("name===" + data.getName());
		System.out.println("password===" + data.getPassword());
		return "member";
	}

	@PostMapping("/MemberTest02.do")
	public String memberTest02(@ModelAttribute("testDto") MemberDto memberDto) {
		System.out.println("no===" + memberDto.getNo());
		System.out.println("id===" + memberDto.getId());
		System.out.println("name===" + memberDto.getName());
		System.out.println("password===" + memberDto.getPassword());
		return "member02";
	}
	@PostMapping("BoardTest.do")
	public String boardTest(@ModelAttribute BoardDto boardDto) {
		System.out.println("no==="+boardDto.getNo());
		System.out.println("subject==="+boardDto.getSubject());
		System.out.println("password==="+boardDto.getPassword());
		System.out.println("regdate==="+boardDto.getRegdate());
		System.out.println("hit==="+boardDto.getHit());
		return "board";
	}
}
