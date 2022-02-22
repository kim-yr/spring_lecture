package com.alo0onge.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alo0onge.model.BoardDto;
import com.alo0onge.model.DataDto;
import com.alo0onge.model.MemberDto;

@Controller
public class TestController {
	@GetMapping("/ParameterObject01.do")
	public String parameterObject01(@RequestParam Map<String, String> map, @RequestParam List<String> data03) {
		String data01 = map.get("data01");
		String data02 = map.get("data02");
		String mapData03 = map.get("data03");
		System.out.println("data01==" + data01);
		System.out.println("data02==" + data02);
		System.out.println("data03==" + mapData03);
		for (String str : data03) {
			System.out.println(str);
		}
		return null;
	}

	@GetMapping("/ParameterObject02.do")
//	public String parameterObject02(@ModelAttribute DataDto dataDto) {
	public String parameterObject02(DataDto dataDto) {// 속성 값만 정확히 매핑되면 통째로 받을 수 있음
		int data01 = dataDto.getData01();
		int data02 = dataDto.getData02();
		System.out.println("data01===" + data01);
		System.out.println("data02===" + data02);
		for (int num : dataDto.getData03()) {
			System.out.println(num);
		}
		return null;
	}

	@GetMapping("/ParameterObject03.do")
	public String parameterObject03(@ModelAttribute MemberDto memberDto) {
		int no = memberDto.getNo();
		String id = memberDto.getId();
		String name = memberDto.getName();
		String password = memberDto.getPassword();
		System.out.println("no===" + no);
		System.out.println("id===" + id);
		System.out.println("name===" + name);
		System.out.println("password===" + password);
		System.out.println("no+10===" + (no + 10));
		return null;
	}
	@PostMapping("/ParameterObject04.do")
	public String parameterObject04(@ModelAttribute BoardDto boardDto) {
		int no = boardDto.getNo();
		String subject = boardDto.getSubject();
		String password = boardDto.getPassword();
		String regdate = boardDto.getRegdate();
		int hit = boardDto.getHit();
		System.out.println("no==="+no);
		System.out.println("subject==="+subject);
		System.out.println("password==="+password);
		System.out.println("regdate==="+regdate);
		System.out.println("hit==="+hit);
		return null;
	}
}
