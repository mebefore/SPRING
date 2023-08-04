package com.yedam.web.common;

import lombok.Getter;

@Getter

public class PagingVO {
	private final static int defaulVal = 10; //값을 고정시킬 때 쓴다(?)
	
	private int totalData; //현재 총 데이터 수 
	
	private int nowPage;	//현재페이지
	private int cntPage = 10;	//view 안에서 보여줄 페이지 수 (시작과 끝 페이지 영향받음) 우리가 보여줄 페이지 수를 정해줘야함 
	//모든 페이지가 1~10개 보여줌 1|2|3|4|5 이렇게 가틈
	private int startPage;	//현재 보여지는 페이지의 시작 페이지
	private int endPage;	//끝페이지 

	
	private int cntPerPage = 10;	//한페이지 안에 보여줄 데이터 수, 한 페이지에 글 몇개(?)
	private int lastPage; 	//마지막 페이지
	private int start;	// 현재 페이지 안에 보여줄 첫번째 데이터
	private int end;	// 현재 페이지 안에 보여줄 마지막 데이터 g
	
	public PagingVO(int totalData, int nowPage, int  cntPerPage) { //데이터를 받아와서 처리해야돼서 생성자 3개 생성
		this.totalData = totalData;
		this.nowPage = nowPage;
		this.cntPerPage = cntPerPage; 	//받아온 값 필드에 넣기
		calcLastPage();
		calcStartEndPage();
		calcStartEnd();
	}
	
	public PagingVO(int totalData, int nowPage) {
		this(totalData, nowPage, defaulVal);
	}
	
	//제일 마지막 페이지 계산
	private void calcLastPage() { // 숨겨진 메소드로 처리 
		this.lastPage = (int)Math.ceil((double)this.totalData / (double)this.cntPerPage);
		//int끼리 계산하면 소수점 제대로 안 나옴 그래서 double로 강제형변환 후 올림 처리(Math.ceil) 
		//Math.ceil은 기본적으로 double값 반환이라 int로 또 형 변환 
		
	}
	//현재 View 안 시작, 끝 페이지 계산
	private void calcStartEndPage() {
		this.endPage = (int)Math.ceil((double)this.nowPage/(double)this.cntPage) * this.cntPage;
		//end 페이지는 last페이지 보다 클 수 있으니까 후처리
		if(this.endPage > this.lastPage) {
			this.endPage = this.lastPage;
		}
		
		this.startPage = (this.endPage - this.cntPage) + 1;
		if(this.startPage < 1) {
			this.startPage = 1;
		}
	}
	
	//현재페이지 안에 보여질 첫번째 데이터와 마지막 데이터 -> DB 쿼리 안에 사용할 start, end
	private void calcStartEnd() {
		this.start = ((this.nowPage -1 ) * this.cntPerPage) + 1;
		this.end = this.nowPage * this.cntPerPage;
		 if(this.end > this.totalData) {
			 this.end = this.totalData;
		 }
		
	}
}
