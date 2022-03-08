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
		return hashMap; //hashmap리턴해도 되고 list리턴 해도 됨, 단 리스트 떨구면 자바스크립트에서 foreach문에 res 바로 쓰면 됨
	}
	
	@RequestMapping("/List.do")
	@ResponseBody
	public Map<String, Object> getTodoList(@RequestBody TodoDto todoDto){
		Map<String, Object> hashMap = new HashMap<>();
		String pickedDate = todoDto.getPickedDate();
		List<TodoDto> todoList = todoDao.getAllList(pickedDate); //해당 날짜 리스트 뽑아서 던져주기
		hashMap.put("todoList", todoList);
		return  hashMap;
	}
	
	@RequestMapping("/Delete.do")
	@ResponseBody
	public Map<String, Object> deleteTodo(@RequestBody TodoDto todoDto){
		Map<String, Object> hashMap = new HashMap<>();
		int no = todoDto.getNo();
		int result = todoDao.deleteTodo(no);
		hashMap.put("result", result); //ex. {result: 1}
		return  hashMap;
	}
	
	@RequestMapping("/Update.do")
	@ResponseBody
	public Map<String, Object> updateTodo(@RequestBody TodoDto todoDto){
		Map<String, Object> hashMap = new HashMap<>();
		int result = todoDao.updateTodo(todoDto);
		hashMap.put("result", result); //ex. {result: 1}
		return  hashMap;
	}
}
