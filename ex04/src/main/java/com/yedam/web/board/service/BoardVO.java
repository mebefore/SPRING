package com.yedam.web.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;			//게시물번호 - primary key
	private String title;		//제목 - not null
	private String contents;	//내용
	private String writer;		//작성자
	// default : yyyy/MM/dd -> input[type=date] : yyyy-MM-dd
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;		//등록일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;	//수정일자
	private String image;		//사진
}
