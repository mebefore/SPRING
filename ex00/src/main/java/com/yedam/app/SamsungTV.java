package com.yedam.app;

//TV interface를 구현하는 class
public class SamsungTV implements TV {
	
	@Override
	public void on() {
		System.out.println("삼성TV를 켰습니다.");
	}
}
