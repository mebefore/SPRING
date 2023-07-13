package com.yedam.app.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//조회(데이터, 일반페이지) -> GET
	//등록, 수정, 삭제       -> POST
	
	//전체조회
	@GetMapping("/empList")
	public String getEmpAllList(Model model) { //model data담아서 줄 때
		model.addAttribute("empList", empService.getEmpAll()); //key 값 : empList
		return "emp/empList"; //this is just 경로
		// '/WEB-INF/views/emp/empList.jsp'
	}
	
	//단건조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmp(empVO);
		model.addAttribute("empInfo", findVO);		
		return "emp/empInfo";
	}
	
	//등록 - Form
	@GetMapping("/empInsert")
	public String empInsertForm() { //받을 것, 줄 것 없어서 매개변수 x
		return "emp/empInsert"; //단순 페이지만 요청
	}
	
	
	//등록 - Process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rtt) {
		int empId = empService.insertEmp(empVO);
		String result = null;
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else {
			result = "정상적으로 등록되었습니다"
					+"\n 등록된 사원의 사번은 " + empId + "입니다.";
		}
		rtt.addFlashAttribute("result", result);
		return "redirect:empList";
	}
	
	//수정 - Process, form x
	//1) Client이 보낼 때 JSON으로 보냄  -> Server로 : @RequestBody
	//2) Server도 보낼 때 JSON으로 보냄 -> Client한테 : @ResponseBody
	@PostMapping("/empUpdate")
	@ResponseBody
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO){
		return empService.updateEmp(empVO);
	}
	
	//삭제 - Process
	@PostMapping("/empDelete")
	@ResponseBody
	public String empDeleteProcess(@RequestParam(name = "id") int employeeId) {
		Map<String, String> map = empService.deleteEmp((employeeId));
		return map.get("결과");
	}
	
}
