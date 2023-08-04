package com.yedam.web.emp.mapper;

import java.util.List;

import com.yedam.web.common.PagingVO;
import com.yedam.web.emp.service.EmpVO;

public interface EmpMapper {
	//총 데이터 조회 
	public int getTotalCount();
	
	//전체조회 - 매개변수 원래 없었으나 페이징 처리 하려면 매개변수 넣어줘야함
	public List<EmpVO> selectEmpAll(PagingVO pagingVO);
}
