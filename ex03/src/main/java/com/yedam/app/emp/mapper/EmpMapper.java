package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	//전체조회
	public List<EmpVO> selectEmpAllList();
	
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empVO); //mapper의 아이디 = selectEmpInfo
	
	
	//등록
	public int insertEmpInfo(EmpVO empVO);
	
	//수정 - 급여를 정해진 비율로 인상
	//두개 이상 매개변수 쓸때 @Param(xml에서 쓸 이름 정하기) - mapper에서만 사용
	public int updateEmpSal(@Param("empId") EmpVO empVO, @Param("raise") int raise);
	
	//수정 - 사원정보를 수정
	public int updateEmpInfo(EmpVO empVO);
	
	//삭제
	public int deleteEmpInfo(int employeeId);
}
