package com.spring.junit;

import org.springframework.stereotype.Component;

@Component//bean으로 등록되어야 하기에

public class Chef {
	public void cooking() {
		System.out.println("셰프가 요리를 시작합니다.");
	}
}
