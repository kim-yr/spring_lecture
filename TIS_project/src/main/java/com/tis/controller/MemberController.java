package com.tis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tis.model.MemberDto;
import com.tis.model.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberDto memberDto;
	@Autowired
	MemberService memberDao;

	@GetMapping("/List.do")
	public String list(HttpServletRequest request, Model model) {
		String search_position = request.getParameter("search_position");
		String search_subject = request.getParameter("search_subject");
		String search_name = request.getParameter("search_name");
		List<MemberDto> memberList = memberDao.getAllMemberList(search_position, search_subject, search_name);
	
		System.out.println(search_position+"/"+search_subject+"/"+search_name);
		for (MemberDto md : memberList) {
			System.out.println(md.toString());
		}
		model.addAttribute("memberList", memberList);
//		model.addAttribute("page", page);
//		model.addAttribute("totalPage", 10);
		return "member/list"; // jsp 페이지 설정
	}
}
