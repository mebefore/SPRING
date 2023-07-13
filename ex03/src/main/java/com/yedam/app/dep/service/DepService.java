package com.yedam.app.dep.service;

import java.util.List;
import java.util.Map;

public interface DepService {
	//DepMapper.java와 유사
	
	//전체조회
	public List<DepVO> getDepAll(); //리스트
	
	//단건조회
	public DepVO getDep(DepVO depVO); //하나의 객체
	
	//등록
	public int insertDep(DepVO depVO);
	
	//수정 - 급여 갱신
	public String updateDepId(int depId, int raise);
	
	//수정 - 사원 정보
	public Map<String, String> updateDepInfo(DepVO depVO);
	
	//삭제
	public Map<String, String> deleteDepInfo(int depId);
}
