package com.alo0onge.controller;
@Controller
public class HormContrdoller {
 //Spring이 로딩하면서 annotation을 인식시키는 파일이 controller임을 암
	public String home() {
		//business logic 여기에 들어감
		System.out.println();
		return "home"; //return되는 home/WeBInf/views/home .jsp
	}
}
