package com.tis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/Management.do")
	public String list(HttpServletRequest request, Model model) {
//		String tempClickPage = request.getParameter("clickPage");
//		String search_select = request.getParameter("search_select");
//		String search_word = request.getParameter("search_word");
//		if (tempClickPage == null)
//			tempClickPage = "1";
//		int clickPage = Integer.parseInt(tempClickPage);
//		int totalPage = 20;
//
//		List<MemberDto> memberList = memberDao.getAllMemberList(1, 5, search_select, search_word);
//
//		String page = PageWriter.pageWrite(10, 5, 3, clickPage, "member/List.do");
//
//		model.addAttribute("memberList", memberList);
//		model.addAttribute("page", page);
//		model.addAttribute("totalPage", 10);

		return "member/management"; // jsp 페이지 설정
	}
	@PostMapping("/SearchProcess.do")
	public void searchProcess(MemberDto memberDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//리스트에서 검색하는 기능 구현해야 함
		//사실 원생 데이터 띄우는 것도 구현 안 함
		
	}
}
