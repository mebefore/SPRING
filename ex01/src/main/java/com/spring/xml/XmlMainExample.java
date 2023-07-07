package com.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.anotation.TV;

public class XmlMainExample {
	public static void main(String[] args) {
		//xml집어넣어서 실행하도록하기
		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TV tv = (TV)ctx.getBean("xmlTv");
		tv.on();
	}
}
