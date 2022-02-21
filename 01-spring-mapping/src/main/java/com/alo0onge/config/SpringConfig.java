package com.alo0onge.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml
public class SpringConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	// 프로젝트에 사용할 Beans 정의하기 위한 class지정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootAppContext.class }; //config에 있는 파일 이름이랑 같아야 함
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletAppContext.class }; //config에 있는 파일 이름이랑 같아야 함
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// 한글 깨짐 방지....
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] { encodingFilter };
	}
}
