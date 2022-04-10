package com.tis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TISpjh.util.ScriptWriter;
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

<<<<<<< HEAD
		System.out.println(search_position + "/" + search_subject + "/" + search_name);
=======
		
>>>>>>> 1d47a5ac238cedf094f54b7188ee357784fd36ac
		for (MemberDto md : memberList) {
			System.out.println(md.toString());
		}
		model.addAttribute("memberList", memberList);
//		model.addAttribute("page", page);
//		model.addAttribute("totalPage", 10);
		return "member/list"; // jsp 페이지 설정
	}

	@GetMapping("/Create.do")
	public String join(HttpServletRequest request) {
		return "member/create";
	}

	@PostMapping("/CreateProcess.do")
	public void joinProcess(MemberDto memberDto, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		memberDto.setTell(memberDto.getTellFirst() + "-" + memberDto.getTellMiddle() + "-" + memberDto.getTellLast());
		int result = memberDao.insertMember(memberDto);
		if (result > 0) {
			ScriptWriter.alertAndNext(response, "원생이 등록되었습니다.", "../member/List.do");
		} else {
			ScriptWriter.alertAndBack(response, "시스템 오류입니다. 다시 시도해 주세요.");
		}
	}

	@GetMapping("/Info.do")
	public String information(String code, Model model) {
		memberDto = memberDao.getSelectOne(code);

		String temp = memberDto.getCode();
		memberDto.setPosition(temp.substring(0, 1));

		String tell = memberDto.getTell();
		String[] tArr = tell.split("-");
		memberDto.setTellFirst(tArr[0]);
		memberDto.setTellMiddle(tArr[1]);
		memberDto.setTellLast(tArr[2]);

		model.addAttribute("memberDto", memberDto);
		return "member/info";
	}

	@GetMapping("/InfoUpdate.do")
	public String update(String code, Model model) {
		memberDto = memberDao.getSelectOne(code);
		
		String temp = memberDto.getCode();
		memberDto.setPosition(temp.substring(0, 1));
		
		String tell = memberDto.getTell();
		String[] tArr = tell.split("-");
		memberDto.setTellFirst(tArr[0]);
		memberDto.setTellMiddle(tArr[1]);
		memberDto.setTellLast(tArr[2]);
		
		model.addAttribute("memberDto", memberDto);
		return "member/infoUpdate";
	}

	@PostMapping("/InfoUpdateProcess.do")
	public void updateProcess(MemberDto memberDto, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		memberDto.setTell(memberDto.getTellFirst() + "-" + memberDto.getTellMiddle() + "-" + memberDto.getTellLast());

		int result = memberDao.updateMember(memberDto);
		if (result > 0) {
			ScriptWriter.alertAndNext(response, "회원정보가 수정되었습니다.", "../member/List.do");

		} else {
			ScriptWriter.alertAndBack(response, "시스템 오류 입니다. 잠시 후 다시 시도해주세요.");
		}
	}
}
