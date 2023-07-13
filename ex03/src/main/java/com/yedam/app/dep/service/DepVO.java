package com.yedam.app.dep.service;

import lombok.Data;

@Data

public class DepVO {
	
	private int departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId; 
	//int타입은 언제나 null이 불가해서 integer로 선언한다.

}
