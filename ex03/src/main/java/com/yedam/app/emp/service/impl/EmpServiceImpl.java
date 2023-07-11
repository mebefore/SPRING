package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.tx.mapper.AaaMapper;

@Service
//service라서 어노테이션 붙이기(controller - controller)
public class EmpServiceImpl implements EmpService {
	
	
	@Autowired 
	EmpMapper empMapper;
	
	@Autowired 
	AaaMapper aaaMapper;
	
	@Override
	public List<EmpVO> getEmpAll() {
		// TODO Auto-generated method stub
		return empMapper.selectEmpAllList();
	}

	@Override
	public EmpVO getEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmp(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		if(result == 1) {
			return empVO.getEmployeeId();
		}else {
			return -1; //값이 -1이 돌아왔다면 정상적 실행 x
		}
	}

	@Override
	public String updateEmpSal(int empId, int raise) {
		String message = null;
		
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(empId);
		
		int result = empMapper.updateEmpSal(empVO, raise);
		
		if(result == 1) {
			message = "정상적으로 급여를 갱신했습니다.";
		}else {
			message = "작업이 실패했습니다. 정보를 확인해주세요.";
		}
		
		return message; //메세지로 결과를 반환 
	}

	@Override
	public Map<String, String> updateEmp(EmpVO empVO) {
		//보내고자 하는 게 여러개일 때
		Map<String, String> map = new HashMap<>();
		
		map.put("사원번호", String.valueOf(empVO.getEmployeeId()));
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			map.put("결과", "success");	
		}else {
			map.put("결과", "fail");
		}
		
		return map;
	}

	@Override
	public Map<String, String> deleteEmp(int empId) {
		Map<String, String> map = new HashMap<>();
		
		map.put("사원번호", String.valueOf(empId));
		
		int result = empMapper.deleteEmpInfo(empId);
		
		if(result == 1) {
			map.put("결과", "success");	
		}else {
			map.put("결과", "fail");
		}
		
		return map;
	}

}
