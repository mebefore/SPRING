package com.spring.anotation;

import org.springframework.stereotype.Component;
//필요한 어노테이션 지정
@Component("tv") //value로 이름 짓기(여러개일 땐)
public class SamsungTV implements TV {

	@Override
	public void on() {
		System.out.println("어노테이션 방식) ");
		System.out.println("삼성 tv를 켭니다.");
	}

}
