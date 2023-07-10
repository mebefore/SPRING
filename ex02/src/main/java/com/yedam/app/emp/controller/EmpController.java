package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@Controller //controller써야 허용되는 하위요소들이 있다.
public class EmpController {
	
	@Autowired
	EmpMapper empMapper;
	
	@RequestMapping(value = "emp", method = RequestMethod.GET) 
	public String empList(Model model, EmpVO empVO) {
		model.addAttribute("emp",empMapper.getEmp(empVO));//"emp"라는 이름으로 보낼 것이다. (jsp)
		return "emp";
	}
}
