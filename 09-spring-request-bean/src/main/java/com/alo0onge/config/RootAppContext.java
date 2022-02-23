package com.alo0onge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alo0onge.model.BoardDto;
import com.alo0onge.model.DataDto02;

@Configuration
public class RootAppContext {
	
	//직접등록 (servletappcontext에 쓰는 건 자동등록)
	//직접 등록은 클래스에 component 안 붙여도 됨
	@Bean
	public DataDto02 dataDto02() {
		return new DataDto02();
	}
	
	@Bean
	public BoardDto boardDto() {
		return new BoardDto();
	}
}
