package com.yedam.app.dep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.dep.service.DepVO;

public interface DepMapper {
	
	//전체조회
	public List<DepVO> selectDepAllList(); //반환하는 값이 1건 이상이기에 list type
	//전체 조회 제외하고 모두 매개변수 필요하다(VO 객체 기반으로)
	
	//단건조회
	public DepVO selectDepInfo(DepVO depVO); //의도적으로 하나만 반환
	
	//등록
	public int insertDepInfo(DepVO depVO); // (DepVO, depVO = 매개변수)
	//return 값은 정수이기 때문에 int로 선언
	
	//수정 - id 수정
	public int updateDepId(@Param("dep") DepVO depVO, @Param("raise") int raise);
	//기본정보가 필요해서 vo객체를 이용
	
	//수정 - 사원정보를 수정
	public int updateDepInfo(DepVO depVO);
		
	//삭제
	public int deleteDepInfo(int departmentId);
	
}
