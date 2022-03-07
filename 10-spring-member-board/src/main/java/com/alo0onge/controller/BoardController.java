package com.alo0onge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alo0onge.model.MemberDto;
import com.alo0onge.model.ReplyBoardDto;
import com.alo0onge.model.ReplyBoardService;
import com.alo0onge.util.PageWriter;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	ReplyBoardService replyBoardDao;
	@Autowired
	ReplyBoardDto replyBoardDto;
	@Autowired
	ReplyBoardDto prevBoardDto;
	@Autowired
	ReplyBoardDto nextBoardDto;

	@GetMapping("/List.do")
	public String list(HttpServletRequest request, Model model) {

		String tempClickPage = request.getParameter("clickPage");
		String search_select = request.getParameter("search_select");
		String search_word = request.getParameter("search_word");
		if (tempClickPage == null)
			tempClickPage = "1";
		int clickPage = Integer.parseInt(tempClickPage);
		if(search_select==null) {
			search_select="";
		}
		if(search_word==null) {
			search_word="aaa";
		}
		
		System.out.println("search_word==="+search_word);
		int totalPage = replyBoardDao.getTotal(search_select, search_word);
		int listPerPage = 5; // table의 줄 수
		int pageBlock = 3; // 아래쪽 page number의 한번에 뿌려지는 갯수

		int start = (clickPage - 1) * listPerPage + 1;
		int end = start + listPerPage - 1;

		
		  List<ReplyBoardDto> boardList = replyBoardDao.getAllList(start, end,
		  search_select, search_word); String page = PageWriter.pageWrite(totalPage,
		  listPerPage, pageBlock, clickPage, "../board/List.do");
		  
		  model.addAttribute("boardList", boardList); model.addAttribute("page", page);
		  model.addAttribute("totalPage", totalPage); model.addAttribute("listPerPage",
		  listPerPage); model.addAttribute("pageBlock", pageBlock);
		  model.addAttribute("clickPage", clickPage);
		

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
	public String view(int no, int num, Model model) {
		replyBoardDto = replyBoardDao.getSelectOne(no);
		prevBoardDto = replyBoardDao.getPrevSelect(num);
		nextBoardDto = replyBoardDao.getNextSelect(num);

		model.addAttribute("replyBoardDto", replyBoardDto);
		model.addAttribute("prevBoardDto", prevBoardDto);
		model.addAttribute("nextBoardDto", nextBoardDto);
		return "board/view";
	}

}
