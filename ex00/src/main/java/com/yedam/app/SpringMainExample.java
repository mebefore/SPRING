package com.yedam.app;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainExample {

	public static void main(String[] args) {
		//spring방식
		//container 기반으로 가져오기
		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:applicationContexts.xml"); //("")안에 bean, xml 넣기
		
		TV tv = (TV)ctx.getBean("tv"); //앞에 (TV)는 인터페이스 변환을 위한 것
		tv.on();
		
	}

}
