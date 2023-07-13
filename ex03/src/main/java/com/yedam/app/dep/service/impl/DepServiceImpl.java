package com.yedam.app.dep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dep.mapper.DepMapper;
import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Service
public class DepServiceImpl implements DepService {

	//mapper 호출
	@Autowired
	DepMapper depMapper;
	
	
	@Override
	public List<DepVO> getDepAll() {
		// TODO Auto-generated method stub
		return depMapper.selectDepAllList();
	}

	@Override
	public DepVO getDep(DepVO depVO) {
		// TODO Auto-generated method stub
		return depMapper.selectDepInfo(depVO);
	}

	@Override
	public int insertDep(DepVO depVO) {
		int result = depMapper.insertDepInfo(depVO);
		if(result == 1) {
			return depVO.getDepartmentId();
		}else {
			return -1;
		}
	}

	@Override
	public String updateDepId(int depId, int raise) {
		
		String message = null;
		
		DepVO depVO = new DepVO();
		depVO.setDepartmentId(depId);
		
		int result = depMapper.updateDepId(depVO, raise);
		
		if(result == 1) {
			message = "정상적으로 부서를 갱신했습니다.";
		}else {
			message = "작업이 실패했습니다. 정보를 확인해주세요.";
		}
		
		return message; //메세지로 결과를 반환 
	}

	@Override
	public Map<String, String> updateDepInfo(DepVO depVO) {
		//보내고자 하는 게 여러개일 때
		Map<String, String> map = new HashMap<>();
		//map이라는 변수.. return에 map 미리 넣어놓기..
		
		map.put("부서번호", String.valueOf(depVO.getDepartmentId()));
		
		int result = depMapper.updateDepInfo(depVO);
		
		if(result > 0) {
			map.put("결과", "success");	
		}else {
			map.put("결과", "fail");
		}
		
		return map;
	}

	@Override
	public Map<String, String> deleteDepInfo(int depId) {
	Map<String, String> map = new HashMap<>();
		
		map.put("부서번호", String.valueOf(depId));
		
		int result = depMapper.deleteDepInfo(depId);
		
		if(result == 1 ) {
			map.put("결과", "success");	
		}else {
			map.put("결과", "fail");
		}
		
		return map;
	}

}
