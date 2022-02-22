package com.alo0onge.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alo0onge.model.SelectDto;
import com.alo0onge.model.keyValueDto;

@Controller
public class TestController02 {

	@GetMapping("/Test06.do")
	public String test06(SelectDto selectDto, Model model) {
		selectDto.setData01("data03");
		selectDto.setData02("kiwi");
		selectDto.setData03("octopus");
		selectDto.setData04("cat");
		selectDto.setData05("kia");

		////////////////////////////////////////////////////
		String fruitList[] = { "apple", "banana", "kiwi" };
		selectDto.setDataList(fruitList);
		model.addAttribute("fruitList", fruitList);

		////////////////////////////////////////////////////////
		ArrayList<String> animalList = new ArrayList<>();
		animalList.add("hippo");
		animalList.add("octopus");
		animalList.add("lion");
		animalList.add("rabbit");

		model.addAttribute("animalList", animalList);

		///////////////////////////////////////////////////////
		keyValueDto keyValueDto01 = new keyValueDto();
		keyValueDto keyValueDto02 = new keyValueDto();
		keyValueDto keyValueDto03 = new keyValueDto();

		keyValueDto01.setKey("사자");
		keyValueDto01.setValue("lion");
		keyValueDto02.setKey("고양이");
		keyValueDto02.setValue("cat");
		keyValueDto03.setKey("토끼");
		keyValueDto03.setValue("rabbit");

		ArrayList<keyValueDto> animalList02 = new ArrayList<>();
		animalList02.add(keyValueDto01);
		animalList02.add(keyValueDto02);
		animalList02.add(keyValueDto03);

		model.addAttribute("animalList02", animalList02);

		return "test06";
	}
}
