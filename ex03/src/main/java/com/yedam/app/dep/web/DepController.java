package com.yedam.app.dep.web;

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

import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Controller
public class DepController {
	
	@Autowired
	DepService depService;
	
	//전체조회 - 조회는 get, post는..body를 원한다 (?)
		@GetMapping("/depList")
		public String getDepAllList(Model model) { //model data담아서 줄 때
			model.addAttribute("depList", depService.getDepAll()); //key 값 : depList
			return "dep/depList"; //this is just 경로
			// '/WEB-INF/views/emp/empList.jsp'
		} //완
		
		//단건조회
		@GetMapping("/depInfo")
		public String getDepInfo(DepVO depVO, Model model) {
			DepVO findVO = depService.getDep(depVO);
			model.addAttribute("depInfo", findVO);		
			return "dep/depInfo";
		}//완
		
		//등록 - Form
		@GetMapping("/depInsert")
		public String depInsertForm() { //받을 것, 줄 것 없어서 매개변수 x
			return "dep/depInsert"; //단순 페이지만 요청
		}
		
		
		//등록 - Process
		@PostMapping("/depInsert")
		public String depInsertProcess(DepVO depVO, RedirectAttributes rtt) {
			int depId = depService.insertDep(depVO);
			String uri = null;
			String result = null;
			if(depId == -1) {
				result = "정상적으로 등록되지 않았습니다.";
				uri = "depList";
			}else {
				result = "정상적으로 등록되었습니다"
						+"\n 등록된 부서의 번호는 " + depId + "입니다.";

			}
			rtt.addFlashAttribute("result", result);
			return "redirect:depList";
		}
		
		//수정 - Process, form x
		//1) Client이 보낼 때 JSON으로 보냄  -> Server로 : @RequestBody
		//2) Server도 보낼 때 JSON으로 보냄 -> Client한테 : @ResponseBody
		@PostMapping("/depUpdate")
		@ResponseBody
		public Map<String, String> depUpdateProcess(@RequestBody DepVO depVO){
			return depService.updateDepInfo(depVO);
		}
		
		//삭제 - Process
		@PostMapping("/depDelete")
		@ResponseBody
		public String depDeleteProcess(@RequestParam(name = "id") int departmentId) {
			Map<String, String> map = depService.deleteDepInfo((departmentId));
			return map.get("결과");
		}
}
