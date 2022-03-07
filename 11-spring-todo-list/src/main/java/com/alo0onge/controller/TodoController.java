package com.alo0onge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alo0onge.model.TodoDao;
import com.alo0onge.model.TodoDto;

@Controller
public class TodoController {

	@Autowired
	TodoDao todoDao;

	@Autowired
	TodoDto todoDto;

	@RequestMapping("/List.do")
	@ResponseBody
	public Map<String, Object> list(@RequestBody TodoDto todoDto) {
		Map<String, Object> hashMap = new HashMap<>();
		List<TodoDto> todoList = null;
		String pickedDate = todoDto.getPickedDate();
		todoList = todoDao.getAllList(pickedDate);
		hashMap.put("todoList", todoList);
		return hashMap;
	}

	@RequestMapping("/Insert.do")
	@ResponseBody // json으로 return
	public Map<String, Object> insertTodo(@RequestBody TodoDto todoDto) { // RequestBody로 데이터 받으면 queryString 형태로 넘어옴
		System.out.println("todoDto===" + todoDto);
		Map<String, Object> hashMap = new HashMap<>();
		List<TodoDto> todoList = null;
		String pickedDate = todoDto.getPickedDate();
		int result = todoDao.insertTodo(todoDto);
		if (result > 0) {
			todoList = todoDao.getAllList(pickedDate);
			hashMap.put("todoList", todoList);
		}
		return hashMap;
	}
}
