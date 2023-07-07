package com.spring.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//필드에서 선언하고 
public class Restaurant {
	
	@Autowired
	Chef chef;
	
	
	public void open() { //호출하기
		chef.cooking();
	}
}
